package fr.supdevinci.game.player.handler;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerAnimation;

public class InputHandler implements InputProcessor {

    private Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
                player.moveUp();
                return true;
            case Input.Keys.RIGHT:
                player.moveRight();
                return true;
            case Input.Keys.DOWN:
                player.moveDown();
                return true;
            case Input.Keys.LEFT:
                player.moveLeft();
                return true;
            case Input.Keys.F:
                player.setAction(PlayerAnimation.Action.CHOP);
                return true;
            case Input.Keys.R:
                player.setAction(PlayerAnimation.Action.ATTACK);
                return true;
            case Input.Keys.T:
                player.setAction(PlayerAnimation.Action.WATER);
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.UP:
            case Input.Keys.RIGHT:
            case Input.Keys.DOWN:
            case Input.Keys.LEFT:
            case Input.Keys.F:
            case Input.Keys.T:
            case Input.Keys.R:
                player.setAction(PlayerAnimation.Action.IDLE);
                return false;
            default:
                return false;
        }
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
