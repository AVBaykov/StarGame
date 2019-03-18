package ru.geekbrains.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.sprite.ButtonExit;
import ru.geekbrains.sprite.ButtonPlay;

public class MenuScreen extends StarScreen {

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void atlasInit() {
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
    }

    @Override
    public void screenItemsInit() {
        buttonExit = new ButtonExit(atlas);
        buttonPlay = new ButtonPlay(atlas, game);
    }

    @Override
    public void screenItemsDraw() {
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
    }

    @Override
    protected void screenItemsResize() {
        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonExit.touchDown(touch, pointer);
        buttonPlay.touchDown(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonExit.touchUp(touch, pointer);
        buttonPlay.touchUp(touch, pointer);
        return false;
    }
}
