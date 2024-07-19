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
package org.eclipse.sirius.components.view.emf.tree;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.interpreter.AQLInterpreter;
import org.eclipse.sirius.components.representations.IRepresentationDescription;
import org.eclipse.sirius.components.representations.VariableManager;
import org.eclipse.sirius.components.trees.description.TreeDescription;
import org.eclipse.sirius.components.trees.renderer.TreeRenderer;
import org.eclipse.sirius.components.view.RepresentationDescription;
import org.eclipse.sirius.components.view.emf.IRepresentationDescriptionConverter;
import org.springframework.stereotype.Service;

/**
 * Converts a View-based tree description into an equivalent {@link TreeDescription}.
 *
 * @author Jerome Gout
 */
@Service
public class ViewTreeDescriptionConverter implements IRepresentationDescriptionConverter {

    private static final String DEFAULT_TREE_LABEL = "Tree";

    private static final String DEFAULT_TREE_DESCRIPTION_LABEL = "Tree Description";

    private final ITreeIdProvider treeIdProvider;

    public ViewTreeDescriptionConverter(ITreeIdProvider treeIdProvider) {
        this.treeIdProvider = Objects.requireNonNull(treeIdProvider);
    }

    @Override
    public boolean canConvert(RepresentationDescription representationDescription) {
        return representationDescription instanceof org.eclipse.sirius.components.view.tree.TreeDescription;
    }

    @Override
    public IRepresentationDescription convert(RepresentationDescription representationDescription, List<RepresentationDescription> allRepresentationDescriptions, AQLInterpreter interpreter) {
        var viewTreeDescription = (org.eclipse.sirius.components.view.tree.TreeDescription) representationDescription;
        var id = this.treeIdProvider.getId(viewTreeDescription);
        var label = Optional.ofNullable(viewTreeDescription.getName()).orElse(DEFAULT_TREE_DESCRIPTION_LABEL);

        var builder = TreeDescription.newTreeDescription(id)
                .label(label)
                .idProvider(this::getTreeId)
                .labelProvider(variableManager -> this.computeTreeLabel(viewTreeDescription, variableManager, interpreter))
                .treeItemIdProvider(this::getTreeItemId)
                .kindProvider(this::getKind)
                .targetObjectIdProvider(variableManager -> variableManager.get(IEditingContext.EDITING_CONTEXT, IEditingContext.class).map(IEditingContext::getId).orElse(null))
                .iconURLProvider(this::getImageURL)
                .editableProvider(this::isEditable)
                .deletableProvider(this::isDeletable)
                .selectableProvider(this::isSelectable)
                .elementsProvider(this.explorerElementsProvider::getElements)
                .hasChildrenProvider(this.explorerChildrenProvider::hasChildren)
                .childrenProvider(this.explorerChildrenProvider::getChildren)
                .canCreatePredicate(canCreatePredicate)
                .deleteHandler(this::getDeleteHandler)
                .renameHandler(this::getRenameHandler);
        return builder.build();
    }

    private String computeTreeLabel(org.eclipse.sirius.components.view.tree.TreeDescription viewTreeDescription, VariableManager variableManager, AQLInterpreter interpreter) {
        String title = variableManager.get(org.eclipse.sirius.components.trees.description.TreeDescription.LABEL, String.class)
                .orElseGet(() -> this.evaluateString(interpreter, variableManager, viewDeckDescription.getTitleExpression()));
        if (title == null || title.isBlank()) {
            return DEFAULT_TREE_LABEL;
        } else {
            return title;
        }
    }

    private String getTreeId(VariableManager variableManager) {
        List<?> expandedObjects = variableManager.get(TreeRenderer.EXPANDED, List.class).orElse(List.of());
        List<?> activatedFilters = variableManager.get(TreeRenderer.ACTIVE_FILTER_IDS, List.class).orElse(List.of());
        return this.getExplorerTreeId(expandedObjects, activatedFilters);
    }

    private String getExplorerTreeId(List<?> expandedObjects, List<?> activatedFilters) {
        List<String> expandedObjectIds = expandedObjects.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .map(id -> URLEncoder.encode(id, StandardCharsets.UTF_8))
                .toList();

        List<String> activatedFilterIds = activatedFilters.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .map(id -> URLEncoder.encode(id, StandardCharsets.UTF_8))
                .toList();

        return "explorer://?expandedIds=[" + String.join(",", expandedObjectIds) + "]&activeFilterIds=[" + String.join(",", activatedFilterIds) + "]";
    }

}
