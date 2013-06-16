package model;


public class MinaPorContacto extends Bomba{
	public MinaPorContacto(){
		super();
	}
	public MinaPorContacto(Posicion posicion) {
		super(posicion);
		this.costo = 150;
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
        return new MinaPorContacto(this.getPosicion());
    }

}
