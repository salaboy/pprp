package org.pprp.core.api.internal;

import java.util.List;
import java.util.Map;

import org.pprp.core.api.model.BrushType;
import org.pprp.core.api.model.Stroke;
/*
 * painters physical body
 */
public interface InternalPainter {

    void cleanBrush();

    void mixColor(Stroke stroke);

    void selectBrush(Stroke stroke);

    void performStroke(Stroke stroke);

    BrushType getCurrentBrushType();

    void addOutputCanvas(String name,
                         OutputCanvas outputCanvas);

    void removeAllOutputCanvas();

    OutputCanvas getOutputCanvasByName(String name);

    Map<String, OutputCanvas> getOutputCanvases();

    List<String> getWorkQueue();
}
