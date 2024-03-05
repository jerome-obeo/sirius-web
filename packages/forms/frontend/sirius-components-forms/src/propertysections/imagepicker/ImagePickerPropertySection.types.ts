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
import { GQLMessage, GQLImagePicker, GQLSubscriber } from '../../form/FormEventFragments.types';
import { ImagePickerModalTab } from './ImagePickerModal.types';

export interface ImagePickerStyleProps {
  color: string | null;
  fontSize: number | null;
  italic: boolean | null;
  bold: boolean | null;
  underline: boolean | null;
  strikeThrough: boolean | null;
}

export interface ImagePickerPropertySectionProps {
  editingContextId: string;
  formId: string;
  widget: GQLImagePicker;
  subscribers: GQLSubscriber[];
  readOnly: boolean;
}

export interface GQLAddImageMutationData {
  addImage: GQLAddImagePayload;
}

export interface GQLAddImagePayload {
  __typename: string;
}

export interface GQLAddImageMutationVariables {
  input: GQLAddImageInput;
}

export interface GQLAddImageInput {
  id: string;
  editingContextId: string;
  representationId: string;
  imagePickerId: string;
  imageId: string;
}

export interface GQLRemoveImageMutationData {
  removeImage: GQLRemoveImagePayload;
}

export interface GQLRemoveImagePayload {
  __typename: string;
}

export interface GQLRemoveImageMutationVariables {
  input: GQLRemoveImageInput;
}

export interface GQLRemoveImageInput {
  id: string;
  editingContextId: string;
  representationId: string;
  imagePickerId: string;
  imageId: string;
}

export interface GQLErrorPayload extends GQLAddImagePayload, GQLRemoveImagePayload {
  messages: GQLMessage[];
}

export interface GQLSuccessPayload extends GQLAddImagePayload {
  messages: GQLMessage[];
}

export interface GQLGetProjectImagesQueryVariables {
  projectId: string;
}

export interface GQLGetProjectImagesQueryData {
  viewer: GQLViewer;
}

export interface GQLViewer {
  project: GQLProject;
}

export interface GQLProject {
  id: string;
  customImages: GQLCustomImage[];
}

export interface GQLCustomImage {
  id: string;
  label: string;
  url: string;
}

export interface ImagePickerState {
  modalOpen: boolean;
  modalTab: ImagePickerModalTab;
}
