package model;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import view.VistaElementoDelJuego;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public class ParteDeNave extends ElementoDelJuego implements ObjetoVivo, ObjetoPosicionable,Observer{
	
	private int resistencia;
	
	public ParteDeNave(Posicion posicion, int resistencia){
		this.posicion = posicion;
		this.resistencia = resistencia;
	}
	
	
	public int getResistencia(){
		return this.resistencia;
	}
	
	public void setResistencia(int resistencia){
		this.resistencia = resistencia;
	}
	
	public void reducirResistencia(int resistencia){;
		setResistencia((getResistencia()) - resistencia);
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}


	@Override
	public int getX() {
		return this.posicion.parametrizarX();
		//return (this.getPosicion().getColumna() + (this.getPosicion().getColumna()-1)*VentanaPrincipal.getAumentoVentana());
	}


	@Override
	public int getY() {
		return this.posicion.parametrizarY();
		//return (this.getPosicion().getFila() + (this.getPosicion().getFila()-1)*VentanaPrincipal.getAumentoVentana()); 
	}


	@Override
	public LinkedList<VistaElementoDelJuego> generarVista() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}


}
