package model;

import java.util.Iterator;

public class Portaavion extends Nave{
	
	static final int MAXIMA_RESISTENCIA = 5;
	
	public Portaavion(){
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
		Posicion babor = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		Posicion estribor = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				proa.setColumna(proa.getColumna() + 2);
				babor.setColumna(babor.getColumna() + 1);
				estribor.setColumna(estribor.getColumna() - 1);
				popa.setColumna(popa.getColumna() - 2);
				break;
		case 2: //Vertical
				proa.setFila(proa.getFila() + 2);
				babor.setFila(babor.getFila() + 1);
				estribor.setFila(estribor.getFila() - 1);
				popa.setFila(popa.getFila() - 2);
				break;
		}
		
		agregarPosicion(proa);
		agregarPosicion(popa);
		agregarPosicion(babor);
		agregarPosicion(estribor);
	}

	@Override
	public void serAtacadoPor(Disparo disparo) {
		for (Iterator<Posicion> it = getPosiciones().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next())))
				reducirResistencia(1);	
	}

}
