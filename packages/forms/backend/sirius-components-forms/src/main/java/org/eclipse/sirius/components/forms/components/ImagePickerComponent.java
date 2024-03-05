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

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.eclipse.sirius.components.forms.description.ImagePickerDescription;
import org.eclipse.sirius.components.forms.elements.ImagePickerElementProps;
import org.eclipse.sirius.components.forms.elements.ImagePickerElementProps.Builder;
import org.eclipse.sirius.components.forms.validation.DiagnosticComponent;
import org.eclipse.sirius.components.forms.validation.DiagnosticComponentProps;
import org.eclipse.sirius.components.representations.Element;
import org.eclipse.sirius.components.representations.IComponent;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.VariableManager;

/**
 * The component used to create the image picker widget and its options.
 *
 * @author Jerome Gout
 */
public class ImagePickerComponent implements IComponent {

    private ImagePickerComponentProps props;

    public ImagePickerComponent(ImagePickerComponentProps props) {
        this.props = Objects.requireNonNull(props);
    }

    @Override
    public Element render() {
        VariableManager variableManager = this.props.getVariableManager();
        ImagePickerDescription imagePickerDescription = this.props.getImagePickerDescription();

        String label = imagePickerDescription.getLabelProvider().apply(variableManager);

        VariableManager idVariableManager = variableManager.createChild();
        idVariableManager.put(FormComponent.TARGET_OBJECT_ID, imagePickerDescription.getTargetObjectIdProvider().apply(variableManager));
        idVariableManager.put(FormComponent.CONTROL_DESCRIPTION_ID, imagePickerDescription.getId());
        idVariableManager.put(FormComponent.WIDGET_LABEL, label);
        String id = imagePickerDescription.getIdProvider().apply(idVariableManager);

        List<String> iconURL = imagePickerDescription.getIconURLProvider().apply(variableManager);
        Boolean readOnly = imagePickerDescription.getIsReadOnlyProvider().apply(variableManager);

        List<String> values = imagePickerDescription.getValueProvider().apply(variableManager);

        Function<String, IStatus> newValueHandler = newValue -> imagePickerDescription.getNewValueHandler().apply(variableManager, newValue);
        Function<String, IStatus> removeValueHandler = imageId -> imagePickerDescription.getRemoveValueHandler().apply(variableManager, imageId);
        List<Element> children = List.of(new Element(DiagnosticComponent.class, new DiagnosticComponentProps(imagePickerDescription, variableManager)));
        var imagePickerStyle = imagePickerDescription.getStyleProvider().apply(variableManager);

        Builder imagePickerElementPropsBuilder = ImagePickerElementProps.newImagePickerElementProps(id)
                .label(label)
                .images(values)
                .newValueHandler(newValueHandler)
                .removeValueHandler(removeValueHandler)
                .children(children);

        if (iconURL != null) {
            imagePickerElementPropsBuilder.iconURL(iconURL);
        }
        if (imagePickerStyle != null) {
            imagePickerElementPropsBuilder.style(imagePickerStyle);
        }
        if (imagePickerDescription.getHelpTextProvider() != null) {
            imagePickerElementPropsBuilder.helpTextProvider(() -> imagePickerDescription.getHelpTextProvider().apply(variableManager));
        }
        if (readOnly != null) {
            imagePickerElementPropsBuilder.readOnly(readOnly);
        }

        ImagePickerElementProps imagePickerElementProps = imagePickerElementPropsBuilder.build();

        return new Element(ImagePickerElementProps.TYPE, imagePickerElementProps);
    }
}
