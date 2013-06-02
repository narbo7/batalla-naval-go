package model;



public class Partida{

	private Tablero tablero;
	
	public Partida(){
		this.tablero = new Tablero();
		tablero.agregarElemento(new Lancha());
		tablero.agregarElemento(new Lancha());
		tablero.agregarElemento(new Destructor());
		tablero.agregarElemento(new Destructor());
		tablero.agregarElemento(new Buque());
		tablero.agregarElemento(new Rompehielo());
		tablero.agregarElemento(new Portaavion());
		
	}
	
	public int getCantidadDeElementosEnTablero(){
		return this.tablero.getCantidadDeElementos();
	}
	
	public static void main(String[] args) {
		Partida miPartida = new Partida();
		
		System.out.println("Partida creada con un tablero y " + miPartida.getCantidadDeElementosEnTablero() + " elementos");

	}

}
