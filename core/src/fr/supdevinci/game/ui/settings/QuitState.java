package fr.supdevinci.game.ui.settings;

public class QuitState implements SettingsMenuState {
    @Override
    public void quit(Settings settings) {
        System.out.println("Settings is already closed");
    }
    public void open(Settings settings) {
        settings.setState(new OpenedState());
    }
    public void setting(Settings settings) {
        settings.setState(new SettingState());
    }
    @Override
    public void printStatus() {
        System.out.println("Settings is closed");
    }
}
