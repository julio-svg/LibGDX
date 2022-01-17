package prueba.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen3 implements Screen {

    private static final float WORLD_WIDTH = 10;
    private static final float WORLD_HEIGTH = 10;

    private SpriteBatch batch;
    private Camera cam;
    private Viewport viewport;

    private TextureAtlas atlas;
    private Animation<TextureRegion> animation;
    private Float stateTime;

    public Screen3() {
        batch = new SpriteBatch();
        viewport = new ExtendViewport(WORLD_WIDTH/2, WORLD_HEIGTH/2);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
        cam = viewport.getCamera();

        /** Indicamos donde esta el fichero Atlas, generado con Texture package apartir de assets/skeleton/skeleton_0,1,2,3.png
            este fichero indica la coordenadas de la fusion de skeleton_0,1,2,3.png en skeleton_packet skeleton.png
            !las imagenes tiene que venir con _Numero
        */
        atlas = new TextureAtlas("skeleton_packet/skeleton.atlas");
        /** Array con las regiones con el nombre skeleton */
        Array<TextureAtlas.AtlasRegion> run = atlas.findRegions("skeleton");

        animation = new Animation<>(0.2f,run,Animation.PlayMode.LOOP);
        stateTime = 0f;

    }

    @Override
    public void show() {

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

}
