package model;

import java.util.LinkedList;

public class Jugador {

	private int puntaje;

	private LinkedList<Bomba> bombas;

	public Jugador(){
        this.puntaje = 10000;
		this.bombas = new LinkedList<Bomba>();
		Bomba unaBomba = new Disparo();
		this.bombas.add(1,unaBomba);
		unaBomba = new MinaConRetardo();
		this.bombas.add(2,unaBomba);
		unaBomba = new MinaDobleConRetardo();
		this.bombas.add(3,unaBomba);
		unaBomba = new MinaTripleConRetardo();
		this.bombas.add(4,unaBomba);
		unaBomba = new MinaPorContacto();
		this.bombas.add(5,unaBomba);
	}

	/*
	//Hay que definir el metodo clone() para bombas.

	public Bomba dispararBomba(Posicion unaPosicion, int indice) {
        //ElementoDelJuego unaBomba = (ElementoDelJuego) this.bombas.get(indice).clone();
        //Bomba unaBomba = (Bomba) this.bombas.get(indice).clone();
        unaBomba.setPosicion(unaPosicion);
        return unaBomba;
	}
	*/

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int unPuntaje) {
		this.puntaje = unPuntaje;
	}

}
