package model;

public class Destructor extends Nave {

	
	
	public Destructor(){		
		super();		
	}
	
	@Override
	public void determinarPosiciones() throws ErrorFueraDeRango {
		
		Posicion miPosicion = getPosicion(); 
		Posicion proa = miPosicion;
		Posicion popa = miPosicion;
		
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				proa.setColumna(miPosicion.getColumna() + 1);
				popa.setColumna(miPosicion.getColumna() - 1);
				break;
		case 2: //Vertical
				proa.setFila(miPosicion.getFila() + 1);
				popa.setFila(miPosicion.getFila() - 1);
				break;
		}
		
		agregarPosicion(proa);
		agregarPosicion(popa);
		
	}

}
