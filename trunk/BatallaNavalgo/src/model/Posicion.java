package model;

public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion(int fila, int columna){
		
		this.fila = fila;
		this.columna = columna;
	}
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	/*Convierte las coordenadas de una posicion 
	 * para poder almarcernarlas en una lista*/
	public int convertirPosicion(Posicion posicion) {
		
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
				
		return ((fila + columna) - 1);
	}

}
