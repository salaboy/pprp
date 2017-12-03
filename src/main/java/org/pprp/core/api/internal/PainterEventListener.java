package org.pprp.core.api.internal;

import org.pprp.core.api.events.AfterPaletteSetUpEvent;
import org.pprp.core.api.events.AfterStrokeFinishedEvent;
import org.pprp.core.api.events.BeforePaletteSetUpPainterEvent;
import org.pprp.core.api.events.BeforeStrokeStartedEvent;

public interface PainterEventListener {

    void fireBeforePaletteSetUpEvent(BeforePaletteSetUpPainterEvent bpse);

    void fireAfterPaletteSetUpEvent(AfterPaletteSetUpEvent apse);

    void fireBeforeStrokeStarterEvent(BeforeStrokeStartedEvent bsse);

    void fireAfterStrokeFinishedEvent(AfterStrokeFinishedEvent asfe);
}
