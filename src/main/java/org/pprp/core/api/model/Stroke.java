package org.pprp.core.api.model;

import org.pprp.core.impl.HueSaturationBrightness;

public interface Stroke {

    Point getStartPoint();

    Point getEndPoint();

    HueSaturationBrightness getHSB();

}
