package view;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBomba extends VistaElementoDelJuego {

	public VistaBomba(ObjetoPosicionable modelo) {
		super(50, 30, modelo);
		setColor();
	}
	public void setColor(){
		this.setColor(Color.WHITE);	
	}

}
