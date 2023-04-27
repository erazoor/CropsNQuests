package fr.supdevinci.game.player.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;
import fr.supdevinci.game.player.handler.StateHandler;

public class ChopState implements StateHandler {

    public ChopState() { }

    @Override
    public void update(Player player, float delta) {
        // Noting to do here
    }

    @Override
    public void processInputs(Player player) {
        if(Gdx.input.isKeyPressed(Input.Keys.E))
            return;
    }

    @Override
    public Object getTexture(Player player, PlayerTextureMap textureMap) {
        int direction = player.chopToDirection();

        player.setChopDirection(direction);
        return textureMap.getChopTexture(direction);
    }
}
