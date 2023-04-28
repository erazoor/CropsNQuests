package fr.supdevinci.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import fr.supdevinci.game.ui.inventory.Inventory;
import fr.supdevinci.game.ui.settings.Settings;
import fr.supdevinci.game.views.Drawable;
import fr.supdevinci.game.views.InventoryView;
import fr.supdevinci.game.views.SettingsView;

import java.util.ArrayList;
import java.util.List;

public class Main extends ApplicationAdapter{

	// Graphical data
	private SpriteBatch batch;
	private final Inventory inventory;
	private final Settings settings;
	private final List<Drawable> drawables;

	public Main() {
		this.inventory = new Inventory();
		this.settings = new Settings();
		this.drawables = new ArrayList<>();
		this.drawables.add(new SettingsView(settings));
		this.drawables.add(new InventoryView(inventory));

	}

	@Override
	public void create() {
		this.drawables.forEach(Drawable::create);
		System.out.println("size : " + drawables.size());
		this.batch = new SpriteBatch();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 120, 0.7f, 0);

		this.batch.begin();
		this.drawables.forEach(d -> d.render(batch));
		this.batch.end();
	}

	@Override
	public void dispose() {
		this.batch.dispose();
		this.drawables.forEach(Drawable::dispose);
	}
}