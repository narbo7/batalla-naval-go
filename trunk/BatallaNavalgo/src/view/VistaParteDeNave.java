package view;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaParteDeNave extends Cuadrado implements Observer{

	public VistaParteDeNave(ObjetoPosicionable modelo) {
		super(modelo.getX(),modelo.getY(), modelo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
