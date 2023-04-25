package fr.supdevinci.game.npc;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Npc {
    private final int TRICKS_PER_FRAME = 10;
    private TextureRegion[] frames;
    private int yFrame, frameCounter  = 0;
    private float x,y = 10;
    private CowMovement curentMovment = CowMovement.TAIL_MOVEMENT_UP;
    public Npc() {
    }

    public void update() {
        frameCounter++;
        if (frameCounter >= TRICKS_PER_FRAME) {
            frameCounter = 0;
            if (yFrame == curentMovment.getTexture().length - 1) {
                yFrame = 0;
                curentMovment = CowMovement.getNextMovement(curentMovment);
            } else {
                yFrame++;
            }
            x+= curentMovment.getXMove();
            y+= curentMovment.getYMove();
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(curentMovment.getTexture()[yFrame], x, y);
    }
}

