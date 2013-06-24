package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observer;
import java.util.Random;

import view.VistaElementoDelJuego;


import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public abstract class Nave extends ElementoDelJuego implements ObjetoMovil, ObjetoPosicionable,Observer{
	
	protected int ubicacion;
	LinkedList<ParteDeNave> partes;
	private boolean dirArriba, dirAbajo, dirIzquierda, dirDerecha;
	
	public Nave(){
		
		super();
		this.posicion = new Posicion();
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.partes = new LinkedList<ParteDeNave>();
		//Por defecto cada ParteDeNave tiene resistencia 1
		this.partes.add(new ParteDeNave(getPosicion(), 1));
		this.generarDireccion();
	}
	
	//Solo para tests
	public Nave(Posicion posicion){
		
		super(posicion);
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.partes = new LinkedList<ParteDeNave>();
		//Por defecto cada ParteDeNave tiene resisntecia 1
		this.partes.add(new ParteDeNave(posicion, 1));
		this.generarDireccion();
	}

	private void generarDireccion() {
		Random random = new Random();
		
		this.setDirArriba(random.nextBoolean());
		this.setDirDerecha(random.nextBoolean()); 
		
		if (this.getDirArriba()){
			this.setDirAbajo(false); 
			if (this.getDirDerecha()){ 
				this.setDirIzquierda(false); 
			} else {
				this.setDirIzquierda(random.nextBoolean());
			}
		} else {
			this.setDirAbajo(random.nextBoolean()); 
			if (this.getDirDerecha()) { 
				this.setDirIzquierda(false);
			} else {
				this.setDirIzquierda(random.nextBoolean()); 
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
	
	public abstract void determinarPosiciones();
	
	public abstract void serAtacadoPor(Disparo disparo);
	
	public boolean hayChoqueContraBordeIzquierdo() {
		boolean flag = false;
		for (ParteDeNave unaParte : this.getPartes()) {
			if(unaParte.getPosicion().getColumna() == 1) {  flag = true;}
		}
		return flag;
	}
	
	public boolean hayChoqueContraBordeDerecho() {
		boolean flag = false;
		for (ParteDeNave unaParte : this.getPartes()) {
			if(unaParte.getPosicion().getColumna() == Tablero.getMaxColumna()) {flag = true;}
		}
		return flag;
	}
	
	public boolean hayChoqueContraBordeInferior() {
		boolean flag = false;
		for (ParteDeNave unaParte : this.getPartes()) {
			if(unaParte.getPosicion().getFila() == Tablero.getMaxFila()) {  flag = true;}
		}
		return flag;
	}
	
	public boolean hayChoqueContraBordeSuperior() {
		boolean flag = false;
		for (ParteDeNave unaParte : this.getPartes()) {
			if(unaParte.getPosicion().getFila() == 1) {  flag = true;}
		}
		return flag;
	}
	
	
	public synchronized void mover(){
		if(this.hayQueCambiarDireccion()) { 
			this.cambiarDireccion();
			this.moverse();
		} else {
			this.moverse();
		}
		
	}
	
	private void moverse() {
		if(this.getDirAbajo()){
			for (ParteDeNave unaParte : this.getPartes()) {
				unaParte.getPosicion().setFila(unaParte.getPosicion().getFila()+1);
			}
		}
		if(this.getDirArriba()){
			for (ParteDeNave unaParte : this.getPartes()) {
				unaParte.getPosicion().setFila(unaParte.getPosicion().getFila()-1);
			}
		}
		if(this.getDirDerecha()){
			for (ParteDeNave unaParte : this.getPartes()) {
				unaParte.getPosicion().setColumna(unaParte.getPosicion().getColumna()+1);
			}
		}
		if(this.getDirIzquierda()){
			for (ParteDeNave unaParte : this.getPartes()) {
				unaParte.getPosicion().setColumna(unaParte.getPosicion().getColumna()-1);
			}
		}
	}

	private void cambiarDireccion() {
		if (this.hayChoqueContraBordeDerecho()){this.setDirDerecha(false); this.setDirIzquierda(true);}
		if (this.hayChoqueContraBordeInferior()){this.setDirAbajo(false); this.setDirArriba(true);}
		if (this.hayChoqueContraBordeIzquierdo()){this.setDirIzquierda(false); this.setDirDerecha(true);}
		if (this.hayChoqueContraBordeSuperior()){this.setDirArriba(false); this.setDirAbajo(true);}
		
	}

	private boolean hayQueCambiarDireccion() {
		boolean flag = false;
		if (hayChoqueContraBordeDerecho()) flag = true;
		if (hayChoqueContraBordeInferior()) flag = true;
		if (hayChoqueContraBordeIzquierdo()) flag = true;
		if (hayChoqueContraBordeSuperior()) flag = true;
		return flag;
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
		
		if (((miFila) == 1) || ((miFila) == 2)){
			nuevaPos.setFila(miFila + 2);
			huboCambioFil = true;
		} else {
			if (((miFila) == Tablero.maxFila) || ((miFila) == (Tablero.maxFila) - 1 ))
				nuevaPos.setFila(miFila - 2);
				huboCambioFil = true;
		}
		
		if (((miColumna) == 1) || ((miColumna) == 2)){
			nuevaPos.setColumna(miColumna + 2);
			huboCambioCol = true;
		} else {
			if(((miColumna) == Tablero.maxColumna) || ((miColumna) == (Tablero.maxColumna) - 1))
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
		
	
	@Override
	public int getX() {
		return this.getPosicion().parametrizarX();
	}

	@Override
	public int getY() {
		return this.getPosicion().parametrizarY();
	}
	
	public void vivir () {
		this.mover();
	}

	public boolean estaHundida() {
		return (this.getResistenciaTotal()==0);
	}

	public abstract LinkedList<VistaElementoDelJuego> generarVista();
}
