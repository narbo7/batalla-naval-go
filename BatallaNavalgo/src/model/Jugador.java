package model;

import java.util.LinkedList;

public class Jugador {

	private int puntaje;

	private LinkedList<Bomba> bombas;
	private Bomba bombaSeleccionada;

	public Jugador(){
        this.puntaje = 10000;
//		this.bombas = new LinkedList<Bomba>();
//		Posicion unaPosicion = new Posicion();
//		Bomba unaBomba = new Disparo(unaPosicion);
//		this.bombas.add(1,unaBomba);
//		unaBomba = new MinaConRetardo(unaPosicion);
//		this.bombas.add(2,unaBomba);
//		unaBomba = new MinaDobleConRetardo(unaPosicion);
//		this.bombas.add(3,unaBomba);
//		unaBomba = new MinaTripleConRetardo(unaPosicion);
//		this.bombas.add(4,unaBomba);
//		unaBomba = new MinaPorContacto(unaPosicion);
//		this.bombas.add(5,unaBomba);
	}

	public Bomba dispararBomba() {
		// el jugador debe disparar una bomba seleccionada.
		//setea la bomba en el tablero.
		//TODO: Modificar esto, la vista va a indicar cual es la bomba seleccionada.
//		Bomba unaBomba = new MinaPorContacto();
//		this.seleccionarBomba(unaBomba);
		return bombaSeleccionada;
	}
	public void seleccionarBomba(Bomba unaBomba){
		this.bombaSeleccionada= unaBomba;
	}
	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int unPuntaje) {
		this.puntaje = unPuntaje;
	}

}
