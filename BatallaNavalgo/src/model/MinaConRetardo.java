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
	
	@Override
	public void atacar(Nave unaNave) {
		unaNave.serAtacadoPor(this);
		
	}

}
