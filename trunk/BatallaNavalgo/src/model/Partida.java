package model;



public class Partida{

	private Tablero tablero;
	
	public Partida(){
		this.tablero = new Tablero();
		for (int i=0; i < 10; i++) {
			tablero.agregarElemento(new ElementoDelJuego());
		}
	}
	
	public int getCantidadDeElementosEnTablero(){
		return this.tablero.getCantidadDeElementos();
	}
	
	public static void main(String[] args) {
		Partida miPartida = new Partida();
		
		System.out.printf("Partida creada con un tablero y", miPartida.getCantidadDeElementosEnTablero(), "elementos");

	}

}
