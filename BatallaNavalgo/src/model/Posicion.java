package model;


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
		return (RandomInt.generarRandomEntre(valorInicial, valorFinal));
	}
	
	public boolean esIgualA(Posicion otraPosicion){
		return ((this.getFila() == otraPosicion.getFila()) && (this.getColumna() == otraPosicion.getColumna())); 
	}

}
