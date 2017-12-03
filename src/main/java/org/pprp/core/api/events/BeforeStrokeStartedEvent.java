package org.pprp.core.api.events;

import org.pprp.core.api.model.Stroke;

public class BeforeStrokeStartedEvent extends AbstractStrokePainterEvent {

    public BeforeStrokeStartedEvent(Stroke stroke) {
        super(stroke);
    }

    @Override
    public String getEventType() {
        return "BeforeStrokeStartedEvent";
    }
}
