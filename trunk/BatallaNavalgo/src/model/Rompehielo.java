package model;

import java.util.Iterator;
import java.util.Observable;

import view.VistaNave;
import view.VistaRompehielo;

public class Rompehielo extends Nave implements Atacable{

	static final int MAXIMA_RESISTENCIA = 6;
	
	public Rompehielo(){
		super();
		determinarPosiciones();
		
	}
	
	public Rompehielo(Posicion posicion){
		super(posicion);
		determinarPosiciones();
		
	}
	
	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos2 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		//Modifico la resitencia de la parte por defaul ya que vale 2
		getPartes().getFirst().setResistencia(2);
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				pos1.setColumna(pos1.getColumna() + 1);
				pos2.setColumna(pos2.getColumna() - 1);
				break;
		case 2: //Vertical
				pos1.setFila(pos1.getFila() + 1);
				pos2.setFila(pos2.getFila() - 1);
				break;
		}
		
		ParteDeNave parte1 = new ParteDeNave(pos1, 2);
		ParteDeNave parte2 = new ParteDeNave(pos2, 2);
		agregarParte(parte1);
		agregarParte(parte2);
		
	}

	@Override
	public void serAtacadoPor(Disparo disparo) {		
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next().getPosicion())))
				it.next().reducirResistencia(1);
	}

	public void serAtacadoPor(MinaConRetardo minaConRetardo) {

		if(minaConRetardo.getRetardo() == 0){
			for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
				if ((minaConRetardo.getPosicion().esIgualA(it.next().getPosicion())))
					it.next().reducirResistencia(1);
		}
	}

	public void serAtacadoPor(MinaDobleConRetardo minaDobleConRetardo) {
		// TODO Auto-generated method stub
		
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
	public VistaNave generarVista() {
		return new VistaRompehielo(this);
	}



}
