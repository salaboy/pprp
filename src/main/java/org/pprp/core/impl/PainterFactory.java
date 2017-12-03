package org.pprp.core.impl;

import java.util.List;

import org.pprp.core.api.Painter;
import org.pprp.core.api.internal.BaseInternalPainter;
import org.pprp.core.api.internal.PainterEventListener;
import org.pprp.core.api.internal.TechnicalPainter;
import org.pprp.core.api.model.Palette;

public class PainterFactory {

    private static PainterEventListener debugPel = new DebugPainterEventListenerImpl();

    public static Painter createDefaultPainter(List<String> canvasNames) {
        Painter painter = new BasicPainterImpl(new BaseInternalPainter());

        ((TechnicalPainter) painter).addPainterEventListener(debugPel);

        for (String canvas : canvasNames) {
            ((AbstractPainter) painter).getInternalPainter().addOutputCanvas(canvas,
                                                                             new CopyOnWriteOutputCanvas());
        }

        return painter;
    }
}
