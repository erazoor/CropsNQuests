package fr.supdevinci.game.ui.settings;

public interface SettingsMenuState {
    void open(Settings settings);
    void setting(Settings settings);
    void quit(Settings settings);
    void printStatus();
}
