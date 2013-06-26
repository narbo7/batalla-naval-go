package model;

import java.io.IOException;
import java.util.LinkedList;

import view.VistaBomba;
import view.VistaMina;


public class MinaTripleConRetardo extends Bomba implements Expandible{
	
	private LinkedList<Posicion> ondaExpansiva;
	
	public MinaTripleConRetardo() {
		super();
		this.costo = 125;
		this.retardo = 3;
		this.ondaExpansiva = new LinkedList<Posicion>();
		this.estaExplotada = false;
		generarOndaExpansiva(getPosicion());		
	}

	public MinaTripleConRetardo(Posicion posicion) {
		super(posicion);
		this.costo = 125;
		this.retardo = 3;
		this.ondaExpansiva = new LinkedList<Posicion>();
		this.estaExplotada = false;
		generarOndaExpansiva(posicion);
		
	}

	public LinkedList<Posicion> getOndaExpansiva(){
		return this.ondaExpansiva;
	}

	@Override
	public void vivir() {
		if ((getRetardo()) != 0) { descontarRetardo();} else {this.explotar();}
		}

	public int getTamanioOndaExpansiva(){
		return this.ondaExpansiva.size();
	}

	@Override
	public void generarOndaExpansiva(Posicion posicion) {
		
		int valorFinalX = getPosicion().getFila() + 2;
		int valorFinalY = getPosicion().getColumna() + 2;
		
		for (int valorX = getPosicion().getFila() - 2; valorX <= valorFinalX; valorX++ ){
			for (int valorY = getPosicion().getColumna() - 2; valorY <= valorFinalY; valorY++ ){
				this.ondaExpansiva.add(new Posicion(valorX, valorY));
			}
		}
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
