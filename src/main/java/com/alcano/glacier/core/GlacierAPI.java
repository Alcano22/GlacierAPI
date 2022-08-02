package com.alcano.glacier.core;

import com.alcano.gamemath.Vector2;
import com.alcano.glacier.rendering.GameRenderer;
import com.alcano.glacier.window.GameWindow;

public final class GlacierAPI {

    public static boolean debug;

    private static GameLoop gameLoop;
    private static GameWindow gameWindow;
    private static GameRenderer gameRenderer;

    private GlacierAPI() {}

    public static GameWindow initialize(Vector2 windowSize, String gameName) {
        gameWindow = new GameWindow(windowSize, gameName);

        gameRenderer = new GameRenderer(gameWindow);

        gameLoop = new GameLoop();
        gameLoop.start();

        return gameWindow;
    }

    public static GameWindow getGameWindow() {
        return gameWindow;
    }

    public static GameRenderer getGameRenderer() {
        return gameRenderer;
    }
}
