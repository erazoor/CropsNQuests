package fr.supdevinci.game.npc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public abstract class Movement {

    private boolean isStanding;
    private boolean endUpStanding;
    private int minLength;
    private int maxLength;
    private int posY;
    private int importance;
    private float xMove;
    private float yMove;
    private TextureRegion[] texture;
    private Texture tx = new Texture("game-assets/characters/Animal_SpriteSheets/cow/Brown_cow_animations.png");

    public Movement(boolean isStanding, int minLength, int maxLength, int posY) {
        this(isStanding, isStanding, minLength, maxLength, posY, 0, 0, 1);
    }

    public Movement(boolean isStanding, int minLength, int maxLength, int posY, int importance) {
        this(isStanding, isStanding, minLength, maxLength, posY, 0, 0, importance);
    }

    public Movement(boolean isStanding, int minLength, int maxLength, int posY, float xMove, float yMove, int importance) {
        this(isStanding, isStanding, minLength, maxLength, posY, xMove, yMove, importance);
    }

    public Movement(boolean isStanding, boolean endUpStanding, int minLength, int maxLength, int posY) {
        this(isStanding, endUpStanding, minLength, maxLength, posY, 0, 0, 1);
    }

    public Movement(boolean isStanding, boolean endUpStanding, int minLength, int maxLength, int posY, float xMove, float yMove, int importance) {
        this.isStanding = isStanding;
        this.endUpStanding = endUpStanding;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.posY = posY;
        this.texture = new TextureRegion[(maxLength - minLength)];
        for (int i = 0; i < maxLength - minLength; i++) {
            this.texture[i] = new TextureRegion(tx, (i + minLength) * tx.getWidth() / 8, posY * tx.getHeight() / 8, tx.getWidth() / 8, tx.getHeight() / 8);
        }
        this.xMove = xMove;
        this.yMove = yMove;
        this.importance = importance;
    }

    public float getXMove() {
        return this.xMove;
    }

    public float getYMove() {
        return this.yMove;
    }

    public TextureRegion[] getTexture() {
        return texture;
    }

    public abstract Movement getNextMovement(Movement oldMovement);

    public abstract Movement[] getMovements(boolean standing);

    public static float randomFloat() {
        Random random = new Random();
        int num = random.nextInt(21) - 10;
        return (float) num / 10;
    }
}
