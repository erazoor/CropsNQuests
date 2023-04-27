package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Ground extends ObjectV2 {

    private final static int GROUND_TILE_WIDTH = 16;
    private final static int GROUND_TILE_HEIGHT = 16;
    private TextureRegion[][] texture;

    public Ground(){
        tx = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
        txRegions = TextureRegion.split(tx, GROUND_TILE_WIDTH, GROUND_TILE_HEIGHT);
        posByType.put(' ', new Vector2(1, 1));
        posByType.put('0', new Vector2(6,10));
        posByType.put('1', new Vector2(0, 0));
        posByType.put('2', new Vector2(0, 1));
        posByType.put('3', new Vector2(0, 2));
        posByType.put('4', new Vector2(1, 0));
        posByType.put('5', new Vector2(1, 2));
        posByType.put('6', new Vector2(2, 0));
        posByType.put('7', new Vector2(2, 1));
        posByType.put('8', new Vector2(2, 2));
        posByType.put('F', new Vector2(5, 5));
        posByType.put('f', new Vector2(6, 5));
        posByType.put('R', new Vector2(5, 3));
        posByType.put('r', new Vector2(6, 3));
        posByType.put('G', new Vector2(5, 0));
        posByType.put('g', new Vector2(6, 0));
        posByType.put('/', new Vector2(1, 5));
        posByType.put('|', new Vector2(1, 6));
        posByType.put('u', new Vector2(2, 5));
        posByType.put('U', new Vector2(2, 6));
    }

    @Override
    public void makeMove() {

    }

}
