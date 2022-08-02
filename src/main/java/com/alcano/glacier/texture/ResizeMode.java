package com.alcano.glacier.texture;

import java.awt.*;

public enum ResizeMode {

    DEFAULT(Image.SCALE_DEFAULT),
    FAST(Image.SCALE_FAST),
    SMOOTH(Image.SCALE_SMOOTH),
    REPLICATE(Image.SCALE_REPLICATE),
    AREA_AVERAGING(Image.SCALE_AREA_AVERAGING);

    public final int value;

    ResizeMode(int value) {
        this.value = value;
    }
}
