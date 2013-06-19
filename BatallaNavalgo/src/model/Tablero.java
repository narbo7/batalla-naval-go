package model;

import java.util.LinkedList;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;


public class Tablero implements ObjetoVivo{
	
	static final int maxFila = 10;
	static final int maxColumna = 10;	
	
	private LinkedList<ElementoDelJuego> elementos;
	private LinkedList<Nave> naves;
	
	public Tablero(){
		this.elementos = new LinkedList<ElementoDelJuego>();
		this.naves = new LinkedList<Nave>();
	}
	
	public static int getMaxFila(){
		return (Tablero.maxFila );
	}
	
	public static int getMaxColumna(){
		return (Tablero.maxColumna);
	}
	
	public void agregarElemento(ElementoDelJuego elemento) {
		this.elementos.add(elemento);
	}
	
	public void agregarNave(Nave nave) {
		this.naves.add(nave);
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

	public LinkedList<Nave> getNaves() {
		return naves;
	}

	public void setNaves(LinkedList<Nave> naves) {
		this.naves = naves;
	}

	@Override
	public void vivir() {
		for (ElementoDelJuego elemento: this.getElementos()){
			elemento.vivir();
		}
		
	}

}
