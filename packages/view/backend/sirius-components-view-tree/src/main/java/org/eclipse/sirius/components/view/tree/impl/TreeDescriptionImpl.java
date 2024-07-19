/**
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
 */
package org.eclipse.sirius.components.view.tree.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.sirius.components.view.impl.RepresentationDescriptionImpl;

import org.eclipse.sirius.components.view.tree.DeleteTool;
import org.eclipse.sirius.components.view.tree.RenameTool;
import org.eclipse.sirius.components.view.tree.TreeDescription;
import org.eclipse.sirius.components.view.tree.TreePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getKindExpression <em>Kind
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getIconURLExpression <em>Icon URL
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getTreeItemIdExpression <em>Tree Item Id
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getTargetObjectIdExpression <em>Target
 * Object Id Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getElementsExpression <em>Elements
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getHasChildrenExpression <em>Has Children
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getChildrenExpression <em>Children
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getEditableExpression <em>Editable
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getSelectableExpression <em>Selectable
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getDeletableExpression <em>Deletable
 * Expression</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getRenameTool <em>Rename Tool</em>}</li>
 * <li>{@link org.eclipse.sirius.components.view.tree.impl.TreeDescriptionImpl#getDeleteTool <em>Delete Tool</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TreeDescriptionImpl extends RepresentationDescriptionImpl implements TreeDescription {
    /**
     * The default value of the '{@link #getKindExpression() <em>Kind Expression</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getKindExpression()
     * @generated
     * @ordered
     */
    protected static final String KIND_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKindExpression() <em>Kind Expression</em>}' attribute. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getKindExpression()
     * @generated
     * @ordered
     */
    protected String kindExpression = KIND_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getIconURLExpression() <em>Icon URL Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIconURLExpression()
     * @generated
     * @ordered
     */
    protected static final String ICON_URL_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIconURLExpression() <em>Icon URL Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getIconURLExpression()
     * @generated
     * @ordered
     */
    protected String iconURLExpression = ICON_URL_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getTreeItemIdExpression() <em>Tree Item Id Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTreeItemIdExpression()
     * @generated
     * @ordered
     */
    protected static final String TREE_ITEM_ID_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTreeItemIdExpression() <em>Tree Item Id Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTreeItemIdExpression()
     * @generated
     * @ordered
     */
    protected String treeItemIdExpression = TREE_ITEM_ID_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetObjectIdExpression() <em>Target Object Id Expression</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTargetObjectIdExpression()
     * @generated
     * @ordered
     */
    protected static final String TARGET_OBJECT_ID_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetObjectIdExpression() <em>Target Object Id Expression</em>}' attribute.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getTargetObjectIdExpression()
     * @generated
     * @ordered
     */
    protected String targetObjectIdExpression = TARGET_OBJECT_ID_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getElementsExpression() <em>Elements Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElementsExpression()
     * @generated
     * @ordered
     */
    protected static final String ELEMENTS_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getElementsExpression() <em>Elements Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getElementsExpression()
     * @generated
     * @ordered
     */
    protected String elementsExpression = ELEMENTS_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getHasChildrenExpression() <em>Has Children Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHasChildrenExpression()
     * @generated
     * @ordered
     */
    protected static final String HAS_CHILDREN_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getHasChildrenExpression() <em>Has Children Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getHasChildrenExpression()
     * @generated
     * @ordered
     */
    protected String hasChildrenExpression = HAS_CHILDREN_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getChildrenExpression() <em>Children Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getChildrenExpression()
     * @generated
     * @ordered
     */
    protected static final String CHILDREN_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getChildrenExpression() <em>Children Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getChildrenExpression()
     * @generated
     * @ordered
     */
    protected String childrenExpression = CHILDREN_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getEditableExpression() <em>Editable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEditableExpression()
     * @generated
     * @ordered
     */
    protected static final String EDITABLE_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEditableExpression() <em>Editable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getEditableExpression()
     * @generated
     * @ordered
     */
    protected String editableExpression = EDITABLE_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getSelectableExpression() <em>Selectable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSelectableExpression()
     * @generated
     * @ordered
     */
    protected static final String SELECTABLE_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getSelectableExpression() <em>Selectable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSelectableExpression()
     * @generated
     * @ordered
     */
    protected String selectableExpression = SELECTABLE_EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #getDeletableExpression() <em>Deletable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDeletableExpression()
     * @generated
     * @ordered
     */
    protected static final String DELETABLE_EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDeletableExpression() <em>Deletable Expression</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getDeletableExpression()
     * @generated
     * @ordered
     */
    protected String deletableExpression = DELETABLE_EXPRESSION_EDEFAULT;

    /**
     * The cached value of the '{@link #getRenameTool() <em>Rename Tool</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getRenameTool()
     * @generated
     * @ordered
     */
    protected RenameTool renameTool;

    /**
     * The cached value of the '{@link #getDeleteTool() <em>Delete Tool</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getDeleteTool()
     * @generated
     * @ordered
     */
    protected DeleteTool deleteTool;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected TreeDescriptionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TreePackage.Literals.TREE_DESCRIPTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getKindExpression() {
        return kindExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setKindExpression(String newKindExpression) {
        String oldKindExpression = kindExpression;
        kindExpression = newKindExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__KIND_EXPRESSION, oldKindExpression, kindExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getIconURLExpression() {
        return iconURLExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setIconURLExpression(String newIconURLExpression) {
        String oldIconURLExpression = iconURLExpression;
        iconURLExpression = newIconURLExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__ICON_URL_EXPRESSION, oldIconURLExpression, iconURLExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getTreeItemIdExpression() {
        return treeItemIdExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTreeItemIdExpression(String newTreeItemIdExpression) {
        String oldTreeItemIdExpression = treeItemIdExpression;
        treeItemIdExpression = newTreeItemIdExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION, oldTreeItemIdExpression, treeItemIdExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getTargetObjectIdExpression() {
        return targetObjectIdExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setTargetObjectIdExpression(String newTargetObjectIdExpression) {
        String oldTargetObjectIdExpression = targetObjectIdExpression;
        targetObjectIdExpression = newTargetObjectIdExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION, oldTargetObjectIdExpression, targetObjectIdExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getElementsExpression() {
        return elementsExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setElementsExpression(String newElementsExpression) {
        String oldElementsExpression = elementsExpression;
        elementsExpression = newElementsExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__ELEMENTS_EXPRESSION, oldElementsExpression, elementsExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getHasChildrenExpression() {
        return hasChildrenExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setHasChildrenExpression(String newHasChildrenExpression) {
        String oldHasChildrenExpression = hasChildrenExpression;
        hasChildrenExpression = newHasChildrenExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION, oldHasChildrenExpression, hasChildrenExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getChildrenExpression() {
        return childrenExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setChildrenExpression(String newChildrenExpression) {
        String oldChildrenExpression = childrenExpression;
        childrenExpression = newChildrenExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__CHILDREN_EXPRESSION, oldChildrenExpression, childrenExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getEditableExpression() {
        return editableExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEditableExpression(String newEditableExpression) {
        String oldEditableExpression = editableExpression;
        editableExpression = newEditableExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__EDITABLE_EXPRESSION, oldEditableExpression, editableExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getSelectableExpression() {
        return selectableExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSelectableExpression(String newSelectableExpression) {
        String oldSelectableExpression = selectableExpression;
        selectableExpression = newSelectableExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__SELECTABLE_EXPRESSION, oldSelectableExpression, selectableExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getDeletableExpression() {
        return deletableExpression;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDeletableExpression(String newDeletableExpression) {
        String oldDeletableExpression = deletableExpression;
        deletableExpression = newDeletableExpression;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__DELETABLE_EXPRESSION, oldDeletableExpression, deletableExpression));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RenameTool getRenameTool() {
        if (renameTool != null && renameTool.eIsProxy()) {
            InternalEObject oldRenameTool = (InternalEObject) renameTool;
            renameTool = (RenameTool) eResolveProxy(oldRenameTool);
            if (renameTool != oldRenameTool) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TreePackage.TREE_DESCRIPTION__RENAME_TOOL, oldRenameTool, renameTool));
            }
        }
        return renameTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public RenameTool basicGetRenameTool() {
        return renameTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setRenameTool(RenameTool newRenameTool) {
        RenameTool oldRenameTool = renameTool;
        renameTool = newRenameTool;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__RENAME_TOOL, oldRenameTool, renameTool));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeleteTool getDeleteTool() {
        if (deleteTool != null && deleteTool.eIsProxy()) {
            InternalEObject oldDeleteTool = (InternalEObject) deleteTool;
            deleteTool = (DeleteTool) eResolveProxy(oldDeleteTool);
            if (deleteTool != oldDeleteTool) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, TreePackage.TREE_DESCRIPTION__DELETE_TOOL, oldDeleteTool, deleteTool));
            }
        }
        return deleteTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public DeleteTool basicGetDeleteTool() {
        return deleteTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setDeleteTool(DeleteTool newDeleteTool) {
        DeleteTool oldDeleteTool = deleteTool;
        deleteTool = newDeleteTool;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, TreePackage.TREE_DESCRIPTION__DELETE_TOOL, oldDeleteTool, deleteTool));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case TreePackage.TREE_DESCRIPTION__KIND_EXPRESSION:
                return getKindExpression();
            case TreePackage.TREE_DESCRIPTION__ICON_URL_EXPRESSION:
                return getIconURLExpression();
            case TreePackage.TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION:
                return getTreeItemIdExpression();
            case TreePackage.TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION:
                return getTargetObjectIdExpression();
            case TreePackage.TREE_DESCRIPTION__ELEMENTS_EXPRESSION:
                return getElementsExpression();
            case TreePackage.TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION:
                return getHasChildrenExpression();
            case TreePackage.TREE_DESCRIPTION__CHILDREN_EXPRESSION:
                return getChildrenExpression();
            case TreePackage.TREE_DESCRIPTION__EDITABLE_EXPRESSION:
                return getEditableExpression();
            case TreePackage.TREE_DESCRIPTION__SELECTABLE_EXPRESSION:
                return getSelectableExpression();
            case TreePackage.TREE_DESCRIPTION__DELETABLE_EXPRESSION:
                return getDeletableExpression();
            case TreePackage.TREE_DESCRIPTION__RENAME_TOOL:
                if (resolve)
                    return getRenameTool();
                return basicGetRenameTool();
            case TreePackage.TREE_DESCRIPTION__DELETE_TOOL:
                if (resolve)
                    return getDeleteTool();
                return basicGetDeleteTool();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case TreePackage.TREE_DESCRIPTION__KIND_EXPRESSION:
                setKindExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__ICON_URL_EXPRESSION:
                setIconURLExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION:
                setTreeItemIdExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION:
                setTargetObjectIdExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__ELEMENTS_EXPRESSION:
                setElementsExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION:
                setHasChildrenExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__CHILDREN_EXPRESSION:
                setChildrenExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__EDITABLE_EXPRESSION:
                setEditableExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__SELECTABLE_EXPRESSION:
                setSelectableExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__DELETABLE_EXPRESSION:
                setDeletableExpression((String) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__RENAME_TOOL:
                setRenameTool((RenameTool) newValue);
                return;
            case TreePackage.TREE_DESCRIPTION__DELETE_TOOL:
                setDeleteTool((DeleteTool) newValue);
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
            case TreePackage.TREE_DESCRIPTION__KIND_EXPRESSION:
                setKindExpression(KIND_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__ICON_URL_EXPRESSION:
                setIconURLExpression(ICON_URL_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION:
                setTreeItemIdExpression(TREE_ITEM_ID_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION:
                setTargetObjectIdExpression(TARGET_OBJECT_ID_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__ELEMENTS_EXPRESSION:
                setElementsExpression(ELEMENTS_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION:
                setHasChildrenExpression(HAS_CHILDREN_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__CHILDREN_EXPRESSION:
                setChildrenExpression(CHILDREN_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__EDITABLE_EXPRESSION:
                setEditableExpression(EDITABLE_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__SELECTABLE_EXPRESSION:
                setSelectableExpression(SELECTABLE_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__DELETABLE_EXPRESSION:
                setDeletableExpression(DELETABLE_EXPRESSION_EDEFAULT);
                return;
            case TreePackage.TREE_DESCRIPTION__RENAME_TOOL:
                setRenameTool((RenameTool) null);
                return;
            case TreePackage.TREE_DESCRIPTION__DELETE_TOOL:
                setDeleteTool((DeleteTool) null);
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
            case TreePackage.TREE_DESCRIPTION__KIND_EXPRESSION:
                return KIND_EXPRESSION_EDEFAULT == null ? kindExpression != null : !KIND_EXPRESSION_EDEFAULT.equals(kindExpression);
            case TreePackage.TREE_DESCRIPTION__ICON_URL_EXPRESSION:
                return ICON_URL_EXPRESSION_EDEFAULT == null ? iconURLExpression != null : !ICON_URL_EXPRESSION_EDEFAULT.equals(iconURLExpression);
            case TreePackage.TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION:
                return TREE_ITEM_ID_EXPRESSION_EDEFAULT == null ? treeItemIdExpression != null : !TREE_ITEM_ID_EXPRESSION_EDEFAULT.equals(treeItemIdExpression);
            case TreePackage.TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION:
                return TARGET_OBJECT_ID_EXPRESSION_EDEFAULT == null ? targetObjectIdExpression != null : !TARGET_OBJECT_ID_EXPRESSION_EDEFAULT.equals(targetObjectIdExpression);
            case TreePackage.TREE_DESCRIPTION__ELEMENTS_EXPRESSION:
                return ELEMENTS_EXPRESSION_EDEFAULT == null ? elementsExpression != null : !ELEMENTS_EXPRESSION_EDEFAULT.equals(elementsExpression);
            case TreePackage.TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION:
                return HAS_CHILDREN_EXPRESSION_EDEFAULT == null ? hasChildrenExpression != null : !HAS_CHILDREN_EXPRESSION_EDEFAULT.equals(hasChildrenExpression);
            case TreePackage.TREE_DESCRIPTION__CHILDREN_EXPRESSION:
                return CHILDREN_EXPRESSION_EDEFAULT == null ? childrenExpression != null : !CHILDREN_EXPRESSION_EDEFAULT.equals(childrenExpression);
            case TreePackage.TREE_DESCRIPTION__EDITABLE_EXPRESSION:
                return EDITABLE_EXPRESSION_EDEFAULT == null ? editableExpression != null : !EDITABLE_EXPRESSION_EDEFAULT.equals(editableExpression);
            case TreePackage.TREE_DESCRIPTION__SELECTABLE_EXPRESSION:
                return SELECTABLE_EXPRESSION_EDEFAULT == null ? selectableExpression != null : !SELECTABLE_EXPRESSION_EDEFAULT.equals(selectableExpression);
            case TreePackage.TREE_DESCRIPTION__DELETABLE_EXPRESSION:
                return DELETABLE_EXPRESSION_EDEFAULT == null ? deletableExpression != null : !DELETABLE_EXPRESSION_EDEFAULT.equals(deletableExpression);
            case TreePackage.TREE_DESCRIPTION__RENAME_TOOL:
                return renameTool != null;
            case TreePackage.TREE_DESCRIPTION__DELETE_TOOL:
                return deleteTool != null;
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
        if (eIsProxy())
            return super.toString();

        StringBuilder result = new StringBuilder(super.toString());
        result.append(" (kindExpression: ");
        result.append(kindExpression);
        result.append(", iconURLExpression: ");
        result.append(iconURLExpression);
        result.append(", treeItemIdExpression: ");
        result.append(treeItemIdExpression);
        result.append(", targetObjectIdExpression: ");
        result.append(targetObjectIdExpression);
        result.append(", elementsExpression: ");
        result.append(elementsExpression);
        result.append(", hasChildrenExpression: ");
        result.append(hasChildrenExpression);
        result.append(", childrenExpression: ");
        result.append(childrenExpression);
        result.append(", editableExpression: ");
        result.append(editableExpression);
        result.append(", selectableExpression: ");
        result.append(selectableExpression);
        result.append(", deletableExpression: ");
        result.append(deletableExpression);
        result.append(')');
        return result.toString();
    }

} // TreeDescriptionImpl
