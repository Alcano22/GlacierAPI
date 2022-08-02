package com.alcano.glacier.gameobject.component;

import com.alcano.gamemath.Vector2;
import com.alcano.gamemath.Vector2f;
import com.alcano.glacier.gameobject.GameObject;

import java.awt.*;

public class BoxCollider extends Component {

    public Vector2f scale = new Vector2f(1f, 1f);

    public BoxCollider(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GREEN);

        Vector2f size = this.getGameObject().transform.scale.mul(this.scale);
        Vector2 pos = new Vector2(this.getGameObject().transform.position.sub(size.div(2f)));
        g.drawRect(pos.x, pos.y, (int) size.x, (int) size.y);
    }
}
