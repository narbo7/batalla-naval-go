package model;



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
	public Bomba copy() {
        return new MinaConRetardo(this.getPosicion());
    }


	@Override
	public void vivir() {
		if ((getRetardo()) != 0)
			descontarRetardo();
		
	}

}
