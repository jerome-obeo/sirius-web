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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.sirius.components.view.ViewPackage;

import org.eclipse.sirius.components.view.tree.DeleteTool;
import org.eclipse.sirius.components.view.tree.RenameTool;
import org.eclipse.sirius.components.view.tree.TreeDescription;
import org.eclipse.sirius.components.view.tree.TreeFactory;
import org.eclipse.sirius.components.view.tree.TreePackage;
import org.eclipse.sirius.components.view.tree.TreeTool;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TreePackageImpl extends EPackageImpl implements TreePackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass treeDescriptionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass treeToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass renameToolEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass deleteToolEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
     * EPackage.Registry} by the package package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
     * performs initialization of the package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.sirius.components.view.tree.TreePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private TreePackageImpl() {
        super(eNS_URI, TreeFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>
     * This method is used to initialize {@link TreePackage#eINSTANCE} when that field is accessed. Clients should not
     * invoke it directly. Instead, they should simply access that field to obtain the package. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static TreePackage init() {
        if (isInited)
            return (TreePackage) EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI);

        // Obtain or create and register package
        Object registeredTreePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
        TreePackageImpl theTreePackage = registeredTreePackage instanceof TreePackageImpl ? (TreePackageImpl) registeredTreePackage : new TreePackageImpl();

        isInited = true;

        // Initialize simple dependencies
        ViewPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theTreePackage.createPackageContents();

        // Initialize created meta-data
        theTreePackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTreePackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TreePackage.eNS_URI, theTreePackage);
        return theTreePackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTreeDescription() {
        return treeDescriptionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_KindExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_IconURLExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_TreeItemIdExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_TargetObjectIdExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_ElementsExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_HasChildrenExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_ChildrenExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_EditableExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_SelectableExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeDescription_DeletableExpression() {
        return (EAttribute) treeDescriptionEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTreeDescription_RenameTool() {
        return (EReference) treeDescriptionEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTreeDescription_DeleteTool() {
        return (EReference) treeDescriptionEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTreeTool() {
        return treeToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTreeTool_Name() {
        return (EAttribute) treeToolEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTreeTool_Body() {
        return (EReference) treeToolEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getRenameTool() {
        return renameToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDeleteTool() {
        return deleteToolEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TreeFactory getTreeFactory() {
        return (TreeFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on any invocation but
     * its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        treeDescriptionEClass = createEClass(TREE_DESCRIPTION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__KIND_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__ICON_URL_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__TREE_ITEM_ID_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__TARGET_OBJECT_ID_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__ELEMENTS_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__HAS_CHILDREN_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__CHILDREN_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__EDITABLE_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__SELECTABLE_EXPRESSION);
        createEAttribute(treeDescriptionEClass, TREE_DESCRIPTION__DELETABLE_EXPRESSION);
        createEReference(treeDescriptionEClass, TREE_DESCRIPTION__RENAME_TOOL);
        createEReference(treeDescriptionEClass, TREE_DESCRIPTION__DELETE_TOOL);

        treeToolEClass = createEClass(TREE_TOOL);
        createEAttribute(treeToolEClass, TREE_TOOL__NAME);
        createEReference(treeToolEClass, TREE_TOOL__BODY);

        renameToolEClass = createEClass(RENAME_TOOL);

        deleteToolEClass = createEClass(DELETE_TOOL);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have no affect on any
     * invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ViewPackage theViewPackage = (ViewPackage) EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        treeDescriptionEClass.getESuperTypes().add(theViewPackage.getRepresentationDescription());
        renameToolEClass.getESuperTypes().add(this.getTreeTool());
        deleteToolEClass.getESuperTypes().add(this.getTreeTool());

        // Initialize classes, features, and operations; add parameters
        initEClass(treeDescriptionEClass, TreeDescription.class, "TreeDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTreeDescription_KindExpression(), theViewPackage.getInterpretedExpression(), "kindExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_IconURLExpression(), theViewPackage.getInterpretedExpression(), "iconURLExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_TreeItemIdExpression(), theViewPackage.getInterpretedExpression(), "treeItemIdExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_TargetObjectIdExpression(), theViewPackage.getInterpretedExpression(), "targetObjectIdExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_ElementsExpression(), theViewPackage.getInterpretedExpression(), "elementsExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_HasChildrenExpression(), theViewPackage.getInterpretedExpression(), "hasChildrenExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_ChildrenExpression(), theViewPackage.getInterpretedExpression(), "childrenExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_EditableExpression(), theViewPackage.getInterpretedExpression(), "editableExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_SelectableExpression(), theViewPackage.getInterpretedExpression(), "selectableExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getTreeDescription_DeletableExpression(), theViewPackage.getInterpretedExpression(), "deletableExpression", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTreeDescription_RenameTool(), this.getRenameTool(), null, "renameTool", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTreeDescription_DeleteTool(), this.getDeleteTool(), null, "deleteTool", null, 0, 1, TreeDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(treeToolEClass, TreeTool.class, "TreeTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getTreeTool_Name(), theViewPackage.getIdentifier(), "name", null, 0, 1, TreeTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEReference(getTreeTool_Body(), theViewPackage.getOperation(), null, "body", null, 0, -1, TreeTool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(renameToolEClass, RenameTool.class, "RenameTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(deleteToolEClass, DeleteTool.class, "DeleteTool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);
    }

} // TreePackageImpl
