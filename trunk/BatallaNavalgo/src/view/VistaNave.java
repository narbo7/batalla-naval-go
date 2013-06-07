package view;

import java.util.List;
import java.util.Observer;

import model.Nave;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaNave extends Cuadrado implements Observer {

	public VistaNave(ObjetoPosicionable modelo) {
		super(modelo.getX(),modelo.getY(),modelo);
		setColor();
	}
	public abstract void setColor();

	

}
