package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Tree extends ObjectV2 {

    private final static int TX_TILE_HEIGHT = 40;
    private final static int TX_TILE_WIDTH = 50;

    public Tree() {
        this.tx = new Texture("game-assets/objects/TreeAnimations/TreeSptites.png");
        this.txRegions = TextureRegion.split(this.tx, TX_TILE_WIDTH, TX_TILE_HEIGHT);
        posByType.put('1', new Vector2(0, 0));
    }

    @Override
    public void makeMove() {

    }
}
