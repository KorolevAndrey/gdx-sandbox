package tech.otter.gdxsandbox.demos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Path;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class PathDemo extends Demo {
    private ShapeRenderer sr;
    private Stage stage;

    public PathDemo() {
        super("Action Demo");
        stage = new Stage();
    }

    @Override
    public void show() {
        sr = new ShapeRenderer();
        Actor ourCircle = new SimpleCircleActor(sr, 10f);
        stage.addActor(ourCircle);

        ourCircle.addAction(new PathAction(5f, 50f, 50f, 100f, 60f, 300f, 200f, 100f, 400f));
    }

    @Override
    public void render(float delta) {
        sr.setAutoShapeType(true);
        sr.begin();
        sr.set(ShapeRenderer.ShapeType.Filled);
        stage.act(delta);
        stage.draw();
        sr.end();
    }

    @Override
    public void dispose() {
        stage.dispose();
        sr.dispose();
    }

    private class SimpleCircleActor extends Actor {
        private ShapeRenderer renderer;
        private float radius;

        public SimpleCircleActor(ShapeRenderer renderer, float radius) {
            this.renderer = renderer;
            this.radius = radius;
        }

        /**
         * Assumes something outside is setting the ShapeRenderer type/begin/end.
         * Don't do this at home, kids.
         */
        @Override
        public void draw(Batch batch, float delta) {
            renderer.circle(this.getX(), this.getY(), this.radius);
        }
    }

    private class PathAction extends Action {
        private Path<Vector2> path;
        private float current;
        private float duration;
        public PathAction(float duration, float... coordinates) {
            this.duration = duration;
            this.current = 0;

            Vector2[] dataSet = new Vector2[coordinates.length / 2];
            for(int i = 0; i < dataSet.length; i++) {
                dataSet[i] = new Vector2(coordinates[2*i], coordinates[2*i+1]);
            }
            this.path = new CatmullRomSpline<Vector2>(dataSet, true);
        }
        @Override
        public boolean act(float delta) {
            if(duration == current) return true; // The action has already completed.

            if(current + delta >= duration) {
                current = duration;
            } else {
                current += delta;
            }

            Vector2 out = new Vector2(); // Get our position on the path.
            this.path.valueAt(out, current / duration);
            this.actor.setPosition(out.x, out.y);

            return duration == current; // Return whether we are now complete.
        }
    }
}
