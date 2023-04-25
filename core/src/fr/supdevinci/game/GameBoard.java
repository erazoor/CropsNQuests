package fr.supdevinci.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.supdevinci.game.tile.Tiles;

public class GameBoard {

    String[] groundMaps = {
            "1222222222222222222222222222222222222223",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "4000000000000000000000000000000000000005",
            "6777777777777777777777777777777777777778",
    };

    Tiles[][] gameboard = createTilesArray(groundMaps);

    public void update () {

    }

    public void draw (SpriteBatch batch) {
        /*int boardWidth = gameboard.length;
        int boardHeight = gameboard[0].length;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                Tiles currentTile = gameboard[x][y];
                batch.draw(currentTile.getGround(), x * 16, y * 16, 16, 16);
                if (currentTile.getObject() != null){
                    batch.draw(currentTile.getObject(), x * 16, y * 16, 16, 16);
                }
            }
        }*/
        int boardWidth = gameboard.length;
        int boardHeight = gameboard[0].length;
        for (int x = 0; x < boardWidth; x++) {
            for (int y = 0; y < boardHeight; y++) {
                Tiles currentTile = gameboard[x][y];
                System.out.println("x : " + x + " y : " + y + " groundType : " + currentTile.groundType);
                batch.draw(currentTile.getGround(), x * 16, y * 16, 16, 16);
                if (currentTile.getObject() != null){
                    batch.draw(currentTile.getObject(), x * 16, y * 16, 16, 16);
                }
            }
        }
    }

    public Tiles[][] createTilesArray(String[] groundMaps) {
        Tiles[][] tilesArray = new Tiles[groundMaps.length][groundMaps[0].length()];

        for (int i = 0; i < groundMaps.length; i++) {
            for (int j = 0; j < groundMaps[i].length(); j++) {
                int groundType = Character.getNumericValue(groundMaps[i].charAt(j));
                System.out.println("x : " + i + " y : " + j + " groundType : " + groundType);
                tilesArray[i][j] = new Tiles(groundType);
            }
        }

        return tilesArray;
    }
}
