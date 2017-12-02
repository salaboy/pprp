package org.pprp.core.api.internal;

import org.pprp.core.api.model.Stroke;

public interface InternalPainter {

    void cleanBrush();

    void mixColor(Stroke stroke);

    void selectBrush(Stroke stroke);

    void performStroke(Stroke stroke);
}
