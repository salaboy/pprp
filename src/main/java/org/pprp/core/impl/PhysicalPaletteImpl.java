package org.pprp.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.pprp.core.api.model.Color;
import org.pprp.core.api.model.Point;

public class PhysicalPaletteImpl extends BasePaletteImpl {

    private List<Color> availableColors = new ArrayList<>();
    private Map<Color, Point> huePositions = new HashMap<>();


    public PhysicalPaletteImpl() {
        //init HUE Colors positions
        huePositions.put(Color.RED,
                         new BasePointImpl(0,
                                           0));
        huePositions.put(Color.BLUE,
                         new BasePointImpl(45,
                                           0));
        huePositions.put(Color.GREEN,
                         new BasePointImpl(90,
                                           0));
        huePositions.put(Color.ORANGE,
                         new BasePointImpl(135,
                                           0));
        huePositions.put(Color.YELLOW,
                         new BasePointImpl(180,
                                           0));
        huePositions.put(Color.VIOLET,
                         new BasePointImpl(225,
                                           0));
        //Greyscale
        huePositions.put(Color.BLACK,
                         new BasePointImpl(0,
                                           45));
        huePositions.put(Color.GREY80,
                         new BasePointImpl(45,
                                           45));
        huePositions.put(Color.GREY60,
                         new BasePointImpl(90,
                                           45));
        huePositions.put(Color.GREY40,
                         new BasePointImpl(135,
                                           45));
        huePositions.put(Color.GREY20,
                         new BasePointImpl(180,
                                           45));
        huePositions.put(Color.WHITE,
                         new BasePointImpl(225,
                                           45));
    }

    @Override
    public List<Color> getAvailableColors() {
        return availableColors;
    }

    @Override
    public void cleanBrush() {

    }

    @Override
    public Point getColorPoint(Color color) {
        return huePositions.get(color);
    }
}
