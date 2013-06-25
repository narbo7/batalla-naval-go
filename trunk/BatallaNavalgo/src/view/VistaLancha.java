package view;

import java.io.File;
import java.io.IOException;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaLancha extends VistaNave{
	private static int number;

	public VistaLancha(ObjetoPosicionable modelo) throws IOException{
		super(new File("./imagenes/naves/lancha/vertical/lancha"+(number+1)+".png").toURI().toURL(),modelo);
		number++;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
