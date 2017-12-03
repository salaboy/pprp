package org.pprp.core.api.events;

import org.pprp.core.api.model.Palette;

public class BeforePaletteSetUpPainterEvent extends AbstractPalettePainterEvent {

    public BeforePaletteSetUpPainterEvent(Palette palette) {
        super(palette);
    }

    @Override
    public String getEventType() {
        return "BeforePaletteSetUpPainterEvent";
    }
}
