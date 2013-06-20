package model;

import java.util.LinkedList;


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
	public void atacar(Lancha lancha) {
		lancha.serAtacadoPor(this);
	}

	@Override
	public void atacar(Destructor destructor) {
		destructor.serAtacadoPor(this);
	}

	@Override
	public void atacar(Buque buque) {
		buque.serAtacadoPor(this);
	}

	@Override
	public void atacar(Portaavion portaavion) {
		portaavion.serAtacadoPor(this);
	}

	@Override
	public void atacar(Rompehielo rompehielo) {
		rompehielo.serAtacadoPor(this);
	}

	@Override
	public Bomba copy() {
        return new MinaDobleConRetardo(this.getPosicion());
    }

	@Override
	public void vivir() {
		if ((getRetardo()) != 0)
			descontarRetardo();
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


}
