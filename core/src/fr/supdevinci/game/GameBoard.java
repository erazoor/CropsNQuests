package fr.supdevinci.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.supdevinci.game.Entity.Entity;
import fr.supdevinci.game.Entity.ObjectFactory;
import fr.supdevinci.game.Entity.Ground;

import java.util.HashMap;

public class GameBoard {
    ObjectFactory entityFactory;

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
            "111111111                               ",
            "11111                                   ",
            "111111                                  ",
            "111111111                               ",
            "111111111                               ",
            "11111111                                ",
            "111111111       b                       ",
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
            "                                        ",
            "                                        ",
            "         b                              ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                 b      ",
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

    private Ground ground;
    public void create() {
        entityFactory = new ObjectFactory();
        ground = new Ground();
        gameboard = createTilesArray();
    }

    public void draw (SpriteBatch batch) {
        int boardWidth = gameboard.length;
        int boardHeight = gameboard[0].length;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                gameboard[x][y].drawGround(batch, x, y);
            }
        }
        for (int x = boardWidth -1; x >= 0; x--) {
            for (int y = boardHeight -1; y >= 0; y--) {
                gameboard[x][y].drawObject(batch, x, y);
            }
        }
    }

    public Tile[][] createTilesArray(){
        Tile[][] tilesArray = new Tile[groundMaps[0].length()][groundMaps.length];

        for (int i = 0; i < groundMaps.length; i++) {
            for (int j = 0; j < groundMaps[i].length(); j++) {
                Entity object;
                if (objectPosByType.get(objectMaps[i].charAt(j)) != null){
                    object = entityFactory.getEntity(objectPosByType.get(objectMaps[i].charAt(j)));
                }else {
                    object = null;
                }
                tilesArray[j][Math.abs(i-groundMaps.length+1)] = new Tile(ground,object, groundMaps[i].charAt(j));
            }
        }

        return tilesArray;
    }
}
