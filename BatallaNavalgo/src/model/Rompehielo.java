package model;

import java.util.Iterator;

public class Rompehielo extends Nave implements Atacable{

	static final int MAXIMA_RESISTENCIA = 6;
	
	public Rompehielo(){
		super();
		this.resistencia = MAXIMA_RESISTENCIA;
		determinarPosiciones();
		
	}
	
	public Rompehielo(Posicion posicion){
		super(posicion);
		this.resistencia = MAXIMA_RESISTENCIA;
		determinarPosiciones();
		
	}
	
	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos2 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		
		
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
		
		agregarPosicion(pos1);
		agregarPosicion(pos2);
		
	}

	@Override
	public void serAtacadoPor(Disparo disparo) {
		
		for (Iterator<Posicion> it = getPosiciones().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next())))
					reducirResistencia(1);	
	}

	public void serAtacadoPor(MinaConRetardo minaConRetardo) {
		// TODO Auto-generated method stub
		
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



}
