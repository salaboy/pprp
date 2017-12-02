package org.pprp.core.api.events;

public class AfterStrokeFinishedEvent implements PainterEvent {

    @Override
    public String getEventType() {
        return "AfterStrokeFinishedEvent";
    }
}
