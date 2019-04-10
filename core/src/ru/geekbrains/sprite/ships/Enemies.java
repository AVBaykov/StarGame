package ru.geekbrains.sprite.ships;

import com.badlogic.gdx.math.Vector2;

public enum Enemies {
    SMALL(0.1f, 0.01f, -0.3f, 1, 3f, 1, new Vector2(0f, -0.2f)),
    AVERAGE(0.1f, 0.02f, -0.25f, 5, 4f, 5, new Vector2(0f, -0.03f)),
    BIGONE(0.2f, 0.04f, -0.25f, 10, 1f, 10, new Vector2(0f, -0.005f));

    private final float ENEMY_HEIGHT;
    private final float ENEMY_BULLET_HEIGHT;
    private final float ENEMY_BULLET_VY;
    private final int ENEMY_DAMAGE;
    private final float ENEMY_RELOAD_INTERVAL;
    private final int ENEMY_HP;

    private final Vector2 ENEMY_V;

    Enemies(float ENEMY_HEIGHT, float ENEMY_BULLET_HEIGHT, float ENEMY_BULLET_VY, int ENEMY_DAMAGE, float ENEMY_RELOAD_INTERVAL, int ENEMY_HP, Vector2 ENEMY_V) {
        this.ENEMY_HEIGHT = ENEMY_HEIGHT;
        this.ENEMY_BULLET_HEIGHT = ENEMY_BULLET_HEIGHT;
        this.ENEMY_BULLET_VY = ENEMY_BULLET_VY;
        this.ENEMY_DAMAGE = ENEMY_DAMAGE;
        this.ENEMY_RELOAD_INTERVAL = ENEMY_RELOAD_INTERVAL;
        this.ENEMY_HP = ENEMY_HP;
        this.ENEMY_V = ENEMY_V;
    }

    public float getENEMY_HEIGHT() {
        return ENEMY_HEIGHT;
    }

    public float getENEMY_BULLET_HEIGHT() {
        return ENEMY_BULLET_HEIGHT;
    }

    public float getENEMY_BULLET_VY() {
        return ENEMY_BULLET_VY;
    }

    public int getENEMY_DAMAGE() {
        return ENEMY_DAMAGE;
    }

    public float getENEMY_RELOAD_INTERVAL() {
        return ENEMY_RELOAD_INTERVAL;
    }

    public int getENEMY_HP() {
        return ENEMY_HP;
    }

    public Vector2 getENEMY_V() {
        return ENEMY_V;
    }
}
