package tech.otter.gdxsandbox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;

abstract class StageScreen implements Screen {
    protected Stage stage;
    protected Game controller;

    public StageScreen(Game controller) {
        this.controller = controller;
    }

    @Override
    public void render(float v) {
        stage.act(v);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
