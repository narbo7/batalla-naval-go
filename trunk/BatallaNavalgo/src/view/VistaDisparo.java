package view;

import java.io.File;
import java.io.IOException;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDisparo extends VistaBomba{

	public VistaDisparo(ObjetoPosicionable modelo) throws IOException {
		super(new File("./imagenes/bombas/disparo.jpg").toURI().toURL(), modelo);
	}

}
