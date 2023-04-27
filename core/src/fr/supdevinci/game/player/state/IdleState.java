package fr.supdevinci.game.player.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;
import fr.supdevinci.game.player.handler.StateHandler;

public class IdleState implements StateHandler {

    public IdleState() { }


    @Override
    public void update(Player player, float delta) {
        // Noting to do here
    }

    @Override
    public void processInputs(Player player) {
        int directionX = 0;
        int directionY = 0;

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            directionX = Gdx.input.isKeyPressed(Input.Keys.LEFT) ? -1:1;
        else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)||Gdx.input.isKeyPressed(Input.Keys.UP))
            directionY = Gdx.input.isKeyPressed(Input.Keys.DOWN) ? -1:1;

        player.tryToMoveToDestination(directionX, directionY);
    }

    @Override
    public Object getTexture(Player player, PlayerTextureMap textureMap) {
        return textureMap.getIdleTexture(player.getIdleDirection());
    }
}
