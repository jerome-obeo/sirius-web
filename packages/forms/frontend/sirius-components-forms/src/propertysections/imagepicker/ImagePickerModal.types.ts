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

import { LabeledFile } from '@eclipse-sirius/sirius-components-core';
import { GQLCustomImage } from './ImagePickerPropertySection.types';

export enum ImagePickerModalTab {
  GALLERY,
  LINK,
  IMPORT,
}

export interface ImagePickerModalProps {
  editingContextId: string;
  open: boolean;
  tab: ImagePickerModalTab;
  onClose: () => void;
  onSelectImage?: (newImage: string) => void;
}

export interface ImagePickerModalState {
  activeTab: ImagePickerModalTab;
  selectedImage: GQLCustomImage | null;
  fileToImport: LabeledFile | null;
  urlToUpload: any | null; //TODO change any with more specific type
}

export interface GQLUploadImageMutationVariables {
  input: GQLUploadImageMutationInput;
}

export interface GQLUploadImageMutationInput {
  id: string;
  editingContextId: string;
  label: string;
  file: File;
}

export interface GQLUploadImageMutationData {
  uploadImage: GQLUploadImagePayload;
}

export interface GQLUploadImagePayload {
  __typename: string;
  imageId: string;
}

export interface GQLErrorPayload extends GQLUploadImagePayload {
  message: string;
}
