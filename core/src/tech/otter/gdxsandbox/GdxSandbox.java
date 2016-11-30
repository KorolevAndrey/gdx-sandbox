package tech.otter.gdxsandbox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.kotcrab.vis.ui.VisUI;
import tech.otter.gdxsandbox.demos.Demo3D;
import tech.otter.gdxsandbox.demos.PathDemo;

public class GdxSandbox extends Game {

	@Override
	public void create () {
        VisUI.load();

        setScreen(
                new MenuScreen(
                        this,
                        Array.with(new Demo3D(), new PathDemo())
                )
        );
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(screen != null) screen.render(Gdx.graphics.getDeltaTime());
	}

	@Override
    public void dispose() {
        VisUI.dispose();
    }
}
