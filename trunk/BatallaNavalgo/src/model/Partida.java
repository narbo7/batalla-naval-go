package model;

import java.util.LinkedList;

import controller.ControladorTeclado;

import view.ObservadorMouse;
import view.ObservadorTeclado;
import view.VistaElementoDelJuego;


import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;



public class Partida implements ObjetoVivo,ObservadorMouse,ObservadorTeclado{

	private Tablero tablero;
	private Jugador jugador;
	private boolean enJuego;
	
	public Tablero getTablero() {return this.tablero;}
	
	public Partida() {
		this.enJuego = true;
		this.tablero = new Tablero();
		this.jugador = new Jugador();
		
		Lancha nave1 = new Lancha();
        Lancha nave2 = new Lancha();
        Destructor nave3 = new Destructor();
        Destructor nave4 = new Destructor();
        Buque nave5 = new Buque();
        Rompehielo nave6 = new Rompehielo();
        Portaavion nave7 = new Portaavion();
        
        tablero.agregarElemento(nave1); tablero.agregarNave(nave1);
        tablero.agregarElemento(nave2); tablero.agregarNave(nave2);
        tablero.agregarElemento(nave3); tablero.agregarNave(nave3);
        tablero.agregarElemento(nave4); tablero.agregarNave(nave4);
        tablero.agregarElemento(nave5); tablero.agregarNave(nave5);
        tablero.agregarElemento(nave6); tablero.agregarNave(nave6);
        tablero.agregarElemento(nave7); tablero.agregarNave(nave7);
	}
	
	public void juegoTermiado(){
		this.enJuego = false;
	}
	
	public boolean getEstadoDelJuego(){
		return this.enJuego;
	}
	
	public int getCantidadDeElementosEnTablero(){
		return this.tablero.getCantidadDeElementos();
	}

	public LinkedList<Nave> getNaves(){
		return this.tablero.getNaves();
	}
	
	public LinkedList<Bomba> getBombas() {
		return this.tablero.getBombas();
	}
	
	public LinkedList<ElementoDelJuego> getElementoDelJuego(){
		return this.tablero.getElementos();
	}
	
	@Override
	public void vivir() {
		this.tablero.vivir();
		
		this.getJugador().descontarPuntaje(10);
		if (this.getJugador().getPuntaje() <= 0 || this.getNaves().size() == 0){
			this.juegoTermiado();
		}
		
		System.out.println("PUNTAJE = " + this.getJugador().getPuntaje());

	}


	public synchronized void limpiar(GameLoop gameloop) {
		//Saco del gameLoop y de la partida las naves que estan hundidas
		LinkedList<Nave> listaNaves = new LinkedList<Nave>();
		for (Nave unaNave : this.getNaves()) {
			if (unaNave.estaHundida()) {listaNaves.add(unaNave);}
		}
		for (Nave unaNave : listaNaves) {
			for (VistaElementoDelJuego unaVista : unaNave.getObservadorNave()) {
				gameloop.remover(unaVista);
				gameloop.remover(unaNave);
				this.getNaves().remove(unaNave);
				this.getElementoDelJuego().remove(unaNave);
			}
		}
		
		//Saco del gameLoop y de la partida las bombas que estan explotadas
		LinkedList<Bomba> listaBombas = new LinkedList<Bomba>();
		for (Bomba unaBomba : this.getBombas()) {
			if (unaBomba.estaExplotada()) {
				listaBombas.add(unaBomba);
			} else {
    			gameloop.agregar(unaBomba);
    			gameloop.agregar(unaBomba.getObservadorBomba());
			}
		}
		for (Bomba unaBomba: listaBombas) {
			gameloop.remover(unaBomba.getObservadorBomba());
			gameloop.remover(unaBomba);
			this.getBombas().remove(unaBomba);
			this.getElementoDelJuego().remove(unaBomba);

		}
	}

	@Override
	public void notificarEvento(int posicionX, int posicionY) {
		//enviar disparo.
		Posicion posicionEvento = new Posicion(posicionY,posicionX);
		Bomba bomba = this.getJugador().dispararBomba();
		if(bomba!=null){
		bomba.setPosicion(posicionEvento.desparametrizarPosicion());
		this.agregarElementoAlTablero(bomba);
		this.agregarBomba(bomba);
		}

	}
	
	public void agregarElementoAlTablero(ElementoDelJuego elementoDelJuego){
		tablero.agregarElemento(elementoDelJuego);
	}
	
	public void agregarBomba(Bomba bomba) {
		tablero.agregarBomba(bomba);
	}

	public Jugador getJugador(){
		return this.jugador;
	}

	@Override
	public void notificarEvento(char key) {
		ControladorTeclado controlador = new ControladorTeclado();
		Bomba unaBomba = controlador.getBombaAsociadaATecla(key);
		if(unaBomba!=null)
			this.jugador.seleccionarBomba(unaBomba);
	}

}
