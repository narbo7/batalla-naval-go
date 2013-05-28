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
		
		Posicion miPosicion = getPosicion(); 
		Posicion proa = miPosicion;
		Posicion popa = miPosicion;
		Posicion medio = miPosicion;
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				proa.setColumna(miPosicion.getColumna() + 2);
				medio.setColumna(miPosicion.getColumna() + 1);
				popa.setColumna(miPosicion.getColumna() - 1);
				break;
		case 2: //Vertical
				proa.setFila(miPosicion.getFila() + 2);
				medio.setFila(miPosicion.getFila() + 1);
				popa.setFila(miPosicion.getFila() - 1);
				break;
		}
		
		agregarPosicion(proa);
		agregarPosicion(popa);
		agregarPosicion(medio);
	}

}
