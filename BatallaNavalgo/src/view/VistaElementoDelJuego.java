package view;



import fiuba.algo3.titiritero.dibujables.Cuadrado;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class VistaElementoDelJuego extends Cuadrado {
	
	public VistaElementoDelJuego(int entero1, int entero2, ObjetoPosicionable modelo) {
		super(entero1, entero2, modelo);
		setColor();
	}
	
	public abstract void setColor();
	
}
