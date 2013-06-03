package model;

import java.util.Iterator;

public class Buque extends Nave implements Atacable{

	static final int MAXIMA_RESISTENCIA = 4;
	
	public Buque(){
		super();
		this.resistencia = MAXIMA_RESISTENCIA;
		try {
			determinarPosiciones();
		} catch (ErrorFueraDeRango e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void determinarPosiciones() throws ErrorFueraDeRango {
		
		Posicion proa = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		Posicion popa = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		Posicion medio = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				proa.setColumna(proa.getColumna() + 2);
				medio.setColumna(medio.getColumna() + 1);
				popa.setColumna(popa.getColumna() - 1);
				break;
		case 2: //Vertical
				proa.setFila(proa.getFila() + 2);
				medio.setFila(medio.getFila() + 1);
				popa.setFila(popa.getFila() - 1);
				break;
		}
		
		agregarPosicion(proa);
		agregarPosicion(popa);
		agregarPosicion(medio);
	}

	@Override
	public void serAtacadoPor(Disparo disparo) {
		for (Iterator<Posicion> it = getPosiciones().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next())))
					reducirResistencia(MAXIMA_RESISTENCIA);
		
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
