package model;


public class MinaDobleConRetardo extends Bomba{

	public MinaDobleConRetardo(Posicion posicion){
		super(posicion);
		this.costo = 100;
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
        return new MinaDobleConRetardo(this.getPosicion());
    }


}
