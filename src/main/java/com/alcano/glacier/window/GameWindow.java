package com.alcano.glacier.window;

import com.alcano.gamemath.Vector2;
import com.alcano.glacier.core.GlacierAPI;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameWindow extends Window {

    private final Canvas canvas;

    public GameWindow(Vector2 size, String title) {
        super(size, title, EXIT_ON_CLOSE);

        this.canvas = new Canvas();
        this.canvas.setBounds(0, 0, size.x, size.y);
        this.add(this.canvas);
    }

    public void render() {
        BufferStrategy bs = this.canvas.getBufferStrategy();
        if (bs == null) {
            this.canvas.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        GlacierAPI.getGameRenderer().render(g);

        bs.show();
        g.dispose();
    }

    @Override
    public int getWidth() {
        return this.canvas.getWidth();
    }

    @Override
    public int getHeight() {
        return this.canvas.getHeight();
    }
}
