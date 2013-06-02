package model;

import java.util.LinkedList;
import java.util.Random;

public abstract class Nave extends ElementoDelJuego {
	
	protected int resistencia;
	protected int ubicacion;
	LinkedList<Posicion> posiciones;
	private boolean dirArriba, dirAbajo, dirIzquierda, dirDerecha;
	
	public Nave(){
		
		super();
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.posiciones = new LinkedList<Posicion>();
		this.posiciones.add(getPosicion());
		this.generarDireccion();
	}

	private void generarDireccion() {
		Random random = new Random();
		
		this.setDirArriba(random.nextBoolean()); //Defino si voy o no para arriba
		this.setDirDerecha(random.nextBoolean()); //Defino si voy o no para la derecha
		
		if (this.getDirArriba()){ //Voy para arriba?
			this.setDirAbajo(false); //Entonces no voy para abajo
			if (this.getDirDerecha()){ //Voy para la derecha?
				this.setDirIzquierda(false); //Entonces no voy para la izquierda
			} else { // No voy para la derecha?
				this.setDirIzquierda(random.nextBoolean()); // Entonces defino si voy o no para la izquierda
			}
		} else { //No voy para arriba?
			this.setDirAbajo(random.nextBoolean()); // Entonces defino si voy o no para abajo
			if (this.getDirDerecha()) { //Voy para la derecha?
				this.setDirIzquierda(false); //Entonces no voy para la izquierda
			} else { //No voy para la derecha?
				this.setDirIzquierda(random.nextBoolean()); //Entonces defino si voy o no para la izquierda
			}
		}
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
	
	public void mover(){
		
	}
	
	public boolean getDirArriba() { return this.dirArriba;}
	
	public void setDirArriba(boolean x) { this.dirArriba = x;}
	
	public boolean getDirAbajo() { return this.dirAbajo;}
	
	public void setDirAbajo(boolean x) { this.dirAbajo = x;}
	
	public boolean getDirDerecha() { return this.dirDerecha;}
	
	public void setDirDerecha(boolean x) { this.dirDerecha = x;}
	
	public boolean getDirIzquierda() { return this.dirIzquierda;}
	
	public void setDirIzquierda(boolean x) { this.dirIzquierda = x;}
	
		
	

}
