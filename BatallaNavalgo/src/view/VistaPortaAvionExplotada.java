package view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPortaAvionExplotada extends VistaNave{

	public VistaPortaAvionExplotada(ObjetoPosicionable modelo, int ubicacion,int posicionEnBarco) throws IOException{
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
		return new File("./imagenes/naves/pa/"+u+"/pa"+posicionEnBarco+"X.png").toURI().toURL();
	}


	
}