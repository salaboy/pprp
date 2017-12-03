package org.pprp.core.api.events;

import org.pprp.core.api.model.Palette;

public interface PalettePainterEvent extends PainterEvent {

    Palette getPalette();
}
