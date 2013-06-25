package view;



import java.io.IOException;
import java.net.URL;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaElementoDelJuego extends Imagen {
	
	public VistaElementoDelJuego(URL imgURL, ObjetoPosicionable modelo) throws IOException{
		//super(entero1, entero2, modelo);
		super(imgURL,modelo);
	}	
}
