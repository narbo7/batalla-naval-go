package model;

import java.io.IOException;
import java.util.LinkedList;

import view.VistaBomba;
import view.VistaMina;


public class MinaDobleConRetardo extends Bomba implements Expandible{
	
	private LinkedList<Posicion> ondaExpansiva;
	
	public MinaDobleConRetardo(){
		super();
		this.costo = 100;
		this.retardo = 3;
		this.ondaExpansiva = new LinkedList<Posicion>();
		this.estaExplotada = false;
		generarOndaExpansiva(getPosicion());
	}


	public MinaDobleConRetardo(Posicion posicion){
		super(posicion);
		this.costo = 100;
		this.retardo = 3;
		this.ondaExpansiva = new LinkedList<Posicion>();
		this.estaExplotada = false;
		generarOndaExpansiva(posicion);		
	}
	
	@Override
	public void vivir() {
		if ((getRetardo()) != 0) { descontarRetardo();} else {this.explotar();}
	}

	public LinkedList<Posicion> getOndaExpansiva(){
		return this.ondaExpansiva;
	}
	
	@Override
	public void generarOndaExpansiva(Posicion posicion) {
		
		int valorFinalX = getPosicion().getFila() + 1;
		int valorFinalY = getPosicion().getColumna() + 1;
		
		for (int valorX = getPosicion().getFila() - 1; valorX <= valorFinalX; valorX++ ){
			for (int valorY = getPosicion().getColumna() - 1; valorY <= valorFinalY; valorY++ ){
				this.ondaExpansiva.add(new Posicion(valorX, valorY));
			}
		}
		
	}
	
	public int getTamanioOndaExpansiva(){
		return this.ondaExpansiva.size();
	}


	@Override
	public VistaBomba generarVistaBomba() {
		VistaMina vista = null;
		try{
			vista = new VistaMina(this);
		}catch(IOException e ){
			System.out.println(e.getMessage());
		}
		return vista;

	}
	
	@Override
	public void atacar(Nave unaNave) {
		unaNave.serAtacadoPor(this);
		
	}

}
