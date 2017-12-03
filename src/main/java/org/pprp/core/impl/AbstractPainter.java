package org.pprp.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.pprp.core.api.Painter;
import org.pprp.core.api.events.AfterPaletteSetUpEvent;
import org.pprp.core.api.events.AfterStrokeFinishedEvent;
import org.pprp.core.api.events.BeforePaletteSetUpPainterEvent;
import org.pprp.core.api.events.BeforeStrokeStartedEvent;
import org.pprp.core.api.internal.InternalPainter;
import org.pprp.core.api.internal.PainterEventListener;
import org.pprp.core.api.internal.TechnicalPainter;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Stroke;

public abstract class AbstractPainter implements Painter,
                                                 TechnicalPainter {

    private Palette palette;

    private InternalPainter internalPainter;

    private List<PainterEventListener> listeners = new ArrayList<>();

    public AbstractPainter(InternalPainter internalPainter) {
        this.internalPainter = internalPainter;
    }

    @Override
    public void setUpPalette(Palette palette) {
        BeforePaletteSetUpPainterEvent beforePaletteSetUpEvent = new BeforePaletteSetUpPainterEvent(palette);
        for (PainterEventListener pel : listeners) {
            pel.fireBeforePaletteSetUpEvent(beforePaletteSetUpEvent);
        }
        this.palette = palette;
        AfterPaletteSetUpEvent afterPaletteSetUpEvent = new AfterPaletteSetUpEvent(palette);
        for (PainterEventListener pel : listeners) {
            pel.fireAfterPaletteSetUpEvent(afterPaletteSetUpEvent);
        }
    }

    @Override
    public void paint(Stroke... strokes) {
        for (Stroke stroke : strokes) {
            paint(stroke);
        }
    }

    @Override
    public void paint(Stroke stroke) {

        BeforeStrokeStartedEvent beforeStrokeStartedEvent = new BeforeStrokeStartedEvent(stroke);
        for (PainterEventListener pel : listeners) {
            pel.fireBeforeStrokeStarterEvent(beforeStrokeStartedEvent);
        }
        // do I need to select a brush?

        internalPainter.selectBrush(stroke);
        // Do I need to mix a color?
        internalPainter.mixColor(stroke);

        internalPainter.performStroke(stroke);

        // Do I need to clean the brush now?
        internalPainter.cleanBrush();
        AfterStrokeFinishedEvent afterStrokeFinishedEvent = new AfterStrokeFinishedEvent(stroke);
        for (PainterEventListener pel : listeners) {
            pel.fireAfterStrokeFinishedEvent(afterStrokeFinishedEvent);
        }
    }

    @Override
    public void addPainterEventListener(PainterEventListener painterEventListener) {
        listeners.add(painterEventListener);
    }

    @Override
    public void removeAllPainterEventListener() {
        listeners.clear();
    }

    @Override
    public List<PainterEventListener> getAllPainterEventListener() {
        return listeners;
    }

    public Palette getPalette() {
        return palette;
    }

    public InternalPainter getInternalPainter() {
        return internalPainter;
    }
}
