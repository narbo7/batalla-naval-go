package view;

import java.awt.Color;
import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaDestructor extends VistaNave{

	public VistaDestructor(ObjetoPosicionable modelo) {
		super(modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor() {
		this.setColor(Color.RED);
		
	}

}
