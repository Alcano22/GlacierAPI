package com.alcano.glacier.texture;

import com.alcano.gamemath.Vector2;
import com.alcano.glacier.math.Axis;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class TextureUtils {

    private TextureUtils() {}

    public static BufferedImage resize(BufferedImage tex, Vector2 newSize, ResizeMode mode) {
        Image tmp = tex.getScaledInstance(newSize.x, newSize.y, mode.value);
        BufferedImage newTex = new BufferedImage(newSize.x, newSize.y, tex.getType());

        Graphics2D g2d = newTex.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return newTex;
    }

    public static BufferedImage flip(BufferedImage tex, Axis flipAxis) {
        BufferedImage newTex = new BufferedImage(tex.getWidth(), tex.getHeight(), tex.getType());

        Graphics g = newTex.createGraphics();
        switch (flipAxis) {
            case HORIZONTAL -> g.drawImage(tex, tex.getWidth(), 0, -tex.getWidth(), tex.getHeight(), null);
            case VERTICAL -> g.drawImage(tex, 0, tex.getHeight(), tex.getWidth(), -tex.getHeight(), null);
        }
        g.dispose();

        return newTex;
    }

}
