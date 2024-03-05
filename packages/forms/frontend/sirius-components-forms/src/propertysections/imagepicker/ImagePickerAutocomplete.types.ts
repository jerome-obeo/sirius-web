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
import { GQLImagePicker } from '../../form/FormEventFragments.types';
import { GQLCustomImage } from './ImagePickerPropertySection.types';

export interface ImagePickerAutocompleteProps {
  editingContextId: string;
  formId: string;
  widget: GQLImagePicker;
  readOnly: boolean;
  onMoreClick: () => void;
  onAddClick: () => void;
  onClearClick: () => void;
  addImage: (newImage: string) => void;
  removeImage: (image: string) => void;
}

export interface ImagePickerAutocompleteState {
  open: boolean;
  options: GQLCustomImage[] | null;
  values: GQLCustomImage[];
}
