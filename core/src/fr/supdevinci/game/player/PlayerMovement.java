package fr.supdevinci.game.player;

import com.badlogic.gdx.Gdx;

import static fr.supdevinci.game.player.PlayerAnimation.Action.*;

public class PlayerMovement {
    private static final int TILE_WIDTH = 16;
    private static final int TILE_HEIGHT = 16;

    private int tileX;
    private int tileY;
    private float x;
    private float y;
    private PlayerAnimation playerAnimation;

    public PlayerMovement(PlayerAnimation playerAnimation) {
        this.playerAnimation = playerAnimation;
        this.tileX = Gdx.graphics.getWidth() / 2 / TILE_WIDTH;
        this.tileY = Gdx.graphics.getHeight() / 2 / TILE_HEIGHT;
        this.x = tileX * TILE_WIDTH;
        this.y = tileY * TILE_HEIGHT;
    }

    public void moveUp() {
        tileY++;
        y = tileY * TILE_HEIGHT;
        playerAnimation.setAction(WALK);
        playerAnimation.setDirection(PlayerAnimation.Direction.UP);
    }

    public void moveRight() {
        tileX++;
        x = tileX * TILE_HEIGHT;
        playerAnimation.setAction(WALK);
        playerAnimation.setDirection(PlayerAnimation.Direction.RIGHT);
    }

    public void moveDown() {
        tileY--;
        y = tileY * TILE_HEIGHT;
        playerAnimation.setAction(WALK);
        playerAnimation.setDirection(PlayerAnimation.Direction.DOWN);
    }

    public void moveLeft() {
        tileX--;
        x = tileX * TILE_HEIGHT;
        playerAnimation.setAction(WALK);
        playerAnimation.setDirection(PlayerAnimation.Direction.LEFT);
    }

    public void setPosition(float x, float y) {
        this.tileX = (int) Math.floor(x / TILE_WIDTH);
        this.tileY = (int) Math.floor(y / TILE_HEIGHT);
        this.x = tileX * TILE_WIDTH;
        this.y = tileY * TILE_HEIGHT;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}

