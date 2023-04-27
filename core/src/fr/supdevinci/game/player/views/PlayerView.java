package fr.supdevinci.game.player.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;

import java.util.ArrayList;
import java.util.List;

public class PlayerView implements Drawable, PlayerTextureMap {

    private final static int ANIMATIONS_NUMBER = 24;
    private final static int WIDTH = 48;
    private final static int HEIGHT = 48;

    private final static int ANIM_LEFT = 2;
    private final static int ANIM_RIGHT = 3;
    private final static int ANIM_UP = 1;
    private final static int ANIM_DOWN = 0;

    private final static float ANIM_SPEED = 0.1f;

    private final int[] ANIMATIONS = { ANIM_LEFT, ANIM_RIGHT, ANIM_DOWN, ANIM_UP };

    private float time = .0f;

    private Texture texture;
    private final List<Animation<TextureRegion>> animations;

    private final Player player;

    public PlayerView(Player player) {
        this.player = player;
        this.animations = new ArrayList<>();
    }

    @Override
    public void create() {
        texture = new Texture("game-assets/characters/PremiumCharakterSpritesheet.png");
        TextureRegion[][] textureTiles = TextureRegion.split(texture, WIDTH, HEIGHT);

        for(int i = 0; i < ANIMATIONS_NUMBER; i++) {
            animations.add(new Animation<>(ANIM_SPEED, textureTiles[i]));
        }
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        time += delta;
        player.updateAndProcessInputs(delta);

        Vector2 position = player.getPosition();

        batch.draw(
                (TextureRegion)player.getTexture(this),
                10 * .5f * (position.x+.25f) - (float) PlayerView.WIDTH / 2,
                10 * .5f * position.y
        );
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    @Override
    public Object getIdleTexture(int direction) {
        return animations.get(ANIMATIONS[direction]).getKeyFrame(this.time, true);
    }

    @Override
    public Object getWalkTexture(int direction) {
        return animations.get(ANIMATIONS[direction] + 4).getKeyFrame(this.time, true);
    }

    @Override
    public Object getChopTexture(int direction) {
        return animations.get(ANIMATIONS[direction] + 16).getKeyFrame(this.time, true);
    }
}
