package fr.supdevinci.game.ui.inventory;

public interface InventoryState {
    void open(Inventory inventory);
    void close(Inventory inventory);
    void printStatus();
}
