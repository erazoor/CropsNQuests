package fr.supdevinci.game.ui.inventory;

public class OpenedState implements InventoryState {
    @Override
    public void close(Inventory inventory) {
        inventory.setState(new ClosedState());
    }
    public void open(Inventory inventory) {
        System.out.println("Inventory is already opened");
    }
    @Override
    public void printStatus() {
        System.out.println("Inventory is opened");
    }
}
