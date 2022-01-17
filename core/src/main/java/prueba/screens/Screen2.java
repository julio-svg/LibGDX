package prueba.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen2 implements Screen {

    private static final float WORLD_WIDTH = 10;
    private static final float WORLD_HEIGTH = 10;

    private SpriteBatch batch;
    private Camera cam;
    private Viewport viewport;

    private Texture texture;
    private Animation<TextureRegion> animation;
    private Float stateTime;

    public Screen2() {
        batch = new SpriteBatch();
        viewport = new ExtendViewport(WORLD_WIDTH/2, WORLD_HEIGTH/2);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
        cam = viewport.getCamera();

        texture = new Texture("cat_walk2.png");
        /** haremos un secuencia con una imagen con los pasos del gato */
        TextureRegion[] [] regions = TextureRegion.split(texture,410,207);

        /** Iniciamos la animacion, con el primer frame */
        animation = new Animation<>(0.2f,regions[0]);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        stateTime = 0f;

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stateTime += delta;

        System.out.println("delta = " + delta);
        System.out.println("stateTime = " + stateTime);

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(animation.getKeyFrame(stateTime), 0, 0,2,2);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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

    @Override
    public void dispose() {

    }

    @Override
    public void show() {

    }
}
