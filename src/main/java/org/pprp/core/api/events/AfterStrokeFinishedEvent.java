package org.pprp.core.api.events;

import org.pprp.core.api.model.Stroke;

public class AfterStrokeFinishedEvent extends AbstractStrokePainterEvent {

    public AfterStrokeFinishedEvent(Stroke stroke) {
        super(stroke);
    }

    @Override
    public String getEventType() {
        return "AfterStrokeFinishedEvent";
    }
}
