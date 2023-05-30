/*******************************************************************************
 * Copyright (c) 2021, 2023 Obeo.
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
package org.eclipse.sirius.components.view;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Multi Select Description Style</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#getBackgroundColor <em>Background
 * Color</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#getForegroundColor <em>Foreground
 * Color</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#isShowIcon <em>Show Icon</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.components.view.ViewPackage#getMultiSelectDescriptionStyle()
 * @model
 * @generated
 */
public interface MultiSelectDescriptionStyle extends WidgetDescriptionStyle, LabelStyle {
    /**
     * Returns the value of the '<em><b>Background Color</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Background Color</em>' attribute.
     * @model
     * @generated
     * @see #setBackgroundColor(UserColor)
     * @see org.eclipse.sirius.components.view.ViewPackage#getMultiSelectDescriptionStyle_BackgroundColor()
     */
    UserColor getBackgroundColor();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#getBackgroundColor
     * <em>Background Color</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Background Color</em>' reference.
     * @see #getBackgroundColor()
     * @generated
     */
    void setBackgroundColor(UserColor value);

    /**
     * Returns the value of the '<em><b>Foreground Color</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @return the value of the '<em>Foreground Color</em>' attribute.
     * @see #setForegroundColor(UserColor)
     * @see org.eclipse.sirius.components.view.ViewPackage#getMultiSelectDescriptionStyle_ForegroundColor()
     * @model
     * @generated
     */
    UserColor getForegroundColor();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#getForegroundColor
     * <em>Foreground Color</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Foreground Color</em>' reference.
     * @see #getForegroundColor()
     * @generated
     */
    void setForegroundColor(UserColor value);

    /**
     * Returns the value of the '<em><b>Show Icon</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @return the value of the '<em>Show Icon</em>' attribute.
     * @see #setShowIcon(boolean)
     * @see org.eclipse.sirius.components.view.ViewPackage#getMultiSelectDescriptionStyle_ShowIcon()
     * @model
     * @generated
     */
    boolean isShowIcon();

    /**
     * Sets the value of the '{@link org.eclipse.sirius.components.view.MultiSelectDescriptionStyle#isShowIcon <em>Show
     * Icon</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @param value
     *            the new value of the '<em>Show Icon</em>' attribute.
     * @see #isShowIcon()
     * @generated
     */
    void setShowIcon(boolean value);

} // MultiSelectDescriptionStyle
