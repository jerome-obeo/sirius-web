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
package org.eclipse.sirius.components.forms.description;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.eclipse.sirius.components.annotations.Immutable;
import org.eclipse.sirius.components.forms.ImagePickerStyle;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * The description of the Image Picker widget.
 *
 * @author Jerome Gout
 */
@Immutable
public final class ImagePickerDescription extends AbstractWidgetDescription {

    private Function<VariableManager, String> idProvider;

    private Function<VariableManager, String> labelProvider;

    private Function<VariableManager, List<String>> iconURLProvider;

    private Function<VariableManager, List<String>> valueProvider;

    private BiFunction<VariableManager, String, IStatus> newValueHandler;

    private BiFunction<VariableManager, String, IStatus> removeValueHandler;

    private Function<VariableManager, ImagePickerStyle> styleProvider;

    private ImagePickerDescription() {
        // Prevent instantiation
    }

    public static Builder newImagePickerDescription(String id) {
        return new Builder(id);
    }

    public Function<VariableManager, String> getIdProvider() {
        return this.idProvider;
    }

    public Function<VariableManager, String> getLabelProvider() {
        return this.labelProvider;
    }

    public Function<VariableManager, List<String>> getIconURLProvider() {
        return this.iconURLProvider;
    }

    public Function<VariableManager, List<String>> getValueProvider() {
        return this.valueProvider;
    }

    public BiFunction<VariableManager, String, IStatus> getNewValueHandler() {
        return this.newValueHandler;
    }

    public BiFunction<VariableManager, String, IStatus> getRemoveValueHandler() {
        return this.removeValueHandler;
    }

    public Function<VariableManager, ImagePickerStyle> getStyleProvider() {
        return this.styleProvider;
    }

    @Override
    public String toString() {
        String pattern = "{0} '{'id: {1}'}'";
        return MessageFormat.format(pattern, this.getClass().getSimpleName(), this.getId());
    }

    /**
     * Builder used to create the image picker description.
     *
     * @author Jerome Gout
     */
    @SuppressWarnings("checkstyle:HiddenField")
    public static final class Builder {

        private final String id;

        private Function<VariableManager, String> idProvider;

        private Function<VariableManager, String> targetObjectIdProvider;

        private Function<VariableManager, String> labelProvider;

        private Function<VariableManager, List<String>> iconURLProvider = variableManager -> List.of();

        private Function<VariableManager, Boolean> isReadOnlyProvider = variableManager -> false;

        private Function<VariableManager, List<String>> valueProvider;

        private BiFunction<VariableManager, String, IStatus> newValueHandler;

        private BiFunction<VariableManager, String, IStatus> removeValueHandler;

        private Function<VariableManager, List<?>> diagnosticsProvider;

        private Function<Object, String> kindProvider;

        private Function<Object, String> messageProvider;

        private Function<VariableManager, String> helpTextProvider;

        private Function<VariableManager, ImagePickerStyle> styleProvider = vm -> null;

        private Builder(String id) {
            this.id = Objects.requireNonNull(id);
        }

        public Builder idProvider(Function<VariableManager, String> idProvider) {
            this.idProvider = Objects.requireNonNull(idProvider);
            return this;
        }

        public Builder targetObjectIdProvider(Function<VariableManager, String> targetObjectIdProvider) {
            this.targetObjectIdProvider = Objects.requireNonNull(targetObjectIdProvider);
            return this;
        }

        public Builder labelProvider(Function<VariableManager, String> labelProvider) {
            this.labelProvider = Objects.requireNonNull(labelProvider);
            return this;
        }

        public Builder iconURLProvider(Function<VariableManager, List<String>> iconURLProvider) {
            this.iconURLProvider = Objects.requireNonNull(iconURLProvider);
            return this;
        }

        public Builder isReadOnlyProvider(Function<VariableManager, Boolean> isReadOnlyProvider) {
            this.isReadOnlyProvider = Objects.requireNonNull(isReadOnlyProvider);
            return this;
        }

        public Builder valueProvider(Function<VariableManager, List<String>> valueProvider) {
            this.valueProvider = Objects.requireNonNull(valueProvider);
            return this;
        }

        public Builder newValueHandler(BiFunction<VariableManager, String, IStatus> newValueHandler) {
            this.newValueHandler = Objects.requireNonNull(newValueHandler);
            return this;
        }

        public Builder removeValueHandler(BiFunction<VariableManager, String, IStatus> removeValueHandler) {
            this.removeValueHandler = Objects.requireNonNull(removeValueHandler);
            return this;
        }

        public Builder diagnosticsProvider(Function<VariableManager, List<?>> diagnosticsProvider) {
            this.diagnosticsProvider = Objects.requireNonNull(diagnosticsProvider);
            return this;
        }

        public Builder kindProvider(Function<Object, String> kindProvider) {
            this.kindProvider = Objects.requireNonNull(kindProvider);
            return this;
        }

        public Builder messageProvider(Function<Object, String> messageProvider) {
            this.messageProvider = Objects.requireNonNull(messageProvider);
            return this;
        }

        public Builder styleProvider(Function<VariableManager, ImagePickerStyle> styleProvider) {
            this.styleProvider = Objects.requireNonNull(styleProvider);
            return this;
        }

        public Builder helpTextProvider(Function<VariableManager, String> helpTextProvider) {
            this.helpTextProvider = Objects.requireNonNull(helpTextProvider);
            return this;
        }

        public ImagePickerDescription build() {
            ImagePickerDescription imagePickerDescription = new ImagePickerDescription();
            imagePickerDescription.id = Objects.requireNonNull(this.id);
            imagePickerDescription.targetObjectIdProvider = Objects.requireNonNull(this.targetObjectIdProvider);
            imagePickerDescription.idProvider = Objects.requireNonNull(this.idProvider);
            imagePickerDescription.labelProvider = Objects.requireNonNull(this.labelProvider);
            imagePickerDescription.iconURLProvider = Objects.requireNonNull(this.iconURLProvider);
            imagePickerDescription.isReadOnlyProvider = Objects.requireNonNull(this.isReadOnlyProvider);
            imagePickerDescription.valueProvider = Objects.requireNonNull(this.valueProvider);
            imagePickerDescription.newValueHandler = Objects.requireNonNull(this.newValueHandler);
            imagePickerDescription.removeValueHandler = Objects.requireNonNull(this.removeValueHandler);
            imagePickerDescription.diagnosticsProvider = Objects.requireNonNull(this.diagnosticsProvider);
            imagePickerDescription.kindProvider = Objects.requireNonNull(this.kindProvider);
            imagePickerDescription.messageProvider = Objects.requireNonNull(this.messageProvider);
            imagePickerDescription.styleProvider = Objects.requireNonNull(this.styleProvider);
            imagePickerDescription.helpTextProvider = this.helpTextProvider; // Optional on purpose
            return imagePickerDescription;
        }
    }
}
