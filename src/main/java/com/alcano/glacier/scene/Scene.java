package com.alcano.glacier.scene;

import com.alcano.glacier.gameobject.GameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    public final List<GameObject> gameObjects = new ArrayList<>();

    public Color background;

    private final int id;

    public Scene(Color background) {
        this.background = background;
        this.id = SceneManager.getScenes().size();

        SceneManager.onSceneCreate(this);
    }

    public Scene() {
        this(new Color(41, 95, 190));
    }

    public void update() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    public void render(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            gameObject.render(g);
        }
    }

    public void addGameObject(GameObject gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void removeGameObject(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
    }

    public int getId() {
        return id;
    }
}
