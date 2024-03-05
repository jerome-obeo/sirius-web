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
import { Theme, makeStyles } from '@material-ui/core/styles';
import {
  GQLAddImageMutationData,
  GQLAddImageMutationVariables,
  GQLAddImagePayload,
  GQLErrorPayload,
  GQLRemoveImageMutationData,
  GQLRemoveImageMutationVariables,
  GQLRemoveImagePayload,
  GQLSuccessPayload,
  ImagePickerPropertySectionProps,
  ImagePickerState,
  ImagePickerStyleProps,
} from './ImagePickerPropertySection.types';
import { PropertySectionLabel } from '../PropertySectionLabel';
import { getCSSColor, useMultiToast } from '@eclipse-sirius/sirius-components-core';
import { getTextDecorationLineValue } from '../getTextDecorationLineValue';
import { ImagePickerAutocomplete } from './ImagePickerAutocomplete';
import { gql, useMutation } from '@apollo/client';
import { useEffect, useState } from 'react';
import { ImagePickerModal } from './ImagePickerModal';
import { ImagePickerModalTab } from './ImagePickerModal.types';

export const addImageMutation = gql`
  mutation addImage($input: AddImageInput!) {
    addImage(input: $input) {
      __typename
      ... on ErrorPayload {
        messages {
          body
          level
        }
      }
      ... on SuccessPayload {
        messages {
          body
          level
        }
      }
    }
  }
`;

export const removeImageMutation = gql`
  mutation removeImage($input: RemoveImageInput!) {
    removeImage(input: $input) {
      __typename
      ... on ErrorPayload {
        messages {
          body
          level
        }
      }
      ... on SuccessPayload {
        messages {
          body
          level
        }
      }
    }
  }
`;

const useImagePickerPropertySectionStyles = makeStyles<Theme, ImagePickerStyleProps>((theme) => ({
  root: {
    overflow: 'hidden',
  },
  style: {
    color: ({ color }) => (color ? getCSSColor(color, theme) : null),
    fontSize: ({ fontSize }) => (fontSize ? fontSize : null),
    fontStyle: ({ italic }) => (italic ? 'italic' : null),
    fontWeight: ({ bold }) => (bold ? 'bold' : null),
    textDecorationLine: ({ underline, strikeThrough }) => getTextDecorationLineValue(underline, strikeThrough),
  },
}));

const isErrorPayload = (payload: GQLAddImagePayload | GQLRemoveImagePayload): payload is GQLErrorPayload =>
  payload.__typename === 'ErrorPayload';
const isSuccessPayload = (payload: GQLAddImagePayload | GQLRemoveImagePayload): payload is GQLSuccessPayload =>
  payload.__typename === 'SuccessPayload';

export const ImagePickerPropertySection = ({
  editingContextId,
  formId,
  widget,
  subscribers,
  readOnly,
}: ImagePickerPropertySectionProps) => {
  const props: ImagePickerStyleProps = {
    color: widget.style?.color ?? null,
    fontSize: widget.style?.fontSize ?? null,
    italic: widget.style?.italic ?? null,
    bold: widget.style?.bold ?? null,
    underline: widget.style?.underline ?? null,
    strikeThrough: widget.style?.strikeThrough ?? null,
  };
  const classes = useImagePickerPropertySectionStyles(props);
  const { addErrorMessage, addMessages } = useMultiToast();
  const [state, setState] = useState<ImagePickerState>({ modalOpen: false, modalTab: ImagePickerModalTab.GALLERY });

  const [addImage, { loading: addLoading, error: addError, data: addData }] = useMutation<
    GQLAddImageMutationData,
    GQLAddImageMutationVariables
  >(addImageMutation);
  useEffect(() => {
    if (!addLoading) {
      if (addError) {
        addErrorMessage('An unexpected error has occurred, please refresh the page');
      }
      if (addData) {
        const { addImage } = addData;
        if (isErrorPayload(addImage) || isSuccessPayload(addImage)) {
          addMessages(addImage.messages);
        }
      }
    }
  }, [addLoading, addError, addData]);

  const [removeImage, { loading: removeLoading, error: removeError, data: removeData }] = useMutation<
    GQLRemoveImageMutationData,
    GQLRemoveImageMutationVariables
  >(removeImageMutation);
  useEffect(() => {
    if (!removeLoading) {
      if (removeError) {
        addErrorMessage('An unexpected error has occurred, please refresh the page');
      }
      if (removeData) {
        const { removeImage } = removeData;
        if (isErrorPayload(removeImage) || isSuccessPayload(removeImage)) {
          addMessages(removeImage.messages);
        }
      }
    }
  }, [removeLoading, removeError, removeData]);

  const callAddImageMutation = (newImage: string) => {
    if (newImage) {
      const variables = {
        input: {
          id: crypto.randomUUID(),
          editingContextId,
          representationId: formId,
          imagePickerId: widget.id,
          imageId: newImage,
        },
      };
      addImage({ variables });
    }
  };

  const callRemoveImageMutation = (image: string) => {
    if (image) {
      const variables = {
        input: {
          id: crypto.randomUUID(),
          editingContextId,
          representationId: formId,
          imagePickerId: widget.id,
          imageId: image,
        },
      };
      removeImage({ variables });
    }
  };

  const handleBrowseImages = () => {
    setState((prevState) => ({ ...prevState, modalOpen: true, modalTab: ImagePickerModalTab.GALLERY }));
  };

  const handleAddImage = () => {
    setState((prevState) => ({ ...prevState, modalOpen: true, modalTab: ImagePickerModalTab.IMPORT }));
  };

  const handleClearImages = () => {
    widget.images.forEach((image) => callRemoveImageMutation(image));
  };

  return (
    <>
      <div className={classes.root}>
        <PropertySectionLabel
          editingContextId={editingContextId}
          formId={formId}
          widget={widget}
          subscribers={subscribers}
        />
        <ImagePickerAutocomplete
          editingContextId={editingContextId}
          formId={formId}
          widget={widget}
          readOnly={readOnly}
          onMoreClick={handleBrowseImages}
          onAddClick={handleAddImage}
          onClearClick={handleClearImages}
          addImage={callAddImageMutation}
          removeImage={callRemoveImageMutation}
        />
      </div>
      <ImagePickerModal
        editingContextId={editingContextId}
        open={state.modalOpen}
        tab={state.modalTab}
        onClose={() => setState((prevState) => ({ ...prevState, modalOpen: false }))}
        onSelectImage={callAddImageMutation}
      />
    </>
  );
};
