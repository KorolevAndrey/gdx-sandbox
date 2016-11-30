package tech.otter.gdxsandbox.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by john on 11/28/16.
 */
public class SpriteBatchDemo extends Demo {
    private SpriteBatch batch;

    public SpriteBatchDemo() {
        super("Sprite Batch Demo");
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        batch.draw(new Texture(Gdx.files.internal("")),
                0, 0,
                (int)3.5f, (int)3.5f,
                (int)3.5f, (int)3.5f);
    }

    @Override
    public void dispose() {

    }
}
