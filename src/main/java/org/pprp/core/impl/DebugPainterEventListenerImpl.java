package org.pprp.core.impl;

import org.pprp.core.api.events.AfterPaletteSetUpEvent;
import org.pprp.core.api.events.AfterStrokeFinishedEvent;
import org.pprp.core.api.events.BeforePaletteSetUpPainterEvent;
import org.pprp.core.api.events.BeforeStrokeStartedEvent;
import org.pprp.core.api.internal.PainterEventListener;

public class DebugPainterEventListenerImpl implements PainterEventListener {

    @Override
    public void fireBeforePaletteSetUpEvent(BeforePaletteSetUpPainterEvent bpse) {
        System.out.println(bpse);
    }

    @Override
    public void fireAfterPaletteSetUpEvent(AfterPaletteSetUpEvent apse) {
        System.out.println(apse);
    }

    @Override
    public void fireBeforeStrokeStarterEvent(BeforeStrokeStartedEvent bsse) {
        System.out.println(bsse);
    }

    @Override
    public void fireAfterStrokeFinishedEvent(AfterStrokeFinishedEvent asfe) {
        System.out.println(asfe);
    }
}
