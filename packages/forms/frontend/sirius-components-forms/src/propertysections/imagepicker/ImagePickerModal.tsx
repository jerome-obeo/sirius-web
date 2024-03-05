/*******************************************************************************
 * Copyright (c) 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

import React from 'react';
import {
  Box,
  Button,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Tab,
  Tabs,
  Theme,
  makeStyles,
} from '@material-ui/core';
import CloudIcon from '@material-ui/icons/Cloud';
import FolderIcon from '@material-ui/icons/Folder';
import ImageIcon from '@material-ui/icons/Image';

import { useContext, useEffect, useState } from 'react';
import { useProjectImages } from './ImagePickerHooks';
import { ImagePickerModalProps, ImagePickerModalState, ImagePickerModalTab } from './ImagePickerModal.types';
import { ImagePickerGalleryTab } from './ImagePickerGalleryTab';
import { ImagePickerLinkTab } from './ImagePickerLinkTab';
import { ImageUploadForm, useMultiToast } from '@eclipse-sirius/sirius-components-core';
import { GQLErrorPayload, GQLUploadImageMutationVariables, GQLUploadImagePayload } from './ImagePickerModal.types';
import { sendFile } from '@eclipse-sirius/sirius-components-core';
import { gql } from '@apollo/client';
import { ServerContextValue } from '@eclipse-sirius/sirius-components-core';
import { ServerContext } from '@eclipse-sirius/sirius-components-core';
import { GQLCustomImage } from './ImagePickerPropertySection.types';

const useImagePickerModalStyles = makeStyles<Theme>((_) => ({
  root: {
    minHeight: '600px',
  },
  paper: {
    maxWidth: '750px',
  },
}));

interface TabPanelProps {
  children?: React.ReactNode;
  index: ImagePickerModalTab;
  value: ImagePickerModalTab;
}

function TabPanel(props: TabPanelProps) {
  const { children, value, index, ...other } = props;

  return (
    <div role="tabpanel" data-testid={`imagepicker-modal-tab-${index}`} hidden={value !== index} {...other}>
      {value === index && <Box p={3}>{children}</Box>}
    </div>
  );
}

const uploadImageMutationFile = gql`
  mutation uploadImage($input: UploadImageInput!) {
    uploadImage(input: $input) {
      __typename
      ... on UploadImageSuccessPayload {
        imageId
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`.loc.source.body;

const isErrorPayload = (payload: GQLUploadImagePayload): payload is GQLErrorPayload =>
  payload.__typename === 'ErrorPayload';

export const ImagePickerModal = ({ editingContextId, open, tab, onClose, onSelectImage }: ImagePickerModalProps) => {
  const classes = useImagePickerModalStyles();
  const { addErrorMessage } = useMultiToast();
  const { httpOrigin } = useContext<ServerContextValue>(ServerContext);
  const [getProjectImages, projectImages, loading] = useProjectImages(editingContextId);
  const [state, setState] = useState<ImagePickerModalState>({
    activeTab: tab,
    selectedImage: null,
    fileToImport: null,
    urlToUpload: null,
  });

  useEffect(() => {
    handleTabChange(tab);
  }, [open]);

  const handleTabChange = (tab: ImagePickerModalTab) => {
    if (tab === ImagePickerModalTab.GALLERY) {
      getProjectImages();
    }
    setState((prevState) => ({ ...prevState, activeTab: tab }));
  };

  // Execute the upload of a image and redirect to the newly created image
  const uploadImage = async (): Promise<GQLCustomImage> => {
    const id = crypto.randomUUID();

    const variables: GQLUploadImageMutationVariables = {
      input: {
        id,
        editingContextId: editingContextId,
        label: state.fileToImport.label,
        file: null, // the file will be send as a part of the multipart POST query.
      },
    };
    let errorMessage: string | null = null;
    try {
      const { data, error } = await sendFile(httpOrigin, uploadImageMutationFile, variables, state.fileToImport.file);
      if (error) {
        errorMessage = error.message;
      }
      if (data) {
        const { uploadImage } = data;
        if (isErrorPayload(uploadImage)) {
          errorMessage = uploadImage.message;
        } else {
          const newImage: GQLCustomImage = {
            label: state.fileToImport.label,
            id: uploadImage.imageId,
            url: `/custom/${uploadImage.imageId}`,
          };
          return Promise.resolve(newImage);
        }
      }
    } catch (exception) {
      // Handle other errors like max file size error send by the backend...
      errorMessage = exception.toString();
    }
    return Promise.reject(errorMessage);
  };

  const handleSelect = () => {
    if (state.activeTab === ImagePickerModalTab.GALLERY) {
      if (state.selectedImage) {
        onSelectImage(state.selectedImage.id);
      }
    } else if (state.activeTab === ImagePickerModalTab.LINK) {
      // TODO handle properly when the Link tab is available
    } else if (state.activeTab === ImagePickerModalTab.IMPORT) {
      if (state.fileToImport) {
        uploadImage()
          .then((img) => onSelectImage(img.id))
          .catch((reason) => addErrorMessage(reason));
      }
    }
    onClose();
  };

  const canSelect = (): boolean => {
    if (state.activeTab === ImagePickerModalTab.GALLERY) {
      return !!state.selectedImage;
    } else if (state.activeTab === ImagePickerModalTab.LINK) {
      // TODO handle properly when the Link tab is available
      return false;
    } else if (state.activeTab === ImagePickerModalTab.IMPORT) {
      return (
        state.fileToImport &&
        state.fileToImport.label &&
        state.fileToImport.label !== '' &&
        state.fileToImport.file !== null
      );
    }
    return false;
  };

  return (
    <Dialog open={open} fullWidth onClose={() => onClose()} classes={{ paper: classes.paper }}>
      <DialogTitle>Select an image </DialogTitle>
      <DialogContent className={classes.root}>
        <Tabs
          value={state.activeTab}
          onChange={(_, value) => handleTabChange(value)}
          indicatorColor="primary"
          textColor="primary"
          centered>
          <Tab
            icon={<ImageIcon />}
            label="Gallery"
            value={ImagePickerModalTab.GALLERY}
            data-testid="imagepicker-gallery-tab"
          />
          <Tab icon={<CloudIcon />} label="Link" value={ImagePickerModalTab.LINK} data-testid="imagepicker-link-tab" />
          <Tab
            icon={<FolderIcon />}
            label="Import"
            value={ImagePickerModalTab.IMPORT}
            data-testid="imagepicker-import-tab"
          />
        </Tabs>
        <TabPanel value={state.activeTab} index={ImagePickerModalTab.GALLERY}>
          {loading ? (
            <span>Loading gallery images...</span>
          ) : (
            <ImagePickerGalleryTab
              images={projectImages}
              selection={state.selectedImage}
              onSelection={(img) => setState((prevState) => ({ ...prevState, selectedImage: img }))}
            />
          )}
        </TabPanel>
        <TabPanel value={state.activeTab} index={ImagePickerModalTab.LINK}>
          <ImagePickerLinkTab />
        </TabPanel>
        <TabPanel value={state.activeTab} index={ImagePickerModalTab.IMPORT}>
          <ImageUploadForm onChange={(file) => setState((prevState) => ({ ...prevState, fileToImport: file }))} />
        </TabPanel>
      </DialogContent>
      <DialogActions>
        <Button
          variant="contained"
          color="primary"
          type="button"
          disabled={!canSelect()}
          data-testid="imagepicker-dialog-select-button"
          onClick={handleSelect}>
          Select
        </Button>
      </DialogActions>
    </Dialog>
  );
};
