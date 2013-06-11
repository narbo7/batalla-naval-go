package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observer;
import java.util.Random;

import view.VentanaPrincipal;
import view.VistaNave;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.ObjetoVivo;

public abstract class Nave extends ElementoDelJuego implements ObjetoMovil, ObjetoVivo, ObjetoPosicionable,Observer{
	
	protected int ubicacion;
	LinkedList<ParteDeNave> partes;
	private boolean dirArriba, dirAbajo, dirIzquierda, dirDerecha;
	
	public Nave(){
		
		super();
		this.ubicacion = RandomInt.generarRandomEntre(1, 2);
		this.partes = new LinkedList<ParteDeNave>();
		//Por defecto cada ParteDeNave tiene resisntecia 1
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
	
	
	public void mover(){
		
		boolean darLaVuelta = false;
		
		for(ParteDeNave parteDeNave: this.partes){
		
			if(this.getDirArriba()) {
				if(parteDeNave.getPosicion().getFila() == 1) {
					darLaVuelta = true;
					this.setDirArriba(false);
					this.setDirAbajo(true);
					} else {
						if (!darLaVuelta)parteDeNave.getPosicion().setFila(parteDeNave.getPosicion().getFila()-1);
					}
			}
			
			if(this.getDirAbajo()) {
				if(parteDeNave.getPosicion().getFila() == Tablero.getMaxFila()) {
					darLaVuelta = true;
					this.setDirArriba(true);
					this.setDirAbajo(false);
				} else {
					if (!darLaVuelta) parteDeNave.getPosicion().setFila(parteDeNave.getPosicion().getFila()+1);
				}
			}
			
			if(this.getDirDerecha()){
				if(parteDeNave.getPosicion().getColumna() == Tablero.getMaxColumna()) {
					darLaVuelta = true;
					this.setDirDerecha(false);
					this.setDirIzquierda(true);
				} else {
					if (!darLaVuelta) parteDeNave.getPosicion().setColumna(parteDeNave.getPosicion().getColumna()+1);
				}
			}
			
			if(this.getDirIzquierda()){
				if(parteDeNave.getPosicion().getColumna() == 1) {
					darLaVuelta = true;
					this.setDirDerecha(true);
					this.setDirIzquierda(false);
				} else {
					if (!darLaVuelta) parteDeNave.getPosicion().setColumna(parteDeNave.getPosicion().getColumna()-1);
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
		
	public abstract VistaNave generarVista();
	
	@Override
	public int getX() {
		return (this.getPosicion().getColumna() + (this.getPosicion().getColumna()-1)*VentanaPrincipal.getAumentoVentana());
	}

	@Override
	public int getY() {
		return (this.getPosicion().getFila() + (this.getPosicion().getFila()-1)*VentanaPrincipal.getAumentoVentana()); 

	}
	
	public void vivir () {
		System.out.println("Estoy en x:" + this.getPosicion().getColumna() + " y:" +this.getPosicion().getFila());
		this.mover();
	}

}
