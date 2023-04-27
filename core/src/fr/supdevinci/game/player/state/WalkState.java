package fr.supdevinci.game.player.state;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;
import fr.supdevinci.game.player.handler.StateHandler;

public class WalkState implements StateHandler {
    private final float speed;
    private float delta;

    public WalkState(float speed) { this.speed = speed; }

    @Override
    public void update(Player player, float delta) {
        this.delta = delta;
        if (player.isDestinationReached()) {
            player.changeState(Player.STATE_IDLE);
        }
    }

    @Override
    public void processInputs(Player player) {
        // Nothing to do here
    }

    @Override
    public Object getTexture(Player player, PlayerTextureMap textureMap) {
        int direction = player.walkToDirection(speed * delta);

        player.setIdleDirection(direction);
        return textureMap.getWalkTexture(direction);
    }
}
