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
package org.eclipse.sirius.components.collaborative.forms.handlers;

import java.util.Objects;

import org.eclipse.sirius.components.collaborative.api.ChangeDescription;
import org.eclipse.sirius.components.collaborative.api.ChangeKind;
import org.eclipse.sirius.components.collaborative.api.Monitoring;
import org.eclipse.sirius.components.collaborative.forms.api.IFormEventHandler;
import org.eclipse.sirius.components.collaborative.forms.api.IFormInput;
import org.eclipse.sirius.components.collaborative.forms.api.IFormQueryService;
import org.eclipse.sirius.components.collaborative.forms.dto.AddImageInput;
import org.eclipse.sirius.components.collaborative.forms.messages.ICollaborativeFormMessageService;
import org.eclipse.sirius.components.core.api.ErrorPayload;
import org.eclipse.sirius.components.core.api.IEditingContext;
import org.eclipse.sirius.components.core.api.IPayload;
import org.eclipse.sirius.components.core.api.SuccessPayload;
import org.eclipse.sirius.components.forms.AbstractWidget;
import org.eclipse.sirius.components.forms.Form;
import org.eclipse.sirius.components.forms.ImagePicker;
import org.eclipse.sirius.components.representations.Failure;
import org.eclipse.sirius.components.representations.IStatus;
import org.eclipse.sirius.components.representations.Success;
import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Sinks.Many;
import reactor.core.publisher.Sinks.One;

/**
 * The handler of the image picker add image event.
 *
 * @author Jerome Gout
 */
@Service
public class AddImageEventHandler implements IFormEventHandler {
    private final ICollaborativeFormMessageService messageService;

    private final Counter counter;

    private final IFormQueryService formQueryService;

    public AddImageEventHandler(IFormQueryService formQueryService, ICollaborativeFormMessageService messageService, MeterRegistry meterRegistry) {
        this.formQueryService = Objects.requireNonNull(formQueryService);
        this.messageService = Objects.requireNonNull(messageService);

        // @formatter:off
        this.counter = Counter.builder(Monitoring.EVENT_HANDLER)
                .tag(Monitoring.NAME, this.getClass().getSimpleName())
                .register(meterRegistry);
        // @formatter:on
    }

    @Override
    public boolean canHandle(IFormInput formInput) {
        return formInput instanceof AddImageInput;
    }

    @Override
    public void handle(One<IPayload> payloadSink, Many<ChangeDescription> changeDescriptionSink, IEditingContext editingContext, Form form, IFormInput formInput) {
        this.counter.increment();
        String message = this.messageService.invalidInput(formInput.getClass().getSimpleName(), AddImageInput.class.getSimpleName());
        IPayload payload = new ErrorPayload(formInput.id(), message);
        ChangeDescription changeDescription = new ChangeDescription(ChangeKind.SEMANTIC_CHANGE, formInput.representationId(), formInput);

        if (formInput instanceof AddImageInput input) {

            var optionalImagePicker = this.formQueryService.findWidget(form, input.imagePickerId());

            IStatus status;
            if (optionalImagePicker.map(AbstractWidget::isReadOnly).filter(Boolean::booleanValue).isPresent()) {
                status = new Failure("Read-only widget cannot be edited");
            } else {
                var handler = optionalImagePicker.filter(ImagePicker.class::isInstance)
                        .map(ImagePicker.class::cast)
                        .map(ImagePicker::getNewValueHandler);
                status = handler.map(h -> h.apply(input.imageId())).orElse(new Failure(""));
            }
            if (status instanceof Success success) {
                changeDescription = new ChangeDescription(success.getChangeKind(), formInput.representationId(), formInput, success.getParameters());
                payload = new SuccessPayload(formInput.id(), success.getMessages());
            } else if (status instanceof Failure failure) {
                payload = new ErrorPayload(formInput.id(), failure.getMessages());
            }
        }

        changeDescriptionSink.tryEmitNext(changeDescription);
        payloadSink.tryEmitValue(payload);
    }

}
