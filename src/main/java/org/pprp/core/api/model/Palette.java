package org.pprp.core.api.model;

import java.util.List;

public interface Palette {
    List<Color> getAvailableColors();

    void cleanBrush();

    Point getColorPoint(Color color);
}
