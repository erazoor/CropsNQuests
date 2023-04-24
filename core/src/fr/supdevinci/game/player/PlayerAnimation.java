package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerAnimation {
    private TextureRegion[][] frames;
    private float stateTime;
    private int currentFrame;
    private int animationRow;

    public PlayerAnimation(TextureRegion spritesheet) {
        // Defining the frames of the animation 24 rows for 8 columns
        int frameWidth = spritesheet.getRegionWidth() / 8;
        int frameHeight = spritesheet.getRegionHeight() / 24;
        frames = spritesheet.split(frameWidth, frameHeight);

        stateTime = 0f;
        currentFrame = 0;
        animationRow = 0;
    }

    public void update(float delta) {
        stateTime += delta;
        currentFrame = (int) (stateTime / 0.1f) % frames[animationRow].length;
    }

    public void setAnimationRow(int row) {
        animationRow = row;
        stateTime = 0f;
        currentFrame = 0;
    }

    public TextureRegion getCurrentFrame() {
        return frames[animationRow][currentFrame];
    }
}
