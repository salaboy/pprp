package org.pprp.core.api.events;

public class BeforePaletteSetUpEvent implements PainterEvent{

    @Override
    public String getEventType() {
        return "BeforePaletteSetUpEvent";
    }
}
