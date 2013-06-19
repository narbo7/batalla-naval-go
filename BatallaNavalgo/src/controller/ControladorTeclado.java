package controller;

import model.Bomba;
import model.Disparo;
import model.MinaConRetardo;
import model.MinaDobleConRetardo;
import model.MinaPorContacto;
import model.MinaTripleConRetardo;

public class ControladorTeclado {
	public ControladorTeclado(){}
	public Bomba getBombaAsociadaATecla(char key){
		Bomba unaBomba = null;
		switch(key){
		case '1': unaBomba = new Disparo();
				  break;
		case '2': unaBomba = new MinaConRetardo();
				  break;
		case '3': unaBomba = new MinaDobleConRetardo();
				  break;
		case '4': unaBomba = new MinaPorContacto();
		          break;
		case '5': unaBomba = new MinaTripleConRetardo();
				  break;
	    default : //no hay mas bombas. Lanzar excepcion que la vista podria mostrar un mensaje.
		}
		return unaBomba;
		
	}
}
