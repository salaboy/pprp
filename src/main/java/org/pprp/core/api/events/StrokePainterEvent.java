package org.pprp.core.api.events;

import org.pprp.core.api.model.Stroke;

public interface StrokePainterEvent extends PainterEvent {
    Stroke getStroke();
}
