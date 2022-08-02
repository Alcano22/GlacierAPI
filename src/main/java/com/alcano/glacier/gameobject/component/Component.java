package com.alcano.glacier.gameobject.component;

import com.alcano.glacier.gameobject.GameObject;
import com.alcano.glacier.scene.SceneManager;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Component implements ComponentHolder {

    private final UUID gameObjectUUID;

    public Component(GameObject gameObject) {
        this.gameObjectUUID = gameObject.uniqueId;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    public GameObject getGameObject() {
        for (GameObject gameObject : SceneManager.getCurrentScene().gameObjects) {
            if (gameObject.uniqueId.equals(this.gameObjectUUID)) return gameObject;
        }

        return null;
    }

    public <T extends Component> T addComponent(Class<T> componentClass) {
        try {
            T component = (T) componentClass.getDeclaredConstructors()[0].newInstance();
            this.getGameObject().components.add(component);

            return component;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for (Component component : this.getGameObject().components) {
            if (component.getClass().equals(componentClass)) {
                this.getGameObject().components.remove(component);
                return;
            }
        }
    }

    @Override
    public <T extends Component> void removeComponents(Class<T> componentClass) {
        this.getGameObject().components.removeIf(component -> component.getClass().equals(componentClass));
    }

    @Override
    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component component : this.getGameObject().components) {
            if (component.getClass().equals(componentClass)) return (T) component;
        }

        return null;
    }

    @Override
    public <T extends Component> java.util.List<T> getComponents(Class<T> componentClass) {
        List<T> foundComponents = new ArrayList<>();
        for (Component component : this.getGameObject().components) {
            if (component.getClass().equals(componentClass)) foundComponents.add((T) component);
        }

        return foundComponents;
    }
}
