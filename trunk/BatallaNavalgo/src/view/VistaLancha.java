package view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaLancha extends VistaNave{
	private static int number;

	public VistaLancha(ObjetoPosicionable modelo, int ubicacion) throws IOException{
		super(getUrl(ubicacion),modelo);
		number++;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	private static URL getUrl(int ubicacion) throws MalformedURLException{
		String u = "horizontal";
		switch(ubicacion){
		case 1: 
			u = "horizontal";
			break;
		case 2:
			u = "vertical";
			break;
		}
		return new File("./imagenes/naves/lancha/"+u+"/lancha"+(number+1)+".png").toURI().toURL();
	}
	
}
