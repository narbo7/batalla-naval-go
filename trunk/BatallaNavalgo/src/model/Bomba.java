package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import view.VentanaPrincipal;
import view.VistaBomba;
import view.VistaElementoDelJuego;

public abstract class Bomba extends ElementoDelJuego implements ObjetoPosicionable{


		protected boolean estaExplotada;
		protected int costo;
		protected int retardo;

		public Bomba(){
			super();
		}
		
		public Bomba(Posicion posicion){
			super(posicion);
		}

		public int getCosto(){
			return this.costo;
		}

		public int getRetardo(){
			return this.retardo;
		}
		
		public void setRetardo(int retardo){
			this.retardo = retardo;
		}
		
		public void descontarRetardo(){
			setRetardo((getRetardo()) - 1);
		}
		
		public void explotar(){
			this.estaExplotada = true;
		}
		
		public boolean estaExplotada(){
			return this.estaExplotada;
		}
		
		public abstract void atacar(Lancha lancha);

		public abstract void atacar(Destructor destrunctor);

		public abstract void atacar(Buque buque);

		public abstract void atacar(Portaavion portaavion);

		public abstract void atacar(Rompehielo rompehielo);
		
		//TODO: Modificar esta llamada a otro paquete, deberia ser un observador.
		public VistaBomba generarVistaBomba() {
			return (new VistaBomba(50, this));
		}
		
		@Override
		public int getX() {
			return (this.getPosicion().getFila() + (this.getPosicion().getFila()-1)*VentanaPrincipal.getAumentoVentana()); 
		}

		@Override
		public int getY() {
			return (this.getPosicion().getColumna() + (this.getPosicion().getColumna()-1)*VentanaPrincipal.getAumentoVentana());
		}

}
