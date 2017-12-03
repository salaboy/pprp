package org.pprp.core.api.events;

import org.pprp.core.api.model.Stroke;

public abstract class AbstractStrokePainterEvent implements StrokePainterEvent {

    private Stroke stroke;

    public AbstractStrokePainterEvent(Stroke stroke) {
        this.stroke = stroke;
    }

    @Override
    public Stroke getStroke() {
        return stroke;
    }

    @Override
    public String toString() {
        return this.getEventType() + "{" +
                "stroke=" + stroke +
                '}';
    }
}
