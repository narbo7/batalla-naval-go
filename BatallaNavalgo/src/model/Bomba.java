package model;

public abstract class Bomba extends ElementoDelJuego implements Cloneable {


		protected int costo;

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

}
