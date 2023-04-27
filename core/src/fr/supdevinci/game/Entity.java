package fr.supdevinci.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface Entity {

    public void create();

    public void makeMove();

    public TextureRegion getTexture(char c);
}
