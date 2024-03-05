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
package org.eclipse.sirius.components.view.emf.form;

import java.util.Objects;
import java.util.function.Function;

import org.eclipse.sirius.components.forms.ImagePickerStyle;
import org.eclipse.sirius.components.forms.ImagePickerStyle.Builder;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.view.FixedColor;
import org.eclipse.sirius.components.view.form.ImagePickerDescriptionStyle;

/**
 * The style provider for the Image Picker Description widget of the View DSL.
 *
 * @author Jerome Gout
 */
public class ImagePickerStyleProvider implements Function<VariableManager, ImagePickerStyle> {

    private final ImagePickerDescriptionStyle viewStyle;

    public ImagePickerStyleProvider(ImagePickerDescriptionStyle viewStyle) {
        this.viewStyle = Objects.requireNonNull(viewStyle);
    }

    @Override
    public ImagePickerStyle apply(VariableManager variableManager) {
        Builder imagePickerStyleBuilder = ImagePickerStyle.newImagePickerStyle();

        if (this.viewStyle.getColor() instanceof FixedColor fixedColor) {
            String color = fixedColor.getValue();
            if (color != null && !color.isBlank()) {
                imagePickerStyleBuilder.color(color);
            }
        }

        int fontSize = this.viewStyle.getFontSize();
        boolean italic = this.viewStyle.isItalic();
        boolean bold = this.viewStyle.isBold();
        boolean underline = this.viewStyle.isUnderline();
        boolean strikeThrough = this.viewStyle.isStrikeThrough();

        // @formatter:off
        return imagePickerStyleBuilder
                .fontSize(fontSize)
                .italic(italic)
                .bold(bold)
                .underline(underline)
                .strikeThrough(strikeThrough)
                .build();
        // @formatter:on
    }

}
