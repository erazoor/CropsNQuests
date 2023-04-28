package fr.supdevinci.game.ui.settings;

public class Settings {
    private SettingsMenuState state = new QuitState();

    public void setState(SettingsMenuState state) {
        this.state = state;
    }
    public void openedState() {
        state.open(this);
    }
    public void settingState() { state.setting(this); }
    public void quitState() {
        state.quit(this);
    }
    public void printStatus() {
        state.printStatus();
    }
}
