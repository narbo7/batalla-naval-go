package model;

public class Buque extends Nave{

	public Buque(){
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

}
