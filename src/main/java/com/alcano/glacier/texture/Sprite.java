package com.alcano.glacier.texture;

import com.alcano.gamemath.Vector2;
import com.alcano.glacier.math.Axis;

import java.awt.image.BufferedImage;

public class Sprite {

    public BufferedImage texture;

    public Sprite(BufferedImage texture) {
        this.texture = texture;
    }

    public void flip(Axis flipAxis) {
        this.texture = this.flipped(flipAxis).texture;
    }

    public Sprite flipped(Axis flipAxis) {
        return new Sprite(TextureUtils.flip(this.texture, flipAxis));
    }

    public void resize(Vector2 newSize, ResizeMode mode) {
        this.texture = this.resized(newSize, mode).texture;
    }

    public Sprite resized(Vector2 newSize, ResizeMode mode) {
        return new Sprite(TextureUtils.resize(this.texture, newSize, mode));
    }
}
