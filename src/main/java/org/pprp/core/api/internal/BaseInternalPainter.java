package org.pprp.core.api.internal;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.pprp.core.api.internal.gcode.GCodeUtil;
import org.pprp.core.api.model.BrushType;
import org.pprp.core.api.model.Color;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Stroke;
import org.pprp.core.impl.BasicBrushTypeImpl;
import org.pprp.core.impl.HueSaturationBrightness;

public class BaseInternalPainter implements InternalPainter {

    private BrushType currentBrushType;
    private Map<String, OutputCanvas> outputCanvases = new ConcurrentHashMap<>();
    private List<String> workQueue = new CopyOnWriteArrayList<>();

    public BaseInternalPainter() {
        init();
    }

    @Override
    public void cleanBrush() {
        //clean currentBrush
        this.currentBrushType = null;

        // then generate G-CODE to clean brush
    }

    @Override
    public void init() {
        workQueue.add(GCodeUtil.generateGCodeForInitPPRP());

    }

    @Override
    public void pickColor(Palette palette, Stroke stroke) {
        HueSaturationBrightness hsb = stroke.getHSB();

        workQueue.add(GCodeUtil.generateGCodeForPickColor(palette, Color.BLACK));
    }

    @Override
    public void selectBrush(Stroke stroke) {
        //based on the stroke select a brush type
        this.currentBrushType = new BasicBrushTypeImpl();
    }

    @Override
    public void performStroke(Stroke stroke) {
        for (OutputCanvas oc : outputCanvases.values()) {
            oc.add(stroke);
        }
        workQueue.add(GCodeUtil.generateGCodeForStroke(stroke));
    }

    @Override
    public void addOutputCanvas(String name,
                                OutputCanvas outputCanvas) {
        outputCanvases.put(name,
                           outputCanvas);
    }

    @Override
    public void removeAllOutputCanvas() {
        outputCanvases.clear();
    }

    @Override
    public OutputCanvas getOutputCanvasByName(String name) {
        return outputCanvases.get(name);
    }

    public BrushType getCurrentBrushType() {
        return currentBrushType;
    }

    @Override
    public Map<String, OutputCanvas> getOutputCanvases() {
        return outputCanvases;
    }

    @Override
    public List<String> getWorkQueue() {
        return workQueue;
    }
}
