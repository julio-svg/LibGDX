package prueba.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen4 implements Screen {
    private static final float WORLD_WIDTH = 10;
    private static final float WORLD_HEIGTH = 10;

    private Batch batch;
    private Viewport viewport;
    private Camera cam;

    private Animation<TextureRegion> animation;
    private TextureAtlas atlas;
    private float stateTime;

    private Vector2 pos = new Vector2();
    private float velocity = 3f;

    public Screen4() {
        batch = new SpriteBatch();

        viewport = new ExtendViewport(WORLD_WIDTH, WORLD_HEIGTH);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
        cam = viewport.getCamera();

        /** imagenes que van a componer la animacion*/
        atlas = new TextureAtlas("skeleton_packet/skeleton.atlas");
        Array<TextureAtlas.AtlasRegion> run = atlas.findRegions("skeleton");

        animation = new Animation<TextureRegion>(0.2f,run, Animation.PlayMode.LOOP);


    }

    private void update() {

        float delta = Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            pos.x += velocity * delta;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            pos.x -= velocity * delta;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            pos.y += velocity * delta;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            pos.y -= velocity * delta;
        }

        pos.x = MathUtils.clamp(pos.x,0,WORLD_WIDTH);
        pos.y = MathUtils.clamp(pos.y,0,WORLD_HEIGTH);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update();

        stateTime += delta;

        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(animation.getKeyFrame(stateTime), pos.x, pos.y,2,2);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
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
