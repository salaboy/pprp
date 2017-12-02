package org.pprp.core.api.events;

public class BeforeStrokeStartedEvent implements PainterEvent {

    @Override
    public String getEventType() {
        return "BeforeStrokeStartedEvent";
    }
}
