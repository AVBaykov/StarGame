package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ru.geekbrains.math.Rect;
import ru.geekbrains.math.Rnd;
import ru.geekbrains.pool.EnemyPool;
import ru.geekbrains.sprite.ships.Enemies;
import ru.geekbrains.sprite.ships.Enemy;

public class EnemiesEmitter {

    private static final String[] KINDS = {"SMALL", "AVERAGE", "BIGONE"};
    private static final Random SHIP_GENERATOR = new Random();

    private Enemies kind;

    private Rect worldBounds;

    private float generateInterval = 4f;
    private float generateTimer;


    private List<TextureRegion[]> enemiesRegions = new ArrayList<TextureRegion[]>();

    private TextureRegion bulletRegion;

    private EnemyPool enemyPool;

    private int level;

    public EnemiesEmitter(TextureAtlas atlas, Rect worldBounds, EnemyPool enemyPool) {
        this.worldBounds = worldBounds;
        this.enemyPool = enemyPool;
        TextureRegion textureRegion0 = atlas.findRegion("enemy0");
        TextureRegion textureRegion1 = atlas.findRegion("enemy1");
        TextureRegion textureRegion2 = atlas.findRegion("enemy2");
        enemiesRegions.add(Regions.split(textureRegion0, 1, 2, 2));
        enemiesRegions.add(Regions.split(textureRegion1, 1, 2, 2));
        enemiesRegions.add(Regions.split(textureRegion2, 1, 2, 2));
        this.bulletRegion = atlas.findRegion("bulletEnemy");
    }

    public void generate(float delta, int frags) {
        level = frags / 10 + 1;
        generateTimer += delta;
        if (generateTimer >= generateInterval) {
            generateTimer = 0f;
            Enemy enemy = enemyPool.obtain();
            kind = Enemies.valueOf(KINDS[SHIP_GENERATOR.nextInt(3)]);
            enemy.set(
                    enemiesRegions.get(kind.ordinal()),
                    kind.getENEMY_V(),
                    bulletRegion,
                    kind.getENEMY_BULLET_HEIGHT(),
                    kind.getENEMY_BULLET_VY(),
                    kind.getENEMY_DAMAGE(),
                    kind.getENEMY_RELOAD_INTERVAL(),
                    kind.getENEMY_HEIGHT(),
                    kind.getENEMY_HP()
            );
            enemy.pos.x = Rnd.nextFloat(worldBounds.getLeft() + enemy.getHalfWidth(), worldBounds.getRight() - enemy.getHalfWidth());
            enemy.setBottom(worldBounds.getTop());
        }
    }

    public int getLevel() {
        return level;
    }
}
