package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;

public class MainShip extends Sprite {

    private static float V_LEN = 0.06f;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;

    public MainShip(TextureAtlas atlas) {
        super(atlas.findRegion("main_ship"));
        setSize(0.2f, 0.2f);
        touch = new Vector2();
        v = new Vector2();
        buf = new Vector2();
    }

    public void update() {
        buf.set(touch);
        if (buf.sub(pos).len() <= V_LEN) {
            pos.set(touch);
        } else {
            pos.add(v);
        }
    }

    public boolean touchDown(Vector2 touch, int pointer) {
        this.touch = touch;
        v = touch.cpy().sub(pos).setLength(V_LEN);
        return false;
    }
}
