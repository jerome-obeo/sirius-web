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
package org.eclipse.sirius.components.forms.components;

import java.util.Objects;

import org.eclipse.sirius.components.forms.description.ImagePickerDescription;
import org.eclipse.sirius.components.representations.IProps;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * The properties of the image picker component.
 *
 * @author Jerome Gout
 */
public class ImagePickerComponentProps implements IProps {
    private VariableManager variableManager;

    private ImagePickerDescription imagePickerDescription;

    public ImagePickerComponentProps(VariableManager variableManager, ImagePickerDescription imagePickerDescription) {
        this.variableManager = Objects.requireNonNull(variableManager);
        this.imagePickerDescription = Objects.requireNonNull(imagePickerDescription);
    }

    public VariableManager getVariableManager() {
        return this.variableManager;
    }

    public ImagePickerDescription getImagePickerDescription() {
        return this.imagePickerDescription;
    }
}
