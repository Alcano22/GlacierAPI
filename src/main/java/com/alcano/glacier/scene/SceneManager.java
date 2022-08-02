package com.alcano.glacier.scene;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public final class SceneManager {

    private static final List<Scene> SCENES = new ArrayList<>();

    private static Scene currentScene;

    private SceneManager() {}

    public static void loadScene(Scene scene) {
        currentScene = scene;
    }

    public static void updateCurrentScene() {
        currentScene.update();
    }

    public static void renderCurrentScene(Graphics g) {
        currentScene.render(g);
    }

    public static List<Scene> getScenes() {
        return SCENES;
    }

    public static Scene getCurrentScene() {
        return currentScene;
    }

    static void onSceneCreate(Scene scene) {
        SCENES.add(scene);
        if (currentScene == null) {
            loadScene(scene);
        }
    }
}
