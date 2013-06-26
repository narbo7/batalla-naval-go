package model;

import java.util.LinkedList;

import controller.ControladorTeclado;

import view.ObservadorMouse;
import view.ObservadorTeclado;


import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;



public class Partida implements ObjetoVivo,ObservadorMouse,ObservadorTeclado{

	private Tablero tablero;
	private Jugador jugador;
	private boolean enJuego;
	private Lancha lancha1; 
	private Lancha lancha2;
	private Destructor destructor1;
	private Destructor destructor2;
	private Buque buque;
	private Rompehielo rompehielo;
	private Portaavion portaavion;
	
	
	public Tablero getTablero() {return this.tablero;}
	
	
	public Partida() {
		this.enJuego = true;
		this.tablero = new Tablero();
		this.jugador = new Jugador();
		
		/*Lancha nave1 = new Lancha();
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
		*/
		
		this.lancha1 = new Lancha();
		this.lancha2 = new Lancha();
		this.destructor1 = new Destructor();
		this.destructor2 = new Destructor();
		this.buque = new Buque();
		this.rompehielo = new Rompehielo();
		this.portaavion = new Portaavion();
		
		tablero.agregarElemento(this.lancha1); tablero.agregarNave(this.lancha1);
		tablero.agregarElemento(this.lancha2); tablero.agregarNave(this.lancha2);
		tablero.agregarElemento(this.destructor1); tablero.agregarNave(this.destructor1);
		tablero.agregarElemento(this.destructor2); tablero.agregarNave(this.destructor2);
		tablero.agregarElemento(this.buque); tablero.agregarNave(this.buque);
		tablero.agregarElemento(this.rompehielo); tablero.agregarNave(this.rompehielo);
		tablero.agregarElemento(this.portaavion); tablero.agregarNave(this.portaavion);
		
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
		//this.limpiar();
		this.tablero.vivir();
		System.out.println("Cantidad de bombas = " +this.getBombas().size());

		this.getJugador().descontarPuntaje(10);
		if (this.getJugador().getPuntaje() <= 0){
			this.juegoTermiado();
		}
		
		System.out.println(this.getJugador().getPuntaje());
		
	}


	public void limpiar(GameLoop gameloop) {
		//Saco del gameLoop y de la partida las naves que estan hundidas
		LinkedList<Nave> listaNaves = new LinkedList<Nave>();
		for (Nave unaNave : this.getNaves()) {
			if (unaNave.estaHundida()) {listaNaves.add(unaNave);}
		}
		for (Nave unaNave : listaNaves) {
			gameloop.remover(unaNave);
			this.getNaves().remove(unaNave);
		}
		
		//Saco del gameLoop y de la partida las bombas que estan explotadas
		LinkedList<Bomba> listaBombas = new LinkedList<Bomba>();
		for (Bomba unaBomba : this.getBombas()) {
			if (unaBomba.estaExplotada()) {listaBombas.add(unaBomba);}
		}
		for (Bomba unaBomba: listaBombas) {
			gameloop.remover(unaBomba);
			this.getBombas().remove(unaBomba);
		}
		
		//Agrego al gameLoop las bombas que se encuentran en el tablero
		for (Bomba unaBomba : this.getBombas()) {
			if (!unaBomba.estaExplotada()){
    			gameloop.agregar(unaBomba);
    			gameloop.agregar(unaBomba.generarVistaBomba());
			}
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
		bomba.atacar(this.lancha1);
		bomba.atacar(this.lancha2);
		bomba.atacar(this.destructor1);
		bomba.atacar(this.destructor2);
		bomba.atacar(this.buque);
		bomba.atacar(this.rompehielo);
		bomba.atacar(this.portaavion);
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
