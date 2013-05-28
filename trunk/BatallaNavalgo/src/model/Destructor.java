package model;

public class Destructor extends Nave {

	
	
	public Destructor(){		
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
		
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				proa.setColumna(proa.getColumna() + 1);
				popa.setColumna(popa.getColumna() - 1);
				break;
		case 2: //Vertical
				proa.setFila(proa.getFila() + 1);
				popa.setFila(popa.getFila() - 1);
				break;
		}
		
		agregarPosicion(proa);
		agregarPosicion(popa);
		
	}

}
