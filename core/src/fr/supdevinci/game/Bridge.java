package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;
public class Bridge extends ObjectV2 {
    private final static int TX_TILE_HEIGHT = 48;
    private final static int TX_TILE_WIDTH = 15;


    public Bridge() {
        tx = new Texture("game-assets/tilesets/BuildingParts/WoodBridgeV2.png");
        txRegions = TextureRegion.split(tx, TX_TILE_WIDTH, TX_TILE_HEIGHT);
        posByType.put('b', new Vector2(0, 0));
    }

    @Override
    public void makeMove() {

    }
}
