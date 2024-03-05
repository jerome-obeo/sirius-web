/**
 * Copyright (c) 2021, 2024 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.sirius.components.view.form;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Image Picker Description</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getValueExpression <em>Value
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getIsEnabledExpression <em>Is Enabled
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getAddImageOperation <em>Add Image
 * Operation</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getRemoveImageOperation <em>Remove Image
 * Operation</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getStyle <em>Style</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getConditionalStyles <em>Conditional
 * Styles</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription()
 * @model
 * @generated
 */
public interface ImagePickerDescription extends WidgetDescription {
    /**
     * Returns the value of the '<em><b>Value Expression</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Value Expression</em>' attribute.
     * @see #setValueExpression(String)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_ValueExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression"
     * @generated
     */
    String getValueExpression();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getValueExpression
     * <em>Value Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Value Expression</em>' attribute.
     * @see #getValueExpression()
     * @generated
     */
    void setValueExpression(String value);

    /**
     * Returns the value of the '<em><b>Is Enabled Expression</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Is Enabled Expression</em>' attribute.
     * @see #setIsEnabledExpression(String)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_IsEnabledExpression()
     * @model dataType="org.eclipse.sirius.components.view.InterpretedExpression"
     * @generated
     */
    String getIsEnabledExpression();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getIsEnabledExpression <em>Is Enabled
     * Expression</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Is Enabled Expression</em>' attribute.
     * @see #getIsEnabledExpression()
     * @generated
     */
    void setIsEnabledExpression(String value);

    /**
     * Returns the value of the '<em><b>Add Image Operation</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Add Image Operation</em>' reference.
     * @see #setAddImageOperation(AddImageOperation)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_AddImageOperation()
     * @model
     * @generated
     */
    AddImageOperation getAddImageOperation();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getAddImageOperation
     * <em>Add Image Operation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Add Image Operation</em>' reference.
     * @see #getAddImageOperation()
     * @generated
     */
    void setAddImageOperation(AddImageOperation value);

    /**
     * Returns the value of the '<em><b>Remove Image Operation</b></em>' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @return the value of the '<em>Remove Image Operation</em>' reference.
     * @see #setRemoveImageOperation(RemoveImageOperation)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_RemoveImageOperation()
     * @model
     * @generated
     */
    RemoveImageOperation getRemoveImageOperation();

    /**
     * Sets the value of the
     * '{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getRemoveImageOperation <em>Remove Image
     * Operation</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Remove Image Operation</em>' reference.
     * @see #getRemoveImageOperation()
     * @generated
     */
    void setRemoveImageOperation(RemoveImageOperation value);

    /**
     * Returns the value of the '<em><b>Style</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Style</em>' containment reference.
     * @see #setStyle(ImagePickerDescriptionStyle)
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_Style()
     * @model containment="true"
     * @generated
     */
    ImagePickerDescriptionStyle getStyle();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.form.ImagePickerDescription#getStyle
     * <em>Style</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Style</em>' containment reference.
     * @see #getStyle()
     * @generated
     */
    void setStyle(ImagePickerDescriptionStyle value);

    /**
     * Returns the value of the '<em><b>Conditional Styles</b></em>' containment reference list. The list contents are
     * of type {@link org.eclipse.sirius.components.view.form.ConditionalImagePickerDescriptionStyle}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Conditional Styles</em>' containment reference list.
     * @see org.eclipse.sirius.components.view.form.FormPackage#getImagePickerDescription_ConditionalStyles()
     * @model containment="true"
     * @generated
     */
    EList<ConditionalImagePickerDescriptionStyle> getConditionalStyles();

} // ImagePickerDescription
