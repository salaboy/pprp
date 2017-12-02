package org.pprp.core.impl;

import org.pprp.core.api.model.BrushType;

public class BasicBrushTypeImpl implements BrushType {

    private final String BASIC_BRUSH_TYPE = "Basic";

    @Override
    public String getName() {
        return BASIC_BRUSH_TYPE;
    }
}
