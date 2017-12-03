package org.pprp.core.impl;

import org.pprp.core.api.internal.InternalPainter;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Stroke;

public class BasicPainterImpl extends AbstractPainter {

    public BasicPainterImpl(InternalPainter internalPainter) {
        super(internalPainter);
    }

    @Override
    public void setUpPalette(Palette palette) {

        super.setUpPalette(palette);
    }

    @Override
    public void paint(Stroke... strokes) {
        super.paint(strokes);
    }

    @Override
    public void paint(Stroke stroke) {

        super.paint(stroke);
    }
}
