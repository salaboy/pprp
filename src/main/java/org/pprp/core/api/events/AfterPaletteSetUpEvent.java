package org.pprp.core.api.events;

import org.pprp.core.api.model.Palette;

public class AfterPaletteSetUpEvent extends AbstractPalettePainterEvent {

    public AfterPaletteSetUpEvent(Palette palette) {
        super(palette);
    }

    @Override
    public String getEventType() {
        return "AfterPaletteSetUpEvent";
    }
}
