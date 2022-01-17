package prueba;


import com.badlogic.gdx.Game;

import prueba.screens.Screen2;
import prueba.screens.Screen3;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class primerJuego extends Game {


	@Override
	public void create() {

		setScreen(new Screen3());

	}


}