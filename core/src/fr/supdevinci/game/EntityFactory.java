package fr.supdevinci.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.nio.charset.CharacterCodingException;

public class EntityFactory {
    private Entity tree;
    private Entity bridge;

    public EntityFactory() {
            tree = new Tree();
            tree.create();
            bridge = new Bridge();
            bridge.create();
    }

    public Entity getEntity(char c) {
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
