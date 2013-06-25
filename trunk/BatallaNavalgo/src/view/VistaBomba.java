package view;

import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaBomba extends Imagen {

	public VistaBomba(URL imgURL, ObjetoPosicionable modelo) throws IOException{
		super(imgURL, modelo);
	}
}
