/*******************************************************************************
 * Copyright (c) 2022 Obeo.
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
package org.eclipse.sirius.components.formdescriptioneditors.renderer;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.sirius.components.formdescriptioneditors.FormDescriptionEditor;
import org.eclipse.sirius.components.formdescriptioneditors.FormDescriptionEditorWidget;
import org.eclipse.sirius.components.formdescriptioneditors.elements.FormDescriptionEditorElementProps;
import org.eclipse.sirius.components.formdescriptioneditors.elements.FormDescriptionEditorTextfieldElementProps;
import org.eclipse.sirius.components.representations.IElementFactory;
import org.eclipse.sirius.components.representations.IProps;

/**
 * Used to instantiate the elements of the form description editor.
 *
 * @author arichard
 */
public class FormDescriptionEditorElementFactory implements IElementFactory {

    @Override
    public Object instantiateElement(String type, IProps props, List<Object> children) {
        Object object = null;
        if (FormDescriptionEditorElementProps.TYPE.equals(type) && props instanceof FormDescriptionEditorElementProps) {
            object = this.instantiateForm((FormDescriptionEditorElementProps) props, children);
        } else if (FormDescriptionEditorTextfieldElementProps.TYPE.equals(type) && props instanceof FormDescriptionEditorTextfieldElementProps) {
            object = this.instantiateWidget((FormDescriptionEditorTextfieldElementProps) props);
        }
        return object;
    }

    private FormDescriptionEditor instantiateForm(FormDescriptionEditorElementProps props, List<Object> children) {
        // @formatter:off
        List<FormDescriptionEditorWidget> widgets = children.stream()
                .filter(FormDescriptionEditorWidget.class::isInstance)
                .map(FormDescriptionEditorWidget.class::cast)
                .collect(Collectors.toList());

        return FormDescriptionEditor.newFormDescriptionEditor(props.getId())
                .label(props.getLabel())
                .targetObjectId(props.getTargetObjectId())
                .descriptionId(props.getDescriptionId())
                .widgets(widgets)
                .build();
        // @formatter:on
    }

    private FormDescriptionEditorWidget instantiateWidget(FormDescriptionEditorTextfieldElementProps props) {
        // @formatter:off
        return FormDescriptionEditorWidget.newFormDescriptionEditorWidget(props.getId())
                .label(props.getLabel())
                .kind(props.getKind())
                .build();
        // @formatter:on
    }
}
