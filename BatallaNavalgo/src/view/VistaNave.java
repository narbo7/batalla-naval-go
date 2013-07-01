package view;


import java.io.IOException;
import java.net.URL;
import java.util.Observer;

import model.Tablero;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaNave extends VistaElementoDelJuego {

	public static int AnchoNave() { return VentanaPrincipal.relacionTableroVentanaX / Tablero.getMaxColumna();}
	
	public VistaNave(URL imgURL,ObjetoPosicionable modelo) throws IOException{
		//super(VistaNave.AnchoNave(),VistaNave.AnchoNave(),modelo);
		super(imgURL, modelo);
		
	}
}
