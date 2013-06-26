package model;

import java.io.IOException;

import view.VistaBomba;
import view.VistaMina;



public class MinaConRetardo extends Bomba{
	
	public MinaConRetardo() {
		super();
		this.costo = 50;
		this.retardo = 3;
		this.estaExplotada = false;
	}

	public MinaConRetardo(Posicion posicion) {
		super(posicion);
		this.costo = 50;
		this.retardo = 3;
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
		if ((getRetardo()) != 0) {descontarRetardo();} else {this.explotar();}
		
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

}
