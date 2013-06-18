package model;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import view.VentanaPrincipal;
import view.VistaBomba;
import view.VistaElementoDelJuego;
import view.VistaNave;

public abstract class Bomba extends ElementoDelJuego implements ObjetoPosicionable{


		protected int costo;

		public Bomba(){
			super();
		}
		public Bomba(Posicion posicion){
			super(posicion);
		}

		public int getCosto(){
			return this.costo;
		}

		public abstract void atacar(Lancha lancha);

		public abstract void atacar(Destructor destrunctor);

		public abstract void atacar(Buque buque);

		public abstract void atacar(Portaavion portaavion);

		public abstract void atacar(Rompehielo rompehielo);

		public abstract Bomba copy();
		
		//TODO: Modificar esta llamada a otro paquete, deberia ser un observador.
		public VistaElementoDelJuego generarVista(){
			return new VistaBomba(this);
		}
		@Override
		public int getX() {
			return (this.getPosicion().getColumna() + (this.getPosicion().getColumna()-1)*VentanaPrincipal.getAumentoVentana());
		}

		@Override
		public int getY() {
			return (this.getPosicion().getFila() + (this.getPosicion().getFila()-1)*VentanaPrincipal.getAumentoVentana()); 

		}

}
