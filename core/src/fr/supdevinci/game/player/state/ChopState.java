package fr.supdevinci.game.player.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;
import fr.supdevinci.game.player.handler.StateHandler;

public class ChopState implements StateHandler {
    private int direction;
    private float chopTime;
    private static final float CHOP_DURATION = 1.0f;

    public ChopState() { }

    @Override
    public void update(Player player, float delta) {
        chopTime += delta;
        if (chopTime >= CHOP_DURATION) {
            player.changeState(Player.STATE_IDLE);
        }
    }

    @Override
    public void processInputs(Player player) {
        // Nothing to do here
    }

    @Override
    public Object getTexture(Player player, PlayerTextureMap textureMap) {
        return textureMap.getChopTexture(player.getPlayerDirection());
    }
}
