package fr.supdevinci.game.player;

public interface PlayerTextureMap {
    Object getWalkTexture(int direction);
    Object getIdleTexture(int direction);
    Object getChopTexture(int direction);

}
