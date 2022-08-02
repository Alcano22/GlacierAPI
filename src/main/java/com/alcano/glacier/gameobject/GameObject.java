package com.alcano.glacier.gameobject;

import com.alcano.gamemath.Vector2f;
import com.alcano.glacier.gameobject.component.Component;
import com.alcano.glacier.gameobject.component.ComponentHolder;
import com.alcano.glacier.gameobject.component.Transform;
import com.alcano.glacier.scene.SceneManager;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GameObject implements ComponentHolder {

    public final UUID uniqueId;
    public final List<Component> components = new ArrayList<>();

    public Transform transform;
    public String tag;

    public GameObject(Transform transform) {
        this.transform = transform;
        this.uniqueId = UUID.randomUUID();
    }

    public void update() {
        for (Component component : this.components) {
            component.update();
        }
    }

    public void render(Graphics g) {
        for (Component component : this.components) {
            component.render(g);
        }
    }

    public <T extends Component> T addComponent(Class<T> componentClass) {
        try {
            T component = (T) componentClass.getDeclaredConstructors()[0].newInstance(this);

            this.components.add(component);

            return component;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T extends Component> void removeComponent(Class<T> componentClass) {
        for (Component component : this.components) {
            if (component.getClass().equals(componentClass)) {
                this.components.remove(component);
                return;
            }
        }
    }

    @Override
    public <T extends Component> void removeComponents(Class<T> componentClass) {
        this.components.removeIf(component -> component.getClass().equals(componentClass));
    }

    @Override
    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component component : this.components) {
            if (component.getClass().equals(componentClass)) return (T) component;
        }

        return null;
    }

    @Override
    public <T extends Component> List<T> getComponents(Class<T> componentClass) {
        List<T> foundComponents = new ArrayList<>();
        for (Component component : this.components) {
            if (component.getClass().equals(componentClass)) foundComponents.add((T) component);
        }

        return foundComponents;
    }

    public boolean compareTag(String tag) {
        return this.tag.equals(tag);
    }

    public static void instantiate(GameObject gameObject) {
        SceneManager.getCurrentScene().addGameObject(gameObject);
    }

    public static void destroy(GameObject gameObject) {
        SceneManager.getCurrentScene().removeGameObject(gameObject);
    }
}
