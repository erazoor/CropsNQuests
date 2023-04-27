package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class Bridge implements Entity{
    private final static int TX_TILE_HEIGHT = 30;
    private final static int TX_TILE_WIDTH = 15;

    private Texture tx;

    private TextureRegion[][] txRegions;

    private static final HashMap<Character, Vector2> objectPosByType = new HashMap<>();

    @Override
    public void create() {
        tx = new Texture("game-assets/tilesets/BuildingParts/WoodBridgeV2.png");
        txRegions = TextureRegion.split(tx, TX_TILE_WIDTH, TX_TILE_HEIGHT);
        objectPosByType.put('b', new Vector2(0, 0));
    }

    @Override
    public void makeMove() {

    }

    @Override
    public TextureRegion getTexture(char c) {
        return getTextureByPosition(objectPosByType.get(c));
    }

    private TextureRegion getTextureByPosition(Vector2 position) {
        TextureRegion objectTexture;
        if (position == null){
            objectTexture= null;
        }else {
            objectTexture = txRegions[(int) position.x][(int) position.y];
        }
        return objectTexture;
    }

}
