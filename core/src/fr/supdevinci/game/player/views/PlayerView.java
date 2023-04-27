package fr.supdevinci.game.player.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import fr.supdevinci.game.player.Player;
import fr.supdevinci.game.player.PlayerTextureMap;
import fr.supdevinci.game.player.utils.Direction;

public class PlayerView implements Drawable, PlayerTextureMap {
    public final static int WIDTH = 16;
    public final static int HEIGHT = 16;

    private final static int ANIM_LEFT = 3;
    private final static int ANIM_RIGHT = 1;
    private final static int ANIM_UP = 0;
    private final static int ANIM_DOWN = 2;

    private final static float ANIM_SPEED = 0.1f;

    private final static int[] ANIMS = { ANIM_LEFT, ANIM_RIGHT, ANIM_DOWN, ANIM_UP };

    private float time = .0f;

    private Texture texture;
    private TextureRegion[][] textureTiles;
    private Animation<TextureRegion>[] animations;

    private final Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    @Override
    public void create() {
        texture = new Texture("game-assets/characters/PremiumCharakterSpritesheet.png");
        textureTiles = TextureRegion.split(texture, WIDTH, HEIGHT);
        animations = new Animation[Direction.DIRECTIONS];

        for(int i = 0; i < animations.length; i++) {
            animations[i] = new Animation<>(
                    ANIM_SPEED,
                    textureTiles[i]
            );
        }
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        time += delta;
        player.updateAndProcessInputs(delta);

        Vector2 posititon = player.getPosition();

        batch.draw(
                (TextureRegion)player.getTexture(this),
                1 * .5f * (posititon.x+.25f) - (float) PlayerView.WIDTH / 2,
                1 * .5f * posititon.y
        );
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    @Override
    public Object getWalkTexture(int direction) {
        return animations[ANIMS[direction]].getKeyFrame(time, true);
    }

    @Override
    public Object getIdleTexture(int direction) {
        return textureTiles[ANIMS[direction]][1];
    }
}
