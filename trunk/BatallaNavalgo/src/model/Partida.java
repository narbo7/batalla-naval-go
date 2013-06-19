package model;

import java.util.LinkedList;

import controller.ControladorTeclado;

import view.ObservadorMouse;
import view.ObservadorTeclado;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;



public class Partida implements ObjetoVivo,ObservadorMouse,ObservadorTeclado{

	private Tablero tablero;
	private Jugador jugador;
	
	public Tablero getTablero() {return this.tablero;}
	
	
	public Partida() {
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
	
	public int getCantidadDeElementosEnTablero(){
		return this.tablero.getCantidadDeElementos();
	}

	public LinkedList<Nave> getNaves(){
		return this.tablero.getNaves();
	}
	public LinkedList<ElementoDelJuego> getElementoDelJuego(){
		return this.tablero.getElementos();
	}
	
	@Override
	public void vivir() {
		//System.out.println("La partida vive");
		this.tablero.vivir();
		//this.tablero.verificarSiHayExplosiones();
	}

	@Override
	public void notificarEvento(int posicionX, int posicionY) {
		//enviar disparo.
		Bomba bomba = this.getJugador().dispararBomba();
		bomba.setPosicion(new Posicion(posicionX, posicionY));
		this.agregarElementoAlTablero(bomba);
	}
	public void agregarElementoAlTablero(ElementoDelJuego elementoDelJuego){
		tablero.agregarElemento(elementoDelJuego);
	}

	public Jugador getJugador(){
		return this.jugador;
	}

	@Override
	public void notificarEvento(char key) {
		ControladorTeclado controlador = new ControladorTeclado();
		Bomba unaBomba = controlador.getBombaAsociadaATecla(key);
		this.jugador.seleccionarBomba(unaBomba);
	}

}