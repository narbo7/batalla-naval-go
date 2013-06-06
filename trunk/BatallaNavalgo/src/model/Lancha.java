package model;

import java.util.Iterator;

public class Lancha extends Nave implements Atacable{
	
	static final int MAXIMA_RESISTENCIA = 2;
	
	public Lancha(){		
		super();
		//this.resistencia = MAXIMA_RESISTENCIA;
		determinarPosiciones();

	}
	
	//Solo para test
	public Lancha(Posicion posicion){		
		super(posicion);
		//this.resistencia = MAXIMA_RESISTENCIA;
		determinarPosiciones();
	}
	
	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		
		switch(getUbicacion()){
		case 1: //Horizontal
				pos1.setColumna(pos1.getColumna() - 1);
				break;
		case 2: //Vertical
				pos1.setFila(pos1.getFila() - 1);
				break;			
		}
		
		ParteDeNave parte1 = new ParteDeNave(pos1, 1);
		agregarParte(parte1);
		
	}
	
	@Override
	public void serAtacadoPor(Disparo disparo) {	
			
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next().getPosicion())))
				it.next().reducirResistencia(1);
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
