package model;


public class MinaTripleConRetardo extends Bomba{
	
	public MinaTripleConRetardo() {
		super();
		this.costo = 125;
	}

	public MinaTripleConRetardo(Posicion posicion) {
		super(posicion);
		this.costo = 125;
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
        return new MinaTripleConRetardo(this.getPosicion());
    }

	@Override
	public void vivir() {
		// TODO Auto-generated method stub
		
	}
}
