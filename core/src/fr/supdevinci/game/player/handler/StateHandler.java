package fr.supdevinci.game.player.handler;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;

public interface StateHandler {
    void update(Player player, float delta);
    void processInputs(Player player);
    Object getTexture(Player player, PlayerTextureMap textureMap);
}
