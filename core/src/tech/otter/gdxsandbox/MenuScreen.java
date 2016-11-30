package tech.otter.gdxsandbox;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.kotcrab.vis.ui.widget.VisTable;
import com.kotcrab.vis.ui.widget.VisTextButton;
import tech.otter.gdxsandbox.demos.Demo;

class MenuScreen extends StageScreen {
    private Array<Demo> demos;

    public MenuScreen(Game controller, Array<Demo> demos) {
        super(controller);
        this.demos = demos;
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        VisTable table = new VisTable();
        table.setFillParent(true);

        for(final Demo demo : demos) {
            table.add(new VisTextButton(demo.getName(), new ChangeListener() {
                @Override
                public void changed(ChangeEvent changeEvent, Actor actor) {
                    controller.setScreen(demo);
                }
            }));
            table.row();
        }

        stage.addActor(table);
    }
}
