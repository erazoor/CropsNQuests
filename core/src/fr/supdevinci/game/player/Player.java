package fr.supdevinci.game.player;

import com.badlogic.gdx.math.Vector2;
import fr.supdevinci.game.map.GameBoard;
import fr.supdevinci.game.player.handler.StateHandler;
import fr.supdevinci.game.player.state.IdleState;
import fr.supdevinci.game.player.state.WalkState;
import fr.supdevinci.game.player.state.ChopState;
import fr.supdevinci.game.player.utils.Direction;

public class Player {
    public final static int STATE_IDLE = 0;
    public final static int STATE_MOVING = 1;
    public final static int STATE_CHOPPING = 2;

    private final static float SPEED = 12f;
    private Vector2 actual, destination;
    private int idleDirection;
    private final GameBoard map;
    private final StateHandler[] states;
    private StateHandler currentState;

    public Player(GameBoard map) {
        this.map = map;
        this.states = new StateHandler[]{
                new IdleState(),
                new WalkState(SPEED),
                new ChopState()
        };
        reset();
    }

    public Vector2 getPosition() {
        return actual;
    }
    public Vector2 getPreviousPosition() {
        if (actual == null) {
            return new Vector2(50f, 50f);
        }
        if (actual.x == destination.x) {
            return new Vector2(actual.x, actual.y - 1);
        } else {
            return new Vector2(actual.x - 1, actual.y);
        }
    }

    public Boolean isOnWater() {
        return map.isWater((int) actual.x, (int) actual.y);
    }

    public Boolean isOutOfBound() {
        return map.isOutOfBound((int) actual.x, (int) actual.y);
    }

    public void changeState(int newState) {
        currentState = states[newState];
    }

    public void reset() {
        this.idleDirection = Direction.DOWN;
        this.actual = new Vector2(getPreviousPosition());
        this.destination = this.actual.cpy();
        changeState(STATE_IDLE);
    }

    public void updateAndProcessInputs(float delta) {
        currentState.update(this, delta);
        currentState.processInputs(this);
    }

    public Object getTexture(PlayerTextureMap textureMap) {
        return currentState.getTexture(this, textureMap);
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

            if(!map.isWater(destX, destY) && !map.isOutOfBound(destX, destY)) {
                this.destination.set(destX, destY);
                changeState(Player.STATE_MOVING);
            }
        }
    }

    public void tryToChop(Boolean bool) {
        if (bool) {
            changeState(Player.STATE_CHOPPING);
        }
    }

    public int getPlayerDirection() {
        if (actual.x < destination.x) {
            return Direction.RIGHT;
        }
        if (actual.x > destination.x) {
            return Direction.LEFT;
        }
        if (actual.y < destination.y) {
            return Direction.UP;
        }
        if (actual.y > destination.y) {
            return Direction.DOWN;
        }
        return idleDirection;
    }
}