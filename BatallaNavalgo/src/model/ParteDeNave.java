package model;

public class ParteDeNave {
	
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

}
