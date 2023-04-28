package fr.supdevinci.game.ui.settings;

public class OpenedState implements SettingsMenuState {
    @Override
    public void quit(Settings settings) {
        settings.setState(new QuitState());
    }
    public void open(Settings settings) {
        System.out.println("Settings is already opened");
    }
    public void setting(Settings settings) {
        settings.setState(new SettingState());
    }
    @Override
    public void printStatus() {
        System.out.println("Settings is opened");
    }
}
