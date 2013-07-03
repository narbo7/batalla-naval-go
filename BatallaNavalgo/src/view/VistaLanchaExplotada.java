package view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaLanchaExplotada extends VistaNave{

	public VistaLanchaExplotada(ObjetoPosicionable modelo, int ubicacion,int posicionEnBarco) throws IOException{
		super(getUrl(ubicacion,posicionEnBarco),modelo);
	}


	private static URL getUrl(int ubicacion,int posicionEnBarco) throws MalformedURLException{
		String u = "horizontal";
		switch(ubicacion){
		case 1: 
			u = "horizontal";
			break;
		case 2:
			u = "vertical";
			break;
		}
		return new File("./imagenes/naves/lancha/"+u+"/lancha"+posicionEnBarco+"X.png").toURI().toURL();
	}


	
}