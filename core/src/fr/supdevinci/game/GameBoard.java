package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class GameBoard {

    private final static int GROUND_TILE_WIDTH = 16;
    private final static int GROUND_TILE_HEIGHT = 16;
    private final static int OBJECT_TILE_HEIGHT = 50;
    private final static int OBJECT_TILE_WIDTH = 40;
    private Texture txGround;
    //private Texture txObject;
    private TextureRegion[][] txGrounds;

    EntityFactory entityFactory;

    //private Entity entity;

    //private TextureRegion[][] txObjects;
    String[] groundMaps = {
            "                                50004   ",
            "                                u3004   ",
            "                                 u304   ",
            "                                  504   ",
            "           /777777777777777|      504   ",
            "           50000000000000004   /77804   ",
            "           50122222222222304   500004   ",
            "           504           504   50122U   ",
            "           504           504   504      ",
            "           504           506777804      ",
            "           u2U           500000004      ",
            "                         50122222U      ",
            "                         504            ",
            "           /7|           504            ",
            "           504           u2U            ",
            "           504                          ",
            "           504                          ",
            "           504                          ",
            "           504                          ",
            "      /7777804            0000000       ",
            "      50000004                          ",
            "      5012222U                          ",
            "      504                               ",
            "    /7804                               ",
            "  /780004                               ",
            "  500012U                               ",
            "7780004                                 ",
            "000001U                                 ",
            "000004                                  ",
            "000004                                  ",
    };

    String[] objectMaps = {
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                   11                   ",
            "                                        ",
            "                  1111111111            ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "               bb                       ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
    };

    Tile[][] gameboard;
    private static final HashMap<Character, Vector2> groundPosByType = new HashMap<>();

    static {
        groundPosByType.put(' ', new Vector2(1, 1));
        groundPosByType.put('0', new Vector2(6,10));
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

    private static final HashMap<Character, Character> objectPosByType = new HashMap<>();

    static {
        objectPosByType.put('1', 'A');
        objectPosByType.put('b', 'B');
    }

    public void create() {
        txGround = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
        //txObject = new Texture("game-assets/objects/TreeAnimations/TreeSptites.png");
        txGrounds = TextureRegion.split(txGround, GROUND_TILE_WIDTH, GROUND_TILE_HEIGHT);
        //txObjects = TextureRegion.split(txObject, OBJECT_TILE_WIDTH, OBJECT_TILE_HEIGHT);

        entityFactory = new EntityFactory();

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

    public Tile[][] createTilesArray(){
        Tile[][] tilesArray = new Tile[groundMaps[0].length()][groundMaps.length];

        for (int i = 0; i < groundMaps.length; i++) {
            for (int j = 0; j < groundMaps[i].length(); j++) {
                Vector2 positionGroundTexture = groundPosByType.get(groundMaps[i].charAt(j));
                TextureRegion groundTexture = txGrounds[(int) positionGroundTexture.x][(int) positionGroundTexture.y];

                //Vector2 positionObjectTexture = objectPosByType.get(objectMaps[i].charAt(j));
                //TextureRegion objectTexture;
                //if (positionObjectTexture == null){
                //    objectTexture= null;
                //}else {
                //    objectTexture = txObjects[(int) positionObjectTexture.x][(int) positionObjectTexture.y];
                //}
                //;

                TextureRegion objectTexture;
                if (objectPosByType.get(objectMaps[i].charAt(j)) != null){
                    Entity entity = entityFactory.getEntity(objectPosByType.get(objectMaps[i].charAt(j)));
                    objectTexture = entity.getTexture(objectMaps[i].charAt(j));
                }else {
                    objectTexture = null;
                }
                tilesArray[j][Math.abs(i-groundMaps.length+1)] = new Tile(groundTexture,objectTexture);
            }
        }

        return tilesArray;
    }
}
