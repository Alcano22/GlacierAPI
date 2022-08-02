package com.alcano.glacier.math;

import com.alcano.gamemath.Vector2;

public enum Axis {

    HORIZONTAL(new Vector2(1, 0)),
    VERTICAL(new Vector2(0, 1));

    public final Vector2 vec;

    Axis(Vector2 vec) {
        this.vec = vec;
    }

}
