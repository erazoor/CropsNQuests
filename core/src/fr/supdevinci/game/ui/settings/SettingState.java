package fr.supdevinci.game.ui.settings;

public class SettingState implements SettingsMenuState{
    public void open(Settings settings) {
        settings.setState(new OpenedState());
    }
    public void setting(Settings settings) {
        System.out.println("Setting is already opened");
    }
    public void quit(Settings settings) {
        settings.setState(new QuitState());
    }
    public void printStatus() {
        System.out.println("Setting is opened");
    }
}
