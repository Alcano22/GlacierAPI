package com.alcano.glacier.resource;

import com.alcano.glacier.texture.Sprite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Resources {

    private Resources() {}

    public static File loadFile(String path) {
        return new File(Resources.class.getClassLoader().getResource(path).getFile());
    }

    public static BufferedImage loadTexture(String path) {
        try {
            return ImageIO.read(loadFile(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Sprite loadSprite(String path) {
        return new Sprite(loadTexture(path));
    }

}
