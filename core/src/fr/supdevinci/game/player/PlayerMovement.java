package fr.supdevinci.game.player;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class PlayerMovement {
    private final PlayerAnimation[] animations;

    public PlayerMovement(TextureRegion spritesheet) {
        animations = new PlayerAnimation[]{
                new PlayerAnimation(spritesheet), // idle down
                new PlayerAnimation(spritesheet), // idle up
                new PlayerAnimation(spritesheet), // idle left
                new PlayerAnimation(spritesheet), // idle right
                new PlayerAnimation(spritesheet), // walk down
                new PlayerAnimation(spritesheet), // walk up
                new PlayerAnimation(spritesheet), // walk right
                new PlayerAnimation(spritesheet), // walk left
                new PlayerAnimation(spritesheet), // run down
                new PlayerAnimation(spritesheet), // run up
                new PlayerAnimation(spritesheet), // run right
                new PlayerAnimation(spritesheet), // run left
                new PlayerAnimation(spritesheet), // attack down
                new PlayerAnimation(spritesheet), // attack up
                new PlayerAnimation(spritesheet), // attack left
                new PlayerAnimation(spritesheet), // attack right
                new PlayerAnimation(spritesheet), // chop down
                new PlayerAnimation(spritesheet), // chop up
                new PlayerAnimation(spritesheet), // chop left
                new PlayerAnimation(spritesheet), // chop right
                new PlayerAnimation(spritesheet), // water down
                new PlayerAnimation(spritesheet), // water up
                new PlayerAnimation(spritesheet), // water left
                new PlayerAnimation(spritesheet), // water right
        };

        // Set the animation rows for each animation
        animations[0].setAnimationRow(0);  // idle down
        animations[1].setAnimationRow(1);  // idle up
        animations[2].setAnimationRow(2);  // idle left
        animations[3].setAnimationRow(3);  // idle right
        animations[4].setAnimationRow(4);  // walk down
        animations[5].setAnimationRow(5);  // walk up
        animations[6].setAnimationRow(6);  // walk right
        animations[7].setAnimationRow(7);  // walk left
        animations[8].setAnimationRow(8);  // run down
        animations[9].setAnimationRow(9);  // run up
        animations[10].setAnimationRow(10); // run right
        animations[11].setAnimationRow(11); // run left
        animations[12].setAnimationRow(12); // attack down
        animations[13].setAnimationRow(13); // attack up
        animations[14].setAnimationRow(14); // attack left
        animations[15].setAnimationRow(15); // attack right
        animations[16].setAnimationRow(16); // chop down
        animations[17].setAnimationRow(17); // chop up
        animations[18].setAnimationRow(18); // chop left
        animations[19].setAnimationRow(19); // chop right
        animations[20].setAnimationRow(20); // water down
        animations[21].setAnimationRow(21); // water up
        animations[22].setAnimationRow(22); // water left
        animations[23].setAnimationRow(23); // water right
    }

    
}