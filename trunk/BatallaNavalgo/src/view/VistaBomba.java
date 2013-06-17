package view;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBomba extends Cuadrado {

	public VistaBomba(ObjetoPosicionable modelo) {
		super(5, 3, modelo);
		setColor();
	}
	public void setColor(){
		this.setColor(Color.WHITE);
		
	}

}
