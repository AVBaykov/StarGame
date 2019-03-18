package ru.geekbrains.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprite.MainShip;

public class GameScreen extends StarScreen {

    private MainShip mainShip;

    public GameScreen(Game game) {
        super(game);
    }

    @Override
    protected void screenItemsResize() {
        mainShip.resize(worldBounds);
    }

    @Override
    public void atlasInit() {
        atlas = new TextureAtlas("textures/mainAtlas.tpack");
    }

    @Override
    public void screenItemsInit() {
        mainShip = new MainShip(atlas);
    }

    @Override
    public void screenItemsDraw() {
        mainShip.draw(batch);
        mainShip.update();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        mainShip.touchDown(touch, pointer);
        return false;
    }
}
