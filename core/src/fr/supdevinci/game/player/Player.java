package fr.supdevinci.game.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static fr.supdevinci.game.player.PlayerAnimation.Action.*;

public class Player {
    private static final int TILE_WIDTH = 16;
    private static final int TILE_HEIGHT = 16;

    private int tileX = Gdx.graphics.getWidth() / 2 / TILE_WIDTH;
    private int tileY = Gdx.graphics.getHeight() / 2 / TILE_HEIGHT;


    private float x;
    private float y;
    private float width;
    private float height;
    private PlayerAnimation playerAnimation;

    public Player(TextureRegion spritesheet) {
        playerAnimation = new PlayerAnimation(spritesheet);
    }

    public void render(SpriteBatch batch) {
        batch.draw(getCurrentFrame(), x, y, width, height);
    }

    private TextureRegion getCurrentFrame() {
        switch (playerAnimation.getAction()) {
            case IDLE:
                return playerAnimation.getIdleRegion();
            case WALK:
                return playerAnimation.getWalkRegion();
            case RUN:
                return playerAnimation.getRunRegion();
            case ATTACK:
                return playerAnimation.getAttackRegion();
            case WATER:
                return playerAnimation.getWaterRegion();
            case CHOP:
                return playerAnimation.getChopRegion();
        }
        return null;
    }

    public void update(float delta) {
        playerAnimation.update(delta);
    }

    public void setDirection(PlayerAnimation.Direction direction) {
        playerAnimation.setDirection(direction);
    }

    public void setAction(PlayerAnimation.Action action) {
        playerAnimation.setAction(action);
    }

    public void setPosition(float x, float y) {
        this.tileX = (int) Math.floor(x / TILE_WIDTH);
        this.tileY = (int) Math.floor(y / TILE_HEIGHT);
        this.x = tileX * TILE_WIDTH;
        this.y = tileY * TILE_HEIGHT;
    }

    public void moveUp() {
        tileY++;
        y = tileY * TILE_HEIGHT;
        setAction(WALK);
        setDirection(PlayerAnimation.Direction.UP);
    }

    public void moveRight() {
        tileX++;
        x = tileX * TILE_HEIGHT;
        setAction(WALK);
        setDirection(PlayerAnimation.Direction.RIGHT);
    }

    public void moveDown() {
        tileY--;
        y = tileY * TILE_HEIGHT;
        setAction(WALK);
        setDirection(PlayerAnimation.Direction.DOWN);
    }

    public void moveLeft() {
        tileX--;
        x = tileX * TILE_HEIGHT;
        setAction(WALK);
        setDirection(PlayerAnimation.Direction.LEFT);
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void dispose() {
        // Dispose of resources when no longer needed
    }
}
