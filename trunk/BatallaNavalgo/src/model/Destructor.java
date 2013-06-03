package model;

import java.util.Iterator;

public class Destructor extends Nave implements Atacable{

	static final int RESISTENCIA_MAXIMA = 3;
	
	public Destructor(){		
		super();		
		this.resistencia = RESISTENCIA_MAXIMA;
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
