package fr.supdevinci.game.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tiles {
    private Texture txGround = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
    private Texture txObject = new Texture("game-assets/tilesets/GroundTiles/NewTiles/DarkerGrassHillTiles.png");
    private TextureRegion ground;
    private TextureRegion object;
    public int groundType;

    public Tiles (int groundType, int objectType) {
        this.ground =  setGround(groundType);
        this.object = setObject(objectType);
    }

    public Tiles (int groundType) {
        this.ground =  setGround(groundType);
        this.groundType = groundType;
    }
    public TextureRegion setGround(int type){
        TextureRegion tx;
        switch (type) {
            case 1:
                tx = createTextureGround(0,0);
                break;
            case 2:
                tx = createTextureGround(0,1);
                break;
            case 3:
                tx = createTextureGround(0,2);
                break;
            case 4:
                tx = createTextureGround(1,0);
                break;
            case 5:
                tx = createTextureGround(1,2);
                break;
            case 6:
                tx = createTextureGround(2,0);
                break;
            case 7:
                tx = createTextureGround(2,1);
                break;
            case 8:
                tx = createTextureGround(2,2);
                break;
            default:
                tx = createTextureGround(1,1);
                break;
        }
        return tx;
    }

    public TextureRegion setObject(int type){
        TextureRegion tx;
        switch (type) {
            case 1:
                tx = createTextureObject(3,3);
                break;
            case 2:
                tx = createTextureObject(3,3);
                break;
            default:
                tx = createTextureObject(5,3);
                break;
        }
        return tx;
    }

    private TextureRegion createTextureGround(int x, int y){
        float width = txObject.getWidth();
        float height = txObject.getHeight();
        return new TextureRegion(txGround, x * width / 11, y * height / 7, width / 11, height / 7);
    }

    private TextureRegion createTextureObject(int x, int y){
        float width = txObject.getWidth();
        float height = txObject.getHeight();
        return new TextureRegion(txObject, x * width / 11, y * height / 7, width / 11, height / 7);
    }

    public TextureRegion getGround (){
        return this.ground;
    }

    public TextureRegion getObject (){
        return this.object;
    }
}
