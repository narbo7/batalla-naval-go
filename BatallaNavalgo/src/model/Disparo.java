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
	public void vivir() {

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
	
	@Override
	public void atacar(Nave unaNave) {
		unaNave.serAtacadoPor(this);
		
	}

}
