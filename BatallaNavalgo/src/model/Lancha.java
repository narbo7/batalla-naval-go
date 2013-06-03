package model;

import java.util.Iterator;

public class Lancha extends Nave implements Atacable{
	
	static final int MAXIMA_RESISTENCIA = 2;
	
	public Lancha(){		
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
