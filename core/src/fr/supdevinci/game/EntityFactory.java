package fr.supdevinci.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.nio.charset.CharacterCodingException;

public class EntityFactory {
    private ObjectV2 tree;
    private ObjectV2 bridge;

    public EntityFactory() {
            tree = new Tree();
            bridge = new Bridge();
    }

    public ObjectV2 getEntity(char c) {
        switch (c) {
            case 'A':
                return tree;
            case 'B':
                return bridge;
            case ' ':
                return null;
            default:
                return null;
        }
    }
}
