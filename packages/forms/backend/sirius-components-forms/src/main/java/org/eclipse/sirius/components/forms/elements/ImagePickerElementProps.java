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
package org.eclipse.sirius.components.forms.elements;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.sirius.components.annotations.Immutable;
import org.eclipse.sirius.components.forms.ImagePickerStyle;
import org.eclipse.sirius.components.representations.Element;
import org.eclipse.sirius.components.representations.IProps;
import org.eclipse.sirius.components.representations.IStatus;

/**
 * The properties of the image picker element.
 *
 * @author Jerome Gout
 */
@Immutable
public final class ImagePickerElementProps implements IProps {

    public static final String TYPE = "ImagePicker";

    private String id;

    private String label;

    private List<String> iconURL;

    private Supplier<String> helpTextProvider;

    private boolean readOnly;

    private List<String> images;

    private Function<String, IStatus> newValueHandler;

    private Function<String, IStatus> removeValueHandler;

    private ImagePickerStyle style;

    private List<Element> children;

    private ImagePickerElementProps() {
        // Prevent instantiation
    }

    public static Builder newImagePickerElementProps(String id) {
        return new Builder(id);
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public List<String> getIconURL() {
        return this.iconURL;
    }

    public Supplier<String> getHelpTextProvider() {
        return this.helpTextProvider;
    }

    public boolean isReadOnly() {
        return this.readOnly;
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
    public List<Element> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}, label: {2}'}'";
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.id, this.label);
    }

    /**
     * The builder of the image picker element props.
     *
     * @author Jerome Gout
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class Builder {

        private final String id;

        private String label;

        private List<String> iconURL;

        private Supplier<String> helpTextProvider;

        private boolean readOnly;

        private List<String> images;

        private Function<String, IStatus> newValueHandler;

        private Function<String, IStatus> removeValueHandler;

        private ImagePickerStyle style;

        private List<Element> children;

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

        public Builder readOnly(boolean readOnly) {
            this.readOnly = readOnly;
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

        public Builder children(List<Element> children) {
            this.children = Objects.requireNonNull(children);
            return this;
        }

        public Builder helpTextProvider(Supplier<String> helpTextProvider) {
            this.helpTextProvider = Objects.requireNonNull(helpTextProvider);
            return this;
        }

        public ImagePickerElementProps build() {
            ImagePickerElementProps imagePickerElementProps = new ImagePickerElementProps();
            imagePickerElementProps.id = Objects.requireNonNull(this.id);
            imagePickerElementProps.label = Objects.requireNonNull(this.label);
            imagePickerElementProps.iconURL = this.iconURL;
            imagePickerElementProps.readOnly = this.readOnly;
            imagePickerElementProps.images = this.images;
            imagePickerElementProps.newValueHandler = Objects.requireNonNull(this.newValueHandler);
            imagePickerElementProps.removeValueHandler = Objects.requireNonNull(this.removeValueHandler);
            imagePickerElementProps.style = this.style; // Optional on purpose
            imagePickerElementProps.children = Objects.requireNonNull(this.children);
            imagePickerElementProps.helpTextProvider = this.helpTextProvider; // Optional on purpose
            return imagePickerElementProps;
        }
    }

}
