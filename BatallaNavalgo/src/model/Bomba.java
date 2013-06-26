package model;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import view.VentanaPrincipal;
import view.VistaBomba;

public abstract class Bomba extends ElementoDelJuego implements ObjetoPosicionable{


		protected boolean estaExplotada;
		protected int costo;
		protected int retardo;
		protected VistaBomba observadorBomba = null;

		public Bomba(){
			super();
			this.observadorBomba = this.generarVistaBomba();
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
		
		public abstract void atacar(Nave unaNave);
		
		public abstract VistaBomba generarVistaBomba();
		
		@Override
		public int getX() {
			return (this.getPosicion().getFila() + (this.getPosicion().getFila()-1)*VentanaPrincipal.getAumentoVentana()); 
		}

		@Override
		public int getY() {
			return (this.getPosicion().getColumna() + (this.getPosicion().getColumna()-1)*VentanaPrincipal.getAumentoVentana());
		}

		public VistaBomba getObservadorBomba() {
			return observadorBomba;
		}

		public void setObservadorBomba(VistaBomba vistaBomba) {
			this.observadorBomba = vistaBomba;
		}

}
