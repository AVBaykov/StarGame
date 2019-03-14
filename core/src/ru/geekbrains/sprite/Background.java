package ru.geekbrains.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekbrains.base.Sprite;

public class Background extends Sprite {
    public Background(TextureRegion region) {
        super(region);
        setSize(100f,100f);
    }
}
