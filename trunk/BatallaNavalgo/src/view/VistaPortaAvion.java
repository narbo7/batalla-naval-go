package view;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaPortaAvion extends VistaNave{

	public VistaPortaAvion(ObjetoPosicionable modelo,int ubicacion,int posicionEnBarco) throws IOException{
		super(getUrl(ubicacion,posicionEnBarco),modelo);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
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
		return new File("./imagenes/naves/pa/"+u+"/pa"+posicionEnBarco+".png").toURI().toURL();
	}
}
