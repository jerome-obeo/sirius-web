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
package org.eclipse.sirius.web.services.diagramfilter.api;

import org.eclipse.sirius.components.forms.description.FormDescription;

/**
 * Interface used to contribute the form to display for the "Diagram Filter" view.
 *
 * @author gdaniel
 */
public interface IDiagramFilterDescriptionProvider {

    FormDescription getFormDescription();

}
