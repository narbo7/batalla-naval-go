package model;

import java.util.LinkedList;

import fiuba.algo3.titiritero.modelo.ObjetoVivo;



public class Partida implements ObjetoVivo{

	private Tablero tablero;
	
	public Tablero getTablero() {return this.tablero;}
	
	public Partida() {
		this.tablero = new Tablero();
		
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
	
	@Override
	public void vivir() {
		//System.out.println("La partida vive");
		this.tablero.vivir();
		//this.tablero.verificarSiHayExplosiones();
	}

}
