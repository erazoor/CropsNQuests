package fr.supdevinci.game.ui.inventory;

public class Inventory {
    private InventoryState state = new ClosedState();

    public void setState(InventoryState state) {
        this.state = state;
    }
    public void openedState() {
        state.open(this);
    }
    public void closedState() {
        state.close(this);
    }
    public void printStatus() {
        state.printStatus();
    }
}
