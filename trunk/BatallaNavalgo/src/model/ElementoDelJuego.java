package model;


public class ElementoDelJuego {
	
	
	private Posicion posicion;
	
	public ElementoDelJuego(){
		
		this.posicion = new Posicion();
	}
	
	public ElementoDelJuego(Posicion unaPosicion){
		
		this.posicion = unaPosicion;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

}
