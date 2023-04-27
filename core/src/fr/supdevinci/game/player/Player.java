package fr.supdevinci.game.player;

import com.badlogic.gdx.math.Vector2;
import fr.supdevinci.game.player.handler.StateHandler;
import fr.supdevinci.game.player.state.IdleState;
import fr.supdevinci.game.player.state.WalkState;
import fr.supdevinci.game.player.utils.Direction;

public class Player {
    public final static int STATE_IDLE = 0;
    public final static int STATE_MOVING = 1;
    public final static int STATE_CHOPPING = 2;

    private final static float SPEED = 4f;
    private Vector2 actual, destination;
    private int idleDirection;
    // private final Map map;

    private final StateHandler[] states;
    private StateHandler currentState;

    public Player(/* Map map */) {
        // this.map = map;
        this.states = new StateHandler[]{
                new IdleState(),
                new WalkState(SPEED)
        };
        reset();
    }

    public Vector2 getPosition() {
        return actual;
    }

    public Boolean isOnBorder() { /* TODO with map */
        return null;
    }

    public Boolean isOnWater() { /* TODO with map */
        return null;
    }

    public void changeState(int newState) {
        currentState = states[newState];
    }

    public void reset() {
        this.idleDirection = Direction.DOWN;
        this.actual = new Vector2(50f, 50f);
        this.destination = this.actual.cpy();
        changeState(STATE_IDLE);
    }

    public void updateAndProcessInputs(float delta) {
        currentState.update(this, delta);
        currentState.processInputs(this);
    }

    public int getIdleDirection() {
        return this.idleDirection;
    }

    public void setIdleDirection(int direction) {
        if(direction < 0 || Direction.DIRECTIONS <= direction ) {
            throw new IllegalArgumentException("Valid directions are 0, 1, 2, 3");
        }
        this.idleDirection = direction;
    }

    public Object getTexture(PlayerTextureMap textureMap) {
        return currentState.getTexture(this, textureMap);
    }

    public boolean isDestinationReached() {
        return this.actual.equals(this.destination);
    }

    public int walkToDirection(float step) {
        return Direction.move(this.actual, this.destination, new Vector2(step, step));
    }

    public void tryToMoveToDestination(int directionX, int directionY) {
        assert (((directionX == 0) || (directionY == 0)) && (directionX >= -1) && (directionX <= 1) && (directionY >= -1) && (directionY <= 1));
        if (directionX != 0 || directionY != 0) {
            int destX = (int) actual.x + directionX;
            int destY = (int) actual.y + directionY;

            this.destination.set(destX, destY);
            changeState(Player.STATE_MOVING);
            /*if(!map.isWall(destX, destY)) {
                this.destination.set(destX, destY);
                changeState(Player.STATE_MOVING);
            }*/
        }
    }

    public int chopToDirection() {
        return 0;
    }

    public void setChopDirection(int direction) {
        // TODO
    }
}