package fr.supdevinci.game.map.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tree extends Entity {

    private final static int TX_TILE_HEIGHT = 40;
    private final static int TX_TILE_WIDTH = 50;

    private final static int TREE_HEIGHT = 40;
    private final static int TREE_WIDTH = 50;

    public Tree() {
        Texture tx = new Texture("game-assets/objects/TreeAnimations/TreeSptites.png");
        this.txRegions = TextureRegion.split(tx, TX_TILE_WIDTH, TX_TILE_HEIGHT);
        this.txRegion = txRegions[0][0];
        height = TREE_HEIGHT;
        width = TREE_WIDTH;
    }

    @Override
    public void makeMove() {

    }
}
