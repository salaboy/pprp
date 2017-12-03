package org.pprp.core.api.events;

import org.pprp.core.api.model.Palette;

public abstract class AbstractPalettePainterEvent implements PalettePainterEvent {

    private Palette palette;

    public AbstractPalettePainterEvent(Palette palette) {
        this.palette = palette;
    }

    @Override
    public Palette getPalette() {
        return palette;
    }

    @Override
    public String toString() {
        return this.getEventType() + "{" +
                "palette=" + palette +
                '}';
    }
}
