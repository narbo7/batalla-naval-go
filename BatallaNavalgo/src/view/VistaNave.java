package view;

import java.awt.Color;
import java.util.List;
import java.util.Observer;

import model.Nave;
import model.Tablero;

import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaNave extends Cuadrado implements Observer {

	public static int AnchoNave() { return VentanaPrincipal.relacionTableroVentanaX / Tablero.getMaxColumna();}
	
	public VistaNave(ObjetoPosicionable modelo) {
		super(VistaNave.AnchoNave(),VistaNave.AnchoNave(),modelo);
		setColor();
	}
	public abstract void setColor();

	

}
