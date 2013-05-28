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
		
		Posicion popa = new Posicion(getPosicion().getFila(), getPosicion().getColumna());
		
		switch(getUbicacion()){
		case 1: //Horizontal
				popa.setColumna(popa.getColumna() - 1);
				break;
		case 2: //Vertical
				popa.setFila(popa.getFila() - 1);
				break;			
		}
		
		agregarPosicion(popa);
		
	}
	
	

}
