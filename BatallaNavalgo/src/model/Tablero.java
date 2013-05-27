package model;

import java.util.ArrayList;


public class Tablero {
	
	
	private ArrayList<ElementoDelJuego> casilleros;
	
	public Tablero(int tamanio){
		
		this.casilleros = new ArrayList<ElementoDelJuego>(tamanio);
		
	}
	
	public void agregarElemento(ElementoDelJuego elemento, Posicion posicion) {
		
		int valor = posicion.convertirPosicion(posicion);
		this.casilleros.add(valor, elemento);
		
	}
	
	public void quitarElemento(Posicion posicion) {
		
		int valor = posicion.convertirPosicion(posicion);
		this.casilleros.add(valor, null);
	}
	
	public ArrayList<ElementoDelJuego> getCasilleros(){
		
		return casilleros;
		
	}

}
