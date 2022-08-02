package com.alcano.glacier.rendering;

import com.alcano.gamemath.Mathf;
import com.alcano.glacier.core.GlacierAPI;
import com.alcano.glacier.scene.SceneManager;
import com.alcano.glacier.window.GameWindow;

import java.awt.*;

public class GameRenderer {

    private static final int GRID_COLOR_FACTOR = 60;

    public GameWindow gameWindow;

    public GameRenderer(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void render(Graphics g) {
        Color background = SceneManager.getCurrentScene().background;

        g.setColor(background);
        g.fillRect(0, 0, gameWindow.getWidth(), gameWindow.getHeight());

        if (GlacierAPI.debug) {
            Color gridColor = new Color(
                    Mathf.clamp(background.getRed() + GRID_COLOR_FACTOR, 0, 255),
                    Mathf.clamp(background.getGreen() + GRID_COLOR_FACTOR, 0, 255),
                    Mathf.clamp(background.getBlue() + GRID_COLOR_FACTOR, 0, 255));

            g.setColor(gridColor);
            g.drawLine(0, gameWindow.getHeight() / 2, gameWindow.getWidth(), gameWindow.getHeight() / 2);
            g.drawLine(gameWindow.getWidth() / 2, 0, gameWindow.getWidth() / 2, gameWindow.getHeight());
        }

        g.translate(gameWindow.getWidth() / 2, gameWindow.getHeight() / 2);
        ((Graphics2D) g).scale(1f, -1f);

        SceneManager.renderCurrentScene(g);
    }

}
