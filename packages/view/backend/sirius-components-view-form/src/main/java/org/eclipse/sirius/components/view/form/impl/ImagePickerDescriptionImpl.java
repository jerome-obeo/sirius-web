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
package org.eclipse.sirius.components.view.form.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.sirius.components.view.form.AddImageOperation;
import org.eclipse.sirius.components.view.form.ConditionalImagePickerDescriptionStyle;
import org.eclipse.sirius.components.view.form.FormPackage;
import org.eclipse.sirius.components.view.form.ImagePickerDescription;
import org.eclipse.sirius.components.view.form.ImagePickerDescriptionStyle;
import org.eclipse.sirius.components.view.form.RemoveImageOperation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Image Picker Description</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getValueExpression <em>Value
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getIsEnabledExpression <em>Is
 * Enabled Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getAddImageOperation <em>Add Image
 * Operation</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getRemoveImageOperation <em>Remove
 * Image Operation</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getStyle <em>Style</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.form.impl.ImagePickerDescriptionImpl#getConditionalStyles
 * <em>Conditional Styles</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImagePickerDescriptionImpl extends WidgetDescriptionImpl implements ImagePickerDescription {
    /**
     * The default value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getValueExpression()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @see #getValueExpression()
     * @generated
     * @ordered
     */
    protected String valueExpression = VALUE_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getIsEnabledExpression() <em>Is Enabled Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getIsEnabledExpression()
     * @generated
     * @ordered
     */
    protected static final String IS_ENABLED_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIsEnabledExpression() <em>Is Enabled Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getIsEnabledExpression()
     * @generated
     * @ordered
     */
    protected String isEnabledExpression = IS_ENABLED_EXPRESSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getAddImageOperation() <em>Add Image Operation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getAddImageOperation()
     * @generated
     * @ordered
     */
    protected AddImageOperation addImageOperation;

    /**
     * The cached value of the '{@link #getRemoveImageOperation() <em>Remove Image Operation</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getRemoveImageOperation()
     * @generated
     * @ordered
     */
    protected RemoveImageOperation removeImageOperation;

    /**
     * The cached value of the '{@link #getStyle() <em>Style</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getStyle()
     * @generated
     * @ordered
     */
    protected ImagePickerDescriptionStyle style;

    /**
     * The cached value of the '{@link #getConditionalStyles() <em>Conditional Styles</em>}' containment reference list.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getConditionalStyles()
     * @generated
     * @ordered
     */
    protected EList<ConditionalImagePickerDescriptionStyle> conditionalStyles;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ImagePickerDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return FormPackage.Literals.IMAGE_PICKER_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getValueExpression() {
        return this.valueExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setValueExpression(String newValueExpression) {
        String oldValueExpression = this.valueExpression;
        this.valueExpression = newValueExpression;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__VALUE_EXPRESSION, oldValueExpression, this.valueExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getIsEnabledExpression() {
        return this.isEnabledExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setIsEnabledExpression(String newIsEnabledExpression) {
        String oldIsEnabledExpression = this.isEnabledExpression;
        this.isEnabledExpression = newIsEnabledExpression;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__IS_ENABLED_EXPRESSION, oldIsEnabledExpression, this.isEnabledExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AddImageOperation getAddImageOperation() {
        if (this.addImageOperation != null && this.addImageOperation.eIsProxy()) {
            InternalEObject oldAddImageOperation = (InternalEObject) this.addImageOperation;
            this.addImageOperation = (AddImageOperation) this.eResolveProxy(oldAddImageOperation);
            if (this.addImageOperation != oldAddImageOperation) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION, oldAddImageOperation, this.addImageOperation));
            }
        }
        return this.addImageOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AddImageOperation basicGetAddImageOperation() {
        return this.addImageOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAddImageOperation(AddImageOperation newAddImageOperation) {
        AddImageOperation oldAddImageOperation = this.addImageOperation;
        this.addImageOperation = newAddImageOperation;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION, oldAddImageOperation, this.addImageOperation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RemoveImageOperation getRemoveImageOperation() {
        if (this.removeImageOperation != null && this.removeImageOperation.eIsProxy()) {
            InternalEObject oldRemoveImageOperation = (InternalEObject) this.removeImageOperation;
            this.removeImageOperation = (RemoveImageOperation) this.eResolveProxy(oldRemoveImageOperation);
            if (this.removeImageOperation != oldRemoveImageOperation) {
                if (this.eNotificationRequired())
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE, FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION, oldRemoveImageOperation, this.removeImageOperation));
            }
        }
        return this.removeImageOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public RemoveImageOperation basicGetRemoveImageOperation() {
        return this.removeImageOperation;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setRemoveImageOperation(RemoveImageOperation newRemoveImageOperation) {
        RemoveImageOperation oldRemoveImageOperation = this.removeImageOperation;
        this.removeImageOperation = newRemoveImageOperation;
        if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION, oldRemoveImageOperation, this.removeImageOperation));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ImagePickerDescriptionStyle getStyle() {
        return this.style;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetStyle(ImagePickerDescriptionStyle newStyle, NotificationChain msgs) {
        ImagePickerDescriptionStyle oldStyle = this.style;
        this.style = newStyle;
        if (this.eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE, oldStyle, newStyle);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setStyle(ImagePickerDescriptionStyle newStyle) {
        if (newStyle != this.style) {
            NotificationChain msgs = null;
            if (this.style != null)
                msgs = ((InternalEObject) this.style).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE, null, msgs);
            if (newStyle != null)
                msgs = ((InternalEObject) newStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE, null, msgs);
            msgs = this.basicSetStyle(newStyle, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (this.eNotificationRequired())
            this.eNotify(new ENotificationImpl(this, Notification.SET, FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE, newStyle, newStyle));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ConditionalImagePickerDescriptionStyle> getConditionalStyles() {
        if (this.conditionalStyles == null) {
            this.conditionalStyles = new EObjectContainmentEList<>(ConditionalImagePickerDescriptionStyle.class, this,
                    FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES);
        }
        return this.conditionalStyles;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE:
                return this.basicSetStyle(null, msgs);
            case FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES:
                return ((InternalEList<?>) this.getConditionalStyles()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case FormPackage.IMAGE_PICKER_DESCRIPTION__VALUE_EXPRESSION:
                return this.getValueExpression();
            case FormPackage.IMAGE_PICKER_DESCRIPTION__IS_ENABLED_EXPRESSION:
                return this.getIsEnabledExpression();
            case FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION:
                if (resolve)
                    return this.getAddImageOperation();
                return this.basicGetAddImageOperation();
            case FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION:
                if (resolve)
                    return this.getRemoveImageOperation();
                return this.basicGetRemoveImageOperation();
            case FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE:
                return this.getStyle();
            case FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES:
                return this.getConditionalStyles();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case FormPackage.IMAGE_PICKER_DESCRIPTION__VALUE_EXPRESSION:
                this.setValueExpression((String) newValue);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__IS_ENABLED_EXPRESSION:
                this.setIsEnabledExpression((String) newValue);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION:
                this.setAddImageOperation((AddImageOperation) newValue);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION:
                this.setRemoveImageOperation((RemoveImageOperation) newValue);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE:
                this.setStyle((ImagePickerDescriptionStyle) newValue);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES:
                this.getConditionalStyles().clear();
                this.getConditionalStyles().addAll((Collection<? extends ConditionalImagePickerDescriptionStyle>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case FormPackage.IMAGE_PICKER_DESCRIPTION__VALUE_EXPRESSION:
                this.setValueExpression(VALUE_EXPRESSION_EDEFAULT);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__IS_ENABLED_EXPRESSION:
                this.setIsEnabledExpression(IS_ENABLED_EXPRESSION_EDEFAULT);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION:
                this.setAddImageOperation((AddImageOperation) null);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION:
                this.setRemoveImageOperation((RemoveImageOperation) null);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE:
                this.setStyle((ImagePickerDescriptionStyle) null);
                return;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES:
                this.getConditionalStyles().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case FormPackage.IMAGE_PICKER_DESCRIPTION__VALUE_EXPRESSION:
                return VALUE_EXPRESSION_EDEFAULT == null ? this.valueExpression != null : !VALUE_EXPRESSION_EDEFAULT.equals(this.valueExpression);
            case FormPackage.IMAGE_PICKER_DESCRIPTION__IS_ENABLED_EXPRESSION:
                return IS_ENABLED_EXPRESSION_EDEFAULT == null ? this.isEnabledExpression != null : !IS_ENABLED_EXPRESSION_EDEFAULT.equals(this.isEnabledExpression);
            case FormPackage.IMAGE_PICKER_DESCRIPTION__ADD_IMAGE_OPERATION:
                return this.addImageOperation != null;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__REMOVE_IMAGE_OPERATION:
                return this.removeImageOperation != null;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__STYLE:
                return this.style != null;
            case FormPackage.IMAGE_PICKER_DESCRIPTION__CONDITIONAL_STYLES:
                return this.conditionalStyles != null && !this.conditionalStyles.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (valueExpression: ");
        result.append(this.valueExpression);
        result.append(", IsEnabledExpression: ");
        result.append(this.isEnabledExpression);
        result.append(')');
        return result.toString();
    }

} // ImagePickerDescriptionImpl
