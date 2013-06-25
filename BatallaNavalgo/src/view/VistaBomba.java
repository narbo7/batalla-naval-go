package view;

import java.awt.Color;

import fiuba.algo3.titiritero.dibujables.Circulo;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBomba extends Circulo {

	public VistaBomba(int arg0, ObjetoPosicionable arg1) {
		super(arg0, arg1);
		this.setColor();
	}
	
	public void setColor() {
		this.setColor(Color.WHITE);
	}

}
