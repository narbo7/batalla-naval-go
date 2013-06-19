package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import view.VistaBuque;
import view.VistaElementoDelJuego;
import view.VistaLancha;
import view.VistaNave;

public class Buque extends Nave implements Atacable{

	static final int MAXIMA_RESISTENCIA = 4;
	
	public Buque(){
		super();
		determinarPosiciones();
	}
	
	public Buque(Posicion posicion){
		super(posicion);
		determinarPosiciones();
	}
	
	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos2 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos3 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				pos1.setColumna(pos1.getColumna() + 2);
				pos2.setColumna(pos2.getColumna() + 1);
				pos3.setColumna(pos3.getColumna() - 1);
				break;
		case 2: //Vertical
				pos1.setFila(pos1.getFila() + 2);
				pos2.setFila(pos2.getFila() + 1);
				pos3.setFila(pos3.getFila() - 1);
				break;
		}
		
		ParteDeNave parte1 = new ParteDeNave(pos1, 1);
		ParteDeNave parte2 = new ParteDeNave(pos2, 1);
		ParteDeNave parte3 = new ParteDeNave(pos3, 1);
		agregarParte(parte1);
		agregarParte(parte2);
		agregarParte(parte3);

	}

	@Override
	public void serAtacadoPor(Disparo disparo) {
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next().getPosicion())))
				it.next().reducirResistencia(MAXIMA_RESISTENCIA);
	}

	public void serAtacadoPor(MinaConRetardo minaConRetardo) {
		
		if(minaConRetardo.getRetardo() == 0){
			for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
				if ((minaConRetardo.getPosicion().esIgualA(it.next().getPosicion())))
					it.next().reducirResistencia(MAXIMA_RESISTENCIA);
		}
		
	}

	public void serAtacadoPor(MinaDobleConRetardo minaDobleConRetardo) {

	}

	public void serAtacadoPor(MinaTripleConRetardo minaTripleConRetardo) {
		// TODO Auto-generated method stub
		
	}
	
	public void serAtacadoPor(MinaPorContacto minaPorContacto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<VistaElementoDelJuego> generarVista() {
		LinkedList<VistaElementoDelJuego> listaVistas = new LinkedList<VistaElementoDelJuego>();
		for (ParteDeNave unaParte : this.getPartes()){
			listaVistas.add(new VistaBuque(unaParte));
		}
		return listaVistas;
	}


}
