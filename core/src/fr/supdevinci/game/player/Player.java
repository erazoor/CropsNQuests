package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    private float width;
    private float height;
    private PlayerAnimation playerAnimation;
    private PlayerMovement playerMovement;

    public Player(TextureRegion spritesheet) {
        playerAnimation = new PlayerAnimation(spritesheet);
        playerMovement = new PlayerMovement(playerAnimation);
    }

    public void render(SpriteBatch batch) {
        batch.draw(getCurrentFrame(), playerMovement.getX(), playerMovement.getY(), width, height);
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
        playerMovement.setPosition(x, y);
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public void moveUp() {
        playerMovement.moveUp();
    }

    public void moveRight() {
        playerMovement.moveRight();
    }

    public void moveDown() {
        playerMovement.moveDown();
    }

    public void moveLeft() {
        playerMovement.moveLeft();
    }

    public void dispose() {

    }
}