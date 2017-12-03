package org.pprp.core.api;

import java.util.List;

import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Stroke;

public interface Painter {

    void setUpPalette(Palette palette);

    void paint(Stroke stroke);

    void paint(Stroke... strokes);


}
