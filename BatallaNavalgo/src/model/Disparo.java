package model;

import java.util.LinkedList;

import view.VistaElementoDelJuego;


public class Disparo extends Bomba{

	public Disparo() {
		super();
		this.costo = 200;
		this.estaExplotada = false;
	}

	public Disparo(Posicion posicion) {
		super(posicion);
		this.costo = 200;
		this.estaExplotada = false;
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
	public void vivir() {
		// TODO Auto-generated method stub
		
	}


}
