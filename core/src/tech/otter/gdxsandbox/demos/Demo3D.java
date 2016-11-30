package tech.otter.gdxsandbox.demos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

/**
 * Created by john on 11/27/16.
 */
public class Demo3D extends Demo {
    private PerspectiveCamera camera;
    private Model model;
    private ModelInstance instance;
    private ModelBatch modelBatch;

    public Demo3D() {
        super("3D Demo");
    }

    @Override
    public void show() {
        modelBatch = new ModelBatch();
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createRect(-5f, 0f, -5f, 5f, 0f, -5f, 5f, 0f, 5f, -5f, 0f, 5f, 0f, 1.0f, 0f,
                new Material(ColorAttribute.createDiffuse(Color.GREEN)),
                VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
        instance = new ModelInstance(model);
    }

    @Override
    public void render(float delta) {
        modelBatch.begin(camera);
        modelBatch.render(instance);
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        model.dispose();
    }
}
