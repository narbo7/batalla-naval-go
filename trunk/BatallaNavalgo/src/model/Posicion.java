package model;

import java.util.Random;

public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion (){
		this.fila = this.generarCoordenadaEntre(1,Tablero.getMaxFila());
		this.columna = this.generarCoordenadaEntre(1,Tablero.getMaxColumna());
	}
	
	public Posicion(int fila, int columna) throws ErrorFueraDeRango{
		
		if ((fila > Tablero.getMaxFila()) || (columna > Tablero.getMaxColumna()))
			throw new ErrorFueraDeRango();
		
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
	
	public int generarCoordenadaEntre(int valorInicial, int valorFinal){
		return (int)((new Random().nextDouble()*valorFinal)+valorInicial);
	}
	
	public boolean esIgualA(Posicion otraPosicion){
		return ((this.getFila() == otraPosicion.getFila()) && (this.getColumna() == otraPosicion.getColumna())); 
	}
	
	/*Convierte las coordenadas de una posicion 
	 * para poder almarcernarlas en una lista*/
	public int convertirPosicion(Posicion posicion) {
		
		int fila = posicion.getFila();
		int columna = posicion.getColumna();
				
		return ((fila + columna) - 1);
	}

}
