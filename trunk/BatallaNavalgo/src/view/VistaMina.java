package view;

import java.io.File;
import java.io.IOException;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaMina extends VistaBomba{

	public VistaMina(ObjetoPosicionable modelo) throws IOException {
		super(new File("./imagenes/bombas/mina.jpg").toURI().toURL(), modelo);
	}

}
