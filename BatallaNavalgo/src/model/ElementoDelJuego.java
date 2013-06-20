package model;

import java.util.LinkedList;

import view.VistaElementoDelJuego;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;


public abstract class ElementoDelJuego implements ObjetoVivo{
	
	
	protected Posicion posicion;
	
	public ElementoDelJuego(){
		
		this.posicion = new Posicion();
	}
	
	public ElementoDelJuego(Posicion unaPosicion){
		
		this.posicion = unaPosicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public abstract LinkedList<VistaElementoDelJuego> generarVista();
	
}
