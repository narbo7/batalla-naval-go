package model;

public class Lancha extends Nave {
	
	
	public Lancha(){		
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
		Posicion popa = miPosicion;
		
		switch(getUbicacion()){
		case 1: //Horizontal
				popa.setColumna(miPosicion.getColumna() - 1);
				break;
		case 2: //Vertical
				popa.setFila(miPosicion.getFila() - 1);
				break;			
		}
		
		agregarPosicion(popa);
		
	}
	
	

}
