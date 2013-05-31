package model;

import java.util.LinkedList;

public abstract class Nave extends ElementoDelJuego {
	
	protected int resistencia;
	protected int ubicacion;
	LinkedList<Posicion> posiciones;
	
	public Nave(){
		
		super();
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.posiciones = new LinkedList<Posicion>();
		this.posiciones.add(getPosicion());
	}

	public int getResistencia(){
		return this.resistencia;
	}
	public void reducirResistencia(int valor){
		this.resistencia -= valor;
	}
	public int getUbicacion(){		
		return this.ubicacion;		
	}
	
	public LinkedList<Posicion> getPosiciones(){
		return this.posiciones;
	}
	
	public void agregarPosicion(Posicion posicion){
		
		this.posiciones.add(posicion);
	}
	
	public int getCantidadDePosiciones(){
		
		return this.posiciones.size();
	}
	
	public abstract void determinarPosiciones() throws ErrorFueraDeRango;
	
	public abstract void serAtacadoPor(Disparo disparo);
	
	
		
	

}
