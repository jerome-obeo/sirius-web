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
package org.eclipse.sirius.web.application.representation.services;

import java.util.Objects;

import org.eclipse.sirius.components.collaborative.api.IRepresentationMetadataPersistenceService;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.events.ICause;
import org.eclipse.sirius.web.application.UUIDParser;
import org.eclipse.sirius.web.domain.boundedcontexts.representationdata.services.api.IRepresentationMetadataCreationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Used to persist representation metadata.
 *
 * @author gcoutable
 */
@Service
public class RepresentationMetadataPersistenceService implements IRepresentationMetadataPersistenceService {

    private final IRepresentationMetadataCreationService representationMetadataCreationService;

    public RepresentationMetadataPersistenceService(IRepresentationMetadataCreationService representationMetadataCreationService) {
        this.representationMetadataCreationService = Objects.requireNonNull(representationMetadataCreationService);
    }

    @Override
    @Transactional
    public void save(ICause cause, IEditingContext editingContext, org.eclipse.sirius.components.core.RepresentationMetadata representationMetadata, String targetObjectId) {
        var optionalProjectId = new UUIDParser().parse(editingContext.getId());
        var optionalRepresentationId = new UUIDParser().parse(representationMetadata.id());

        if (optionalProjectId.isPresent() && optionalRepresentationId.isPresent()) {
            var projectId = optionalProjectId.get();
            var representationId = optionalRepresentationId.get();
            this.representationMetadataCreationService.create(cause, representationId, projectId, representationMetadata.label(), representationMetadata.kind(),
                    representationMetadata.descriptionId(), targetObjectId);
        }
    }
}
