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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.sirius.components.view.tree.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class TreeFactoryImpl extends EFactoryImpl implements TreeFactory {
    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static TreeFactory init() {
        try {
            TreeFactory theTreeFactory = (TreeFactory) EPackage.Registry.INSTANCE.getEFactory(TreePackage.eNS_URI);
            if (theTreeFactory != null) {
                return theTreeFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new TreeFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public TreeFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case TreePackage.TREE_DESCRIPTION:
                return createTreeDescription();
            case TreePackage.TREE_TOOL:
                return createTreeTool();
            case TreePackage.RENAME_TOOL:
                return createRenameTool();
            case TreePackage.DELETE_TOOL:
                return createDeleteTool();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TreeDescription createTreeDescription() {
        TreeDescriptionImpl treeDescription = new TreeDescriptionImpl();
        return treeDescription;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TreeTool createTreeTool() {
        TreeToolImpl treeTool = new TreeToolImpl();
        return treeTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public RenameTool createRenameTool() {
        RenameToolImpl renameTool = new RenameToolImpl();
        return renameTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public DeleteTool createDeleteTool() {
        DeleteToolImpl deleteTool = new DeleteToolImpl();
        return deleteTool;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public TreePackage getTreePackage() {
        return (TreePackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static TreePackage getPackage() {
        return TreePackage.eINSTANCE;
    }

} // TreeFactoryImpl
