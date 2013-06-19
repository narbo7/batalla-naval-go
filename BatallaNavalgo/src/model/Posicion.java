package model;

import view.VentanaPrincipal;


public class Posicion {
	
	private int fila;
	private int columna;
	
	public Posicion (){
		this.fila = this.generarCoordenadaEntre(1,Tablero.getMaxFila());
		this.columna = this.generarCoordenadaEntre(1,Tablero.getMaxColumna());
	}
	
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
	
	public int generarCoordenadaEntre(int valorInicial, int valorFinal){
		return (RandomInt.generarRandomEntre(valorInicial, valorFinal));
	}
	
	public boolean esIgualA(Posicion otraPosicion){
		return ((this.getFila() == otraPosicion.getFila()) && (this.getColumna() == otraPosicion.getColumna())); 
	}

	public int parametrizarX() {
		return (this.getColumna() + (this.getColumna()-1)*VentanaPrincipal.getAumentoVentana());
	}
	
	public int parametrizarY() {
		return (this.getFila() + (this.getFila()-1)*VentanaPrincipal.getAumentoVentana());
	}
	
	public int desparametrizarX() {
		return (this.getColumna() - (this.getColumna()-1)*VentanaPrincipal.getAumentoVentana());
	}
	
	public int desparametrizarY() {
		return (this.getFila() - (this.getFila()-1)*VentanaPrincipal.getAumentoVentana());
	}
	
	public Posicion desparametrizarPosicion() {
		
		return new Posicion(this.desparametrizarX(),this.desparametrizarY());
	}

}
