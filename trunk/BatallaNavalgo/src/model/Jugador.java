package model;

public class Jugador {

	private int puntaje;

	private Bomba bombaSeleccionada;

	public Jugador(){
        this.puntaje = 100000;
	}

	public Bomba dispararBomba() {
		Bomba bomba2 = bombaSeleccionada;
		if(bombaSeleccionada!=null){
			this.descontarPuntaje(this.bombaSeleccionada.getCosto());
			bomba2 = bombaSeleccionada;
			this.bombaSeleccionada=null;
		}
		return bomba2;
	}
	
	public void seleccionarBomba(Bomba unaBomba){
		System.out.println("La bomba seleccionada es ...");
		this.bombaSeleccionada= unaBomba;
		System.out.println(unaBomba.toString());
	}
	
	public int getPuntaje() {
		return puntaje;
	}

	private void setPuntaje(int unPuntaje) {
		this.puntaje = unPuntaje;
	}
	
	public void descontarPuntaje(int costo){
		int nuevoPuntaje = getPuntaje();   
		nuevoPuntaje -= costo;
		setPuntaje(nuevoPuntaje);
	}

}
