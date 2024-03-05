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
package org.eclipse.sirius.components.forms;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.sirius.components.annotations.Immutable;
import org.eclipse.sirius.components.forms.validation.Diagnostic;
import org.eclipse.sirius.components.representations.IStatus;

/**
 * The image picker widget.
 *
 * @author Jerome Gout
 */
@Immutable
public final class ImagePicker extends AbstractWidget {

    private List<String> images;

    private Function<String, IStatus> newValueHandler;

    private Function<String, IStatus> removeValueHandler;

    private ImagePickerStyle style;

    private ImagePicker() {
     // Prevent instantiation
    }

    public static Builder newImagePicker(String id) {
        return new Builder(id);
    }

    public List<String> getImages() {
        return this.images;
    }

    public Function<String, IStatus> getNewValueHandler() {
        return this.newValueHandler;
    }

    public Function<String, IStatus> getRemoveValueHandler() {
        return this.removeValueHandler;
    }

    public ImagePickerStyle getStyle() {
        return this.style;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}, label: {2}, values: {3}'}'";
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.getId(), this.label, this.images);
    }

    /**
     * The builder used to create the select.
     *
     * @author lfasani
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class Builder {

        private final String id;

        private String label;

        private List<String> iconURL = List.of();

        private List<String> images;

        private Function<String, IStatus> newValueHandler;

        private Function<String, IStatus> removeValueHandler;

        private ImagePickerStyle style;

        private List<Diagnostic> diagnostics;

        private Supplier<String> helpTextProvider;

        private boolean readOnly;

        private Builder(String id) {
            this.id = Objects.requireNonNull(id);
        }

        public Builder label(String label) {
            this.label = Objects.requireNonNull(label);
            return this;
        }

        public Builder iconURL(List<String> iconURL) {
            this.iconURL = Objects.requireNonNull(iconURL);
            return this;
        }

        public Builder images(List<String> images) {
            this.images = images;
            return this;
        }

        public Builder newValueHandler(Function<String, IStatus> newValueHandler) {
            this.newValueHandler = Objects.requireNonNull(newValueHandler);
            return this;
        }

        public Builder removeValueHandler(Function<String, IStatus> removeValueHandler) {
            this.removeValueHandler = Objects.requireNonNull(removeValueHandler);
            return this;
        }

        public Builder style(ImagePickerStyle style) {
            this.style = Objects.requireNonNull(style);
            return this;
        }

        public Builder diagnostics(List<Diagnostic> diagnostics) {
            this.diagnostics = Objects.requireNonNull(diagnostics);
            return this;
        }

        public Builder helpTextProvider(Supplier<String> helpTextProvider) {
            this.helpTextProvider = Objects.requireNonNull(helpTextProvider);
            return this;
        }

        public Builder readOnly(boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        public ImagePicker build() {
            ImagePicker imagePicker = new ImagePicker();
            imagePicker.id = Objects.requireNonNull(this.id);
            imagePicker.label = Objects.requireNonNull(this.label);
            imagePicker.iconURL = Objects.requireNonNull(this.iconURL);
            imagePicker.images = this.images;
            imagePicker.newValueHandler = Objects.requireNonNull(this.newValueHandler);
            imagePicker.removeValueHandler = Objects.requireNonNull(this.removeValueHandler);
            imagePicker.style = this.style; // Optional on purpose
            imagePicker.diagnostics = Objects.requireNonNull(this.diagnostics);
            imagePicker.helpTextProvider = this.helpTextProvider; // Optional on purpose
            imagePicker.readOnly = this.readOnly;
            return imagePicker;
        }
    }
}
