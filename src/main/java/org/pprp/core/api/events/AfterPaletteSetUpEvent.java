package org.pprp.core.api.events;

public class AfterPaletteSetUpEvent implements PainterEvent{

    @Override
    public String getEventType() {
        return "AfterPaletteSetUpEvent";
    }
}
