package ru.geekbrains.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Base2DScreen;

public class MenuScreen extends Base2DScreen {
    private SpriteBatch batch;
    private Texture img;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 position;
    private static int counter;

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        touch = new Vector2();
        position = new Vector2(0, 0);
        v = new Vector2(0.2f, 0.5f);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, position.x, position.y);
        batch.end();
        while (counter > 0) {
            position.add(v);
            counter--;
            System.out.println(counter);
        }
    }

    private void move(Vector2 position, Vector2 touch) {
        Vector2 endPoint = touch.sub(position);
        counter = (int) endPoint.len();
        this.position = endPoint.nor();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        move(position, touch);
        System.out.println("touch x =" + touch.x + " touch y = " + touch.y);
        return super.touchDown(screenX, screenY, pointer, button);
    }
}
