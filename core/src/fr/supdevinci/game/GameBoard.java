package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import fr.supdevinci.game.tile.Tile;

import java.util.HashMap;

public class GameBoard {

    private final static int GROUND_TILE_WIDTH = 16;
    private final static int GROUND_TILE_HEIGHT = 16;
    private Texture txGround;
    private Texture txObject;
    private TextureRegion[][] textures;

    String[] groundMaps = {
            "1222222222222222222222222222222222222223",
            "4                                      5",
            "4  RRRRRRRRRRRRRRRRRRRRRRRR            5",
            "4                                      5",
            "4                                      5",
            "4                                      5",
            "4                                      5",
            "4                                      5",
            "4                                      5",
            "4                       RRRR           5",
            "4                        rrrr          5",
            "4            /|             fff        5",
            "4            54                        5",
            "4            54                        5",
            "4            54                        5",
            "4            54                        5",
            "4            54        F               5",
            "4       g    uU                        5",
            "4                                      5",
            "4                      F               5",
            "4        g                             5",
            "4                                      5",
            "4          g                           5",
            "4                                      5",
            "4                                      5",
            "4                  G                   5",
            "4      g                               5",
            "4                                      5",
            "4                                      5",
            "6777777777777777777777777777777777777778",
    };

    Tile[][] gameboard;
    private static final HashMap<Character, Vector2> groundPosByType = new HashMap<>();

    static {
        groundPosByType.put(' ', new Vector2(1, 1));
        groundPosByType.put('1', new Vector2(0, 0));
        groundPosByType.put('2', new Vector2(0, 1));
        groundPosByType.put('3', new Vector2(0, 2));
        groundPosByType.put('4', new Vector2(1, 0));
        groundPosByType.put('5', new Vector2(1, 2));
        groundPosByType.put('6', new Vector2(2, 0));
        groundPosByType.put('7', new Vector2(2, 1));
        groundPosByType.put('8', new Vector2(2, 2));
        groundPosByType.put('F', new Vector2(5, 5));
        groundPosByType.put('f', new Vector2(6, 5));
        groundPosByType.put('R', new Vector2(5, 3));
        groundPosByType.put('r', new Vector2(6, 3));
        groundPosByType.put('G', new Vector2(5, 0));
        groundPosByType.put('g', new Vector2(6, 0));
        groundPosByType.put('/', new Vector2(1, 5));
        groundPosByType.put('|', new Vector2(1, 6));
        groundPosByType.put('u', new Vector2(2, 5));
        groundPosByType.put('U', new Vector2(2, 6));
    }


    public void create() {
        txGround = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
        txObject = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
        textures = TextureRegion.split(txGround, GROUND_TILE_WIDTH, GROUND_TILE_HEIGHT);
        gameboard = createTilesArray();
    }

    public void update () {

    }

    public void draw (SpriteBatch batch) {
        int boardWidth = gameboard.length;
        int boardHeight = gameboard[0].length;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                gameboard[x][y].draw(batch, x, y);
            }
        }
    }

    public Tile[][] createTilesArray() {
        Tile[][] tilesArray = new Tile[groundMaps[0].length()][groundMaps.length];

        for (int i = 0; i < groundMaps.length; i++) {
            for (int j = 0; j < groundMaps[i].length(); j++) {
                //System.out.println("x : " + Math.abs(i-groundMaps.length+1) + " y : " + Math.abs(j-groundMaps[0].length()+1) + " groundType : " + groundType);
                tilesArray[j][Math.abs(i-groundMaps.length+1)] = new Tile(groundPosByType, textures, groundMaps[i].charAt(j));
            }
        }

        return tilesArray;
    }
}
