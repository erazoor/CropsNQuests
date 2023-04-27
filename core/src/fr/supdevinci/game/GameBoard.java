package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.util.HashMap;

public class GameBoard {
    EntityFactory entityFactory;

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
            "      /7777804      /7|                 ",
            "      50000004      504                 ",
            "      5012222U      504                 ",
            "      504           506777|             ",
            "    /7804           5000004             ",
            "  /780004           u222304             ",
            "  500012U               50677777|       ",
            "7780004                 5000000067777777",
            "000001U                 u222223000000000",
            "000004                        u222222222",
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
            "                b                       ",
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
            "               b                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
    };

    Tile[][] gameboard;

    private static final HashMap<Character, Character> objectPosByType = new HashMap<>();

    static {
        objectPosByType.put('1', 'A');
        objectPosByType.put('b', 'B');
    }

    private ObjectV2 ground;
    public void create() {
        entityFactory = new EntityFactory();
        ground = new Ground();
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
                TextureRegion groundTexture = ground.getTexture(groundMaps[i].charAt(j));

                TextureRegion objectTexture;
                if (objectPosByType.get(objectMaps[i].charAt(j)) != null){
                    ObjectV2 entity = entityFactory.getEntity(objectPosByType.get(objectMaps[i].charAt(j)));
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
