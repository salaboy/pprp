package org.pprp.core.api.internal;

import java.util.List;

import org.pprp.core.api.Painter;

public interface TechnicalPainter extends Painter{

    void addPainterEventListener(PainterEventListener painterEventListener);

    void removeAllPainterEventListener();

    List<PainterEventListener> getAllPainterEventListener();
}
