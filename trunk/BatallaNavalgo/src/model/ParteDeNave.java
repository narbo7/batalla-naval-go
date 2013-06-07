package model;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class ParteDeNave implements ObjetoVivo, ObjetoPosicionable,Observer{
	
	private Posicion posicion;
	private int resistencia;
	
	public ParteDeNave(Posicion posicion, int resistencia){
		this.posicion = posicion;
		this.resistencia = resistencia;
	}
	
	public Posicion getPosicion(){
		return this.posicion;
	}
	
	public void setPosicion(Posicion posicion){
		this.posicion = posicion;
	}
	
	public int getResistencia(){
		return this.resistencia;
	}
	
	public void setResistencia(int resistencia){
		this.resistencia = resistencia;
	}
	
	public void reducirResistencia(int resistencia){
		this.resistencia -= resistencia;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}

}
