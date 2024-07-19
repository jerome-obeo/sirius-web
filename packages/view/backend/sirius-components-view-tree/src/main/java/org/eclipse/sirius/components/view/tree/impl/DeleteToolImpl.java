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

import org.eclipse.sirius.components.view.tree.DeleteTool;
import org.eclipse.sirius.components.view.tree.TreePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Delete Tool</b></em>'. <!-- end-user-doc -->
 *
 * @generated
 */
public class DeleteToolImpl extends TreeToolImpl implements DeleteTool {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected DeleteToolImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return TreePackage.Literals.DELETE_TOOL;
    }

} // DeleteToolImpl
