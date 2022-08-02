package com.alcano.glacier.gameobject.component;

import com.alcano.gamemath.Vector2f;

public class Transform {

    public static final Transform DEFAULT = new Transform(Vector2f.ZERO, new Vector2f(50f, 50f));

    public Vector2f position;
    public Vector2f scale;

    public Transform(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
    }

    public Vector2f getTranslatedPosition(Vector2f offset) {
        return this.position.sub((this.scale.div(2f))).add(offset);
    }

    public Vector2f getTranslatedPosition() {
        return this.getTranslatedPosition(Vector2f.ZERO);
    }

}
