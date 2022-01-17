package prueba.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Screen1 implements Screen {

    private static final float WORLD_WIDTH = 10;
    private static final float WORLD_HEIGTH = 10;

    /** SpriteBatch = atraves del que pintamos **/
    private SpriteBatch batch;

    private Camera cam;
    /** Viewport = dimensiones de la camara , nuestro mundo sera 10 x 10 independientemente de la camara**/
    private Viewport viewport;

    private Texture texture;


    public Screen1(){
        batch = new SpriteBatch();
        viewport = new ExtendViewport(WORLD_WIDTH/2, WORLD_HEIGTH/2);
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),true);
        cam = viewport.getCamera();

        texture = new Texture("skeleton.png");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /** asigna color a la pantalla**/
        Gdx.gl.glClearColor(0f, 0f, 0.2f, 1f);
        /** limpia pantalla **/
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /** le indicamos que nuestra camara sera su sistema de cordenadas, asi no usara pixeles, si
         *  no el mundo(viewport) que le indicamos
         */
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(texture, 0, 0,2,2);
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
