package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observer;
import java.util.Random;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public abstract class Nave extends ElementoDelJuego implements ObjetoMovil, ObjetoVivo, ObjetoPosicionable,Observer{
	
	//protected int resistencia;
	protected int ubicacion;
	//LinkedList<Posicion> posiciones;
	LinkedList<ParteDeNave> partes;
	private boolean dirArriba, dirAbajo, dirIzquierda, dirDerecha;
	
	public Nave(){
		
		super();
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.partes = new LinkedList<ParteDeNave>();
		//Por defecto cada ParteDeNave tiene resisntecia 1
		this.partes.add(new ParteDeNave(getPosicion(), 1));
		//this.posiciones = new LinkedList<Posicion>();
		//this.posiciones.add(getPosicion());
		this.generarDireccion();
	}
	
	//Solo para tests
	public Nave(Posicion posicion){
		
		super(posicion);
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.partes = new LinkedList<ParteDeNave>();
		//Por defecto cada ParteDeNave tiene resisntecia 1
		this.partes.add(new ParteDeNave(posicion, 1));
		//this.posiciones = new LinkedList<Posicion>();
		//this.posiciones.add(getPosicion());
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

	public int getResistenciaTotal(){
		
		int resistenciaTotal = 0;
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			resistenciaTotal += it.next().getResistencia();
		
		return resistenciaTotal;
	}
		public int getUbicacion(){		
		return this.ubicacion;		
	}
	
	public LinkedList<ParteDeNave> getPartes(){
		return this.partes;
	}
	
	public void agregarParte(ParteDeNave parte){
		this.partes.add(parte);
	}
	
	public int getCantidadDePartes(){
		return this.partes.size();
	}
	
	/*public LinkedList<Posicion> getPosiciones(){
		return this.posiciones;
	}
	
	public void agregarPosicion(Posicion posicion){
		
		this.posiciones.add(posicion);
	}
	
	public int getCantidadDePosiciones(){
		
		return this.posiciones.size();
	}*/
	
	public abstract void determinarPosiciones();
	
	public abstract void serAtacadoPor(Disparo disparo);
	
	
	public void mover(){
		for(ParteDeNave parteDeNave: this.partes){
			if(this.getDirArriba()) {
				if(parteDeNave.getPosicion().getFila() == 1) {
					this.setDirArriba(false);
					this.setDirAbajo(true);
					} else {
						parteDeNave.getPosicion().setFila(parteDeNave.getPosicion().getFila()-1);
					}
			}
			
			if(this.getDirAbajo()) {
				if(parteDeNave.getPosicion().getFila() == Tablero.getMaxFila()) {
					this.setDirArriba(true);
					this.setDirAbajo(false);
				} else {
					parteDeNave.getPosicion().setFila(parteDeNave.getPosicion().getFila()+1);
				}
			}
			
			if(this.getDirDerecha()){
				if(parteDeNave.getPosicion().getColumna() == Tablero.getMaxColumna()) {
					this.setDirDerecha(false);
					this.setDirIzquierda(true);
				} else {
					parteDeNave.getPosicion().setColumna(parteDeNave.getPosicion().getColumna()+1);
				}
			}
			
			if(this.getDirIzquierda()){
				if(parteDeNave.getPosicion().getColumna() == 1) {
					this.setDirDerecha(true);
					this.setDirIzquierda(false);
				} else {
					parteDeNave.getPosicion().setColumna(parteDeNave.getPosicion().getColumna()-1);
				}
			}
		}
	}
	
	public boolean getDirArriba() { return this.dirArriba;}
	
	public void setDirArriba(boolean x) { this.dirArriba = x;}
	
	public boolean getDirAbajo() { return this.dirAbajo;}
	
	public void setDirAbajo(boolean x) { this.dirAbajo = x;}
	
	public boolean getDirDerecha() { return this.dirDerecha;}
	
	public void setDirDerecha(boolean x) { this.dirDerecha = x;}
	
	public boolean getDirIzquierda() { return this.dirIzquierda;}
	
	public void setDirIzquierda(boolean x) { this.dirIzquierda = x;}
	
	public Posicion evaluarPosicion(Posicion posicion){
		
		Posicion nuevaPos = new Posicion(posicion.getFila(), posicion.getColumna());
		boolean huboCambioFil = false;
		boolean huboCambioCol = false;
		int miFila = nuevaPos.getFila();
		int miColumna = nuevaPos.getColumna();
		
		if ((miFila) == 1){
			nuevaPos.setFila(miFila + 2);
			huboCambioFil = true;
		} else {
			if ((miFila) == Tablero.maxFila)
				nuevaPos.setFila(miFila - 2);
				huboCambioFil = true;
		}
		
		if ((miColumna) == 1){
			nuevaPos.setColumna(miColumna + 2);
			huboCambioCol = true;
		} else {
			if((miColumna) == Tablero.maxColumna)
				nuevaPos.setColumna(miColumna - 2);
				huboCambioCol = true;
		}
		
		if ((huboCambioFil) || (huboCambioCol)){
			this.partes.removeFirst();
			ParteDeNave parte = new ParteDeNave(nuevaPos, 1);
			agregarParte(parte);
			setPosicion(nuevaPos);
		}	
		
		return nuevaPos;
	}
		
	

}
