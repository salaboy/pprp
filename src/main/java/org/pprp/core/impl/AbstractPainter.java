package org.pprp.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.pprp.core.api.Painter;
import org.pprp.core.api.events.AfterPaletteSetUpEvent;
import org.pprp.core.api.events.AfterStrokeFinishedEvent;
import org.pprp.core.api.events.BeforePaletteSetUpEvent;
import org.pprp.core.api.events.BeforeStrokeStartedEvent;
import org.pprp.core.api.internal.InternalPainter;
import org.pprp.core.api.internal.PainterEventListener;
import org.pprp.core.api.internal.TechnicalPainter;
import org.pprp.core.api.model.BrushType;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Stroke;

public abstract class AbstractPainter implements Painter,
                                                 InternalPainter,
                                                 TechnicalPainter {

    private Palette palette;
    private BrushType currentBrushType;

    private List<PainterEventListener> listeners = new ArrayList<>();

    @Override
    public void setUpPalette(Palette palette) {
        BeforePaletteSetUpEvent beforePaletteSetUpEvent = new BeforePaletteSetUpEvent();
        for (PainterEventListener pel : listeners) {
            pel.fireBeforePaletteSetUpEvent(beforePaletteSetUpEvent);
        }
        this.palette = palette;
        AfterPaletteSetUpEvent afterPaletteSetUpEvent = new AfterPaletteSetUpEvent();
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
        BeforeStrokeStartedEvent beforeStrokeStartedEvent = new BeforeStrokeStartedEvent();
        for (PainterEventListener pel : listeners) {
            pel.fireBeforeStrokeStarterEvent(beforeStrokeStartedEvent);
        }
        // do I need to select a brush?

        selectBrush(stroke);
        // Do I need to mix a color?
        mixColor(stroke);

        performStroke(stroke);

        // Do I need to clean the brush now?
        cleanBrush();
        AfterStrokeFinishedEvent afterStrokeFinishedEvent = new AfterStrokeFinishedEvent();
        for (PainterEventListener pel : listeners) {
            pel.fireAfterStrokeFinishedEvent(afterStrokeFinishedEvent);
        }
    }

    @Override
    public void cleanBrush() {
        //clean currentBrush
        this.currentBrushType = null;

        // then generate G-CODE to clean brush
    }

    @Override
    public void mixColor(Stroke stroke) {
        HueSaturationBrightness hsb = stroke.getHSB();
        //based on the stroke HSB mix the colors

        // then generate G-CODE to mix the color
    }

    @Override
    public void selectBrush(Stroke stroke) {
        //based on the stroke select a brush type
        this.currentBrushType = new BasicBrushTypeImpl();
    }

    @Override
    public void performStroke(Stroke stroke) {
        // Generate G-CODE for machine to paint
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
}
