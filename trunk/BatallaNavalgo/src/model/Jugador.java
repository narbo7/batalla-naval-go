package model;

import java.util.LinkedList;

public class Jugador {

	private int puntaje;

	private LinkedList<Bomba> bombas;

	public Jugador(){
        this.puntaje = 10000;
		this.bombas = new LinkedList<Bomba>();
		Posicion unaPosicion = new Posicion();
		Bomba unaBomba = new Disparo(unaPosicion);
		this.bombas.add(1,unaBomba);
		unaBomba = new MinaConRetardo(unaPosicion);
		this.bombas.add(2,unaBomba);
		unaBomba = new MinaDobleConRetardo(unaPosicion);
		this.bombas.add(3,unaBomba);
		unaBomba = new MinaTripleConRetardo(unaPosicion);
		this.bombas.add(4,unaBomba);
		unaBomba = new MinaPorContacto(unaPosicion);
		this.bombas.add(5,unaBomba);
	}


	public Bomba dispararBomba(Posicion unaPosicion, int indice) {
        Bomba unaBomba = this.bombas.get(indice).copy();
        unaBomba.setPosicion(unaPosicion);
        return unaBomba;
	}


	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int unPuntaje) {
		this.puntaje = unPuntaje;
	}

}
