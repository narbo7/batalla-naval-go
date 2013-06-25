package model;

import java.io.IOException;

import view.VistaBomba;
import view.VistaDisparo;

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

	@Override
	public VistaBomba generarVistaBomba() {
		VistaDisparo vista = null;
		try{
			vista = new VistaDisparo(this);
		}catch(IOException e ){
			System.out.println(e.getMessage());
		}
		return vista;
	}


}
