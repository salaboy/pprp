package org.pprp.core.impl;

import java.util.ArrayList;
import java.util.List;

import org.pprp.core.api.model.Color;
import org.pprp.core.api.model.Palette;
import org.pprp.core.api.model.Point;

public class BasePaletteImpl implements Palette {

    private List<Color> availableColors = new ArrayList<>();

    @Override
    public List<Color> getAvailableColors() {
        return availableColors;
    }

    @Override
    public void cleanBrush() {

    }

    @Override
    public Point getColorPoint(Color color) {
        return null;
    }
}
