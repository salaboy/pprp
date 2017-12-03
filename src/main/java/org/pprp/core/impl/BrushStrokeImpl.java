package org.pprp.core.impl;

import org.pprp.core.api.model.BrushStroke;
import org.pprp.core.api.model.BrushType;
import org.pprp.core.api.model.Point;

public class BrushStrokeImpl implements BrushStroke {

    private Point startPoint;
    private Point endPoint;

    private HueSaturationBrightness HSB;

    public BrushStrokeImpl(Point startPoint,
                           Point endPoint,
                           HueSaturationBrightness HSB) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.HSB = HSB;
    }

    @Override
    public BrushType getBrushType() {
        return new BasicBrushTypeImpl();
    }

    @Override
    public Point getStartPoint() {
        return startPoint;
    }

    @Override
    public Point getEndPoint() {
        return endPoint;
    }

    @Override
    public HueSaturationBrightness getHSB() {
        return HSB;
    }

    @Override
    public String toString() {
        return "BrushStroke{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", HSB=" + HSB +
                '}';
    }
}
