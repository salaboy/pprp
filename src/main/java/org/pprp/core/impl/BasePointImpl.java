package org.pprp.core.impl;

import org.pprp.core.api.model.Point;

public class BasePointImpl implements Point {

    private int x;
    private int y;

    public BasePointImpl(int x,
                         int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
