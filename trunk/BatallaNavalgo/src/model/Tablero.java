package model;

import java.util.Iterator;
import java.util.LinkedList;


public class Tablero {
	
	static final int maxFila = 10;
	static final int maxColumna = 10;	
	
	private LinkedList<ElementoDelJuego> elementos;
	
	public Tablero(){
		this.elementos = new LinkedList<ElementoDelJuego>();
	}
	
	static int getMaxFila(){
		return Tablero.maxFila;
	}
	
	static int getMaxColumna(){
		return Tablero.maxColumna;
	}
	
	public void agregarElemento(ElementoDelJuego elemento) {
		this.elementos.add(elemento);
	}
	
	public void quitarElemento(Posicion posicion) {
		for (Iterator<ElementoDelJuego> i = this.elementos.iterator(); i.hasNext();) {
			ElementoDelJuego unElemento = i.next();
			if (unElemento.getPosicion().esIgualA(posicion)){this.elementos.remove(unElemento);} 
		}
	}
	
	public int getCantidadDeElementos(){
		return this.elementos.size();
	}
	public LinkedList<ElementoDelJuego> getElementos(){
		return this.elementos;
	}

}
