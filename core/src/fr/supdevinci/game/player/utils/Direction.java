package fr.supdevinci.game.player.utils;

import com.badlogic.gdx.math.Vector2;

public class Direction {
    public final static int DIRECTIONS = 4;
    public final static int NONE = -1;
    public final static int LEFT = 0;
    public final static int RIGHT = 1;
    public final static int DOWN = 2;
    public final static int UP = 3;

    public static int move(Vector2 from, Vector2 to, Vector2 delta) {
        int direction = NONE;

        if(to.x<from.x) { direction = LEFT ; from.x=Math.max(to.x, from.x-delta.x); }
        else if(to.x>from.x) { direction = RIGHT; from.x=Math.min(to.x, from.x+delta.x); }
        else if(to.y<from.y) { direction = DOWN ; from.y=Math.max(to.y, from.y-delta.y); }
        else { direction = UP   ; from.y=Math.min(to.y, from.y+delta.y); }

        return direction;
    }

    public static int face() {
        return NONE;
    }
}
