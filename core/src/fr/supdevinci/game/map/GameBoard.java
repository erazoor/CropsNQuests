package fr.supdevinci.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.supdevinci.game.map.entity.Entity;
import fr.supdevinci.game.map.entity.ObjectFactory;
import fr.supdevinci.game.map.entity.Ground;

public class GameBoard {
    ObjectFactory entityFactory;

    Tile[][] gameboard;

    private Ground ground;

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
            "TTTTTTTTT                               ",
            "TTTTTTTTTT                              ",
            "TTTTTT                                  ",
            "TTTTTTTTT                               ",
            "TTTTTTTTT                               ",
            "TTTTTTT          B                      ",
            "TTTTTT                                  ",
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
            "         B                              ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                        ",
            "                                   B    ",
            "                                        ",
            "                                        ",
    };

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
                object = entityFactory.getEntity(objectMaps[i].charAt(j));
                tilesArray[j][Math.abs(i-groundMaps.length+1)] = new Tile(ground,object, groundMaps[i].charAt(j));
            }
        }
        return tilesArray;
    }

    public boolean isWater(int x, int y) {
        try {
            return gameboard[x][y].getTileType() == '0';
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
