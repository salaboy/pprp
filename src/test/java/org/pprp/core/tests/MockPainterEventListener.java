package org.pprp.core.tests;

import java.util.ArrayList;
import java.util.List;

import org.pprp.core.api.events.AfterPaletteSetUpEvent;
import org.pprp.core.api.events.AfterStrokeFinishedEvent;
import org.pprp.core.api.events.BeforePaletteSetUpEvent;
import org.pprp.core.api.events.BeforeStrokeStartedEvent;
import org.pprp.core.api.events.PainterEvent;
import org.pprp.core.api.internal.PainterEventListener;

public class MockPainterEventListener implements PainterEventListener {

    private List<PainterEvent> events = new ArrayList<>();

    @Override
    public void fireBeforePaletteSetUpEvent(BeforePaletteSetUpEvent bpse) {
        events.add(bpse);
    }

    @Override
    public void fireAfterPaletteSetUpEvent(AfterPaletteSetUpEvent apse) {
        events.add(apse);
    }

    @Override
    public void fireBeforeStrokeStarterEvent(BeforeStrokeStartedEvent bsse) {
        events.add(bsse);
    }

    @Override
    public void fireAfterStrokeFinishedEvent(AfterStrokeFinishedEvent asfe) {
        events.add(asfe);
    }

    public List<PainterEvent> getEvents() {
        return events;
    }
}
