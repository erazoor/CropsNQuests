package fr.supdevinci.game.Entity;

public class ObjectFactory {
    private Entity tree;
    private Entity bridge;

    public ObjectFactory() {
            tree = new Tree();
            bridge = new Bridge();
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
