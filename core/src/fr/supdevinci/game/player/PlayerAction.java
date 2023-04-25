package fr.supdevinci.game.player;

public class PlayerAction {
    private Player player;

    public PlayerAction(Player player) {
        this.player = player;
    }

    public void chop() {
        player.setAction(PlayerAnimation.Action.CHOP);
    }
}
