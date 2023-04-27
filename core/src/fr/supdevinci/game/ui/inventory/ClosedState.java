package fr.supdevinci.game.ui.inventory;

public class ClosedState implements InventoryState {
    @Override
    public void open(Inventory inventory) {
        inventory.setState(new OpenedState());
    }
    public void close(Inventory inventory) {
        System.out.println("Inventory is already closed");
    }
    @Override
    public void printStatus() {
        System.out.println("Inventory is closed");
    }
}
