package model;

public class Portaavion extends Nave{
	
	public Portaavion(){
		super();
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

}
