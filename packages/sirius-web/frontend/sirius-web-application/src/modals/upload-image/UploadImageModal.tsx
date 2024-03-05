/*******************************************************************************
 * Copyright (c) 2022, 2024 Obeo.
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
import { gql } from '@apollo/client';
import {
  ImageUploadForm,
  LabeledFile,
  ServerContext,
  ServerContextValue,
  Toast,
  sendFile,
} from '@eclipse-sirius/sirius-components-core';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogTitle from '@material-ui/core/DialogTitle';

import { useMachine } from '@xstate/react';
import { useContext, useEffect, useState } from 'react';
import {
  GQLErrorPayload,
  GQLUploadImageMutationVariables,
  GQLUploadImagePayload,
  UploadImageModalProps,
} from './UploadImageModal.types';
import {
  HandleResponseEvent,
  HideToastEvent,
  RequestImageUploadingEvent,
  SchemaValue,
  SelectImageEvent,
  ShowToastEvent,
  UploadImageModalContext,
  UploadImageModalEvent,
  uploadImageModalMachine,
} from './UploadImageModalMachine';

const uploadImageMutationFile = gql`
  mutation uploadImage($input: UploadImageInput!) {
    uploadImage(input: $input) {
      __typename
      ... on UploadImageSuccessPayload {
        id
      }
      ... on ErrorPayload {
        message
      }
    }
  }
`.loc.source.body;

const isErrorPayload = (payload: GQLUploadImagePayload): payload is GQLErrorPayload =>
  payload.__typename === 'ErrorPayload';

export const UploadImageModal = ({ projectId, onImageUploaded, onClose }: UploadImageModalProps) => {
  const { httpOrigin } = useContext<ServerContextValue>(ServerContext);
  const [{ value, context }, dispatch] = useMachine<UploadImageModalContext, UploadImageModalEvent>(
    uploadImageModalMachine
  );
  const [label, setLabel] = useState<string>('');

  const { toast, uploadImageModal } = value as SchemaValue;
  const { file, message } = context;

  // Execute the upload of a image and redirect to the newly created image
  const uploadImage = async () => {
    const requestImageUploadingEvent: RequestImageUploadingEvent = { type: 'REQUEST_IMAGE_UPLOADING' };
    dispatch(requestImageUploadingEvent);

    const variables: GQLUploadImageMutationVariables = {
      input: {
        id: crypto.randomUUID(),
        editingContextId: projectId,
        label,
        file: null, // the file will be send as a part of the multipart POST query.
      },
    };
    try {
      const { data, error } = await sendFile(httpOrigin, uploadImageMutationFile, variables, file);
      if (error) {
        const showToastEvent: ShowToastEvent = {
          type: 'SHOW_TOAST',
          message: error.message,
        };
        dispatch(showToastEvent);
      }
      if (data) {
        const event: HandleResponseEvent = { type: 'HANDLE_RESPONSE', data };
        dispatch(event);

        const { uploadImage } = data;
        if (isErrorPayload(uploadImage)) {
          const { message } = uploadImage;
          const showToastEvent: ShowToastEvent = { type: 'SHOW_TOAST', message };
          dispatch(showToastEvent);
        }
      }
    } catch (exception) {
      // Handle other errors like max file size error send by the backend...
      const showToastEvent: ShowToastEvent = { type: 'SHOW_TOAST', message: exception.toString() };
      dispatch(showToastEvent);
    }
  };

  const onFileSelected = (f: LabeledFile) => {
    setLabel(f.label);
    if (f.file) {
      const selectImageEvent: SelectImageEvent = { type: 'SELECT_IMAGE', file: f.file };
      dispatch(selectImageEvent);
    }
  };

  useEffect(() => {
    if (uploadImageModal === 'success') {
      onImageUploaded();
    }
  }, [uploadImageModal, onImageUploaded]);

  const canSubmit = uploadImageModal === 'imageSelected' && label && label !== '';
  return (
    <>
      <Dialog open={true} onClose={onClose} aria-labelledby="dialog-title" fullWidth>
        <DialogTitle id="dialog-title">Upload new image</DialogTitle>
        <DialogContent>
          <ImageUploadForm disabled={uploadImageModal === 'uploadingImage'} onChange={onFileSelected} />
        </DialogContent>
        <DialogActions>
          <Button
            variant="contained"
            disabled={!canSubmit}
            color="primary"
            form="upload-form-id"
            data-testid="upload-image"
            onClick={() => uploadImage()}>
            Upload
          </Button>
        </DialogActions>
      </Dialog>
      <Toast
        message={message}
        open={toast === 'visible'}
        onClose={() => dispatch({ type: 'HIDE_TOAST' } as HideToastEvent)}
      />
    </>
  );
};
