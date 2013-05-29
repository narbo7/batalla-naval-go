package model;

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
		LinkedList<ElementoDelJuego> lista = new LinkedList<ElementoDelJuego>();
		
		for(ElementoDelJuego elemento : this.elementos){
			if (elemento.getPosicion().esIgualA(posicion)){lista.add(elemento);}
		}
		
		for(ElementoDelJuego elemento : lista){
			this.elementos.remove(elemento);
		}
		
	}
	
	public int getCantidadDeElementos(){
		return this.elementos.size();
	}
	public LinkedList<ElementoDelJuego> getElementos(){
		return this.elementos;
	}

}
