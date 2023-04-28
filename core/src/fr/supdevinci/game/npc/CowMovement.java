package fr.supdevinci.game.npc;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum CowMovement {
    TAIL_MOVEMENT_UP(true, 0, 3, 0, 3),
    WALKING(true, 0, 7, 1, 1, 0, 10),
    STAND_UP(false, true,3, 6,2),
    SIT_DOWN(true, false, 0, 3, 2),
    TAIL_MOVEMENT_DOWN(false, 0,2,3, 2),
    SLEEP(false, 0, 3, 3, 2),
    EAT(true, 0, 6,5, 2),
    EAT_GRASS(true, 0, 3,6,2),
    HEART(true,0,5, 7);

    private boolean isStanding,endUpStanding;
    private int minLength, maxLength,posY, importance;
    private float xMove, yMove;
    private TextureRegion[] texture;
    private Texture txCow = new Texture("game-assets/characters/AnimalSpriteSheets/cow/BrownCowAnimations.png");


    CowMovement(boolean isStanding, int minLength, int maxLength, int posY) {
        this(isStanding, isStanding, minLength, maxLength, posY, 0, 0, 1);
    }
    CowMovement(boolean isStanding, int minLength, int maxLength, int posY, int importance) {
        this(isStanding, isStanding, minLength, maxLength, posY, 0, 0, importance);
    }

    CowMovement(boolean isStanding, int minLength, int maxLength, int posY, float xMove, float yMove, int importance) {
        this(isStanding, isStanding, minLength, maxLength, posY, xMove, yMove, importance);
    }

    CowMovement(boolean isStanding, boolean endUpStanding, int minLength, int maxLength, int posY) {
        this(isStanding, endUpStanding, minLength, maxLength, posY, 0, 0, 1);
    }

    CowMovement(boolean isStanding, boolean endUpStanding, int minLength, int maxLength, int posY, float xMove, float yMove, int importance) {
        this.isStanding = isStanding;
        this.endUpStanding = endUpStanding;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.posY = posY;
        this.texture = new TextureRegion[(maxLength - minLength)];
        for (int i = 0; i < maxLength - minLength; i++) {
            this.texture[i] = new TextureRegion(txCow, (i + minLength) * txCow.getWidth() / 8, posY * txCow.getHeight() / 8, txCow.getWidth() / 8, txCow.getHeight() / 8);
        }
        this.xMove = xMove;
        this.yMove = yMove;
        this.importance = importance;
    }

    public float getXMove () {
        return this.xMove;
    }

    public float getYMove () {
        return this.yMove;
    }

    public TextureRegion[] getTexture () {
        return texture;
    }

    public static CowMovement getNextMovement(CowMovement oldMovment) {
        CowMovement[] movements = getMovements(oldMovment.endUpStanding);
        Random random = new Random();
        CowMovement movement = movements[random.nextInt(movements.length)];
        if (movement == CowMovement.WALKING) {
            movement.yMove = randomFloat();
        }
        return movement;
    }

    public static CowMovement[] getMovements(boolean standing) {
        List<CowMovement> movements = new ArrayList<>();
        for (CowMovement movement : CowMovement.values()) {
            if (movement.isStanding == standing) {
                for (int i = 0; i < movement.importance; i++) {
                    movements.add(movement);
                }
            }
        }
        return movements.toArray(new CowMovement[movements.size()]);
    }

    public static float randomFloat() {
        Random random = new Random();
        int num = random.nextInt(21) - 10;
        return (float) num / 10;
    }
}