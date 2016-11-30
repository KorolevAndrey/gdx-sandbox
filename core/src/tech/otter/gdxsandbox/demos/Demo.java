package tech.otter.gdxsandbox.demos;

import com.badlogic.gdx.Screen;

public abstract class Demo implements Screen {
    private String name;

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
