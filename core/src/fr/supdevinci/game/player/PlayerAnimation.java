package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimation {
    private static final int ROWS = 24;
    private static final int COLUMNS = 8;
    private static final float FRAME_DURATION = 0.1f;

    private final TextureRegion[][] frames;
    private float stateTime;
    private int currentFrame;
    private Direction direction;
    private Action action;
    private TextureRegion idleRegion;
    private TextureRegion walkRegion;
    private TextureRegion runRegion;
    private TextureRegion attackRegion;
    private TextureRegion waterRegion;
    private TextureRegion chopRegion;

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public enum Action {
        IDLE, WALK, RUN, ATTACK, WATER, CHOP
    }

    public PlayerAnimation(TextureRegion spritesheet) {
        // Defining the frames of the animation 24 rows for 8 columns
        int frameWidth = spritesheet.getRegionWidth() / COLUMNS;
        int frameHeight = spritesheet.getRegionHeight() / ROWS;
        frames = spritesheet.split(frameWidth, frameHeight);

        stateTime = 0f;
        currentFrame = 0;
        direction = Direction.DOWN;
        action = Action.IDLE;
        updateRegions();
    }

    public void update(float delta) {
        stateTime += delta;
        currentFrame = (int) (stateTime / FRAME_DURATION) % frames[0].length;
        updateRegions();
    }

    private void updateRegions() {
        switch (action) {
            case IDLE:
                idleRegion = getTextureRegion(direction, 0);
                break;
            case WALK:
                walkRegion = getTextureRegion(direction, 4);
                break;
            case RUN:
                runRegion = getTextureRegion(direction, 8);
                break;
            case ATTACK:
                attackRegion = getTextureRegion(direction, 12);
                break;
            case CHOP:
                chopRegion = getTextureRegion(direction, 16);
                break;
            case WATER:
                waterRegion = getTextureRegion(direction, 20);
                break;
        }
    }

    private TextureRegion getTextureRegion(Direction dir, int row) {
        switch (dir) {
            case LEFT:
                return frames[row + 2][currentFrame];
            case DOWN:
                return frames[row][currentFrame];
            case UP:
                return frames[row + 1][currentFrame];
            case RIGHT:
                return frames[row + 3][currentFrame];
            default:
                return null;
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
        updateRegions();
    }

    public void setAction(Action action) {
        this.action = action;
        updateRegions();
    }

    public TextureRegion getIdleRegion() {
        return idleRegion;
    }

    public TextureRegion getWalkRegion() {
        return walkRegion;
    }

    public TextureRegion getRunRegion() {
        return runRegion;
    }

    public TextureRegion getAttackRegion() {
        return attackRegion;
    }

    public TextureRegion getWaterRegion() {
        return waterRegion;
    }

    public TextureRegion getChopRegion() {
        return chopRegion;
    }

    public Action getAction() {
        return action;
    }
}
