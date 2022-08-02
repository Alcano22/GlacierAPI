package com.alcano.glacier.gameobject.component;

import com.alcano.gamemath.Vector2;
import com.alcano.gamemath.Vector2f;
import com.alcano.glacier.gameobject.GameObject;
import com.alcano.glacier.math.Axis;
import com.alcano.glacier.texture.ResizeMode;
import com.alcano.glacier.texture.Sprite;

import java.awt.*;

public class SpriteRenderer extends Component {

    public Sprite sprite;
    public Vector2 scale = Vector2.ONE;
    public ResizeMode resizeMode = ResizeMode.SMOOTH;
    public boolean flipX;
    public boolean flipY;

    public SpriteRenderer(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        Sprite resized = this.sprite.resized(new Vector2(this.getGameObject().transform.scale).mul(this.scale), this.resizeMode);

        if (flipX) resized.flip(Axis.HORIZONTAL);
        if (!flipY) resized.flip(Axis.VERTICAL);

        Vector2f translatedPos = this.getGameObject().transform.getTranslatedPosition();
        g.drawImage(resized.texture, (int) translatedPos.x, (int) translatedPos.y, null);
    }
}
