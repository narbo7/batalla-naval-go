package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import view.VistaElementoDelJuego;
import view.VistaLancha;



public class Lancha extends Nave implements Atacable{
	
	static final int MAXIMA_RESISTENCIA = 2;
	
	public Lancha(){		
		super();
		determinarPosiciones();

	}
	
	//Solo para test
	public Lancha(Posicion posicion){		
		super(posicion);
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
			
		boolean huboContacto = false;
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			if ((disparo.getPosicion().esIgualA(it.next().getPosicion()))){
				it.next().reducirResistencia(1);
				disparo.explotar();
				huboContacto = true;
			}
		//explota aunque no haya contacto
		if(!(huboContacto))
			disparo.explotar();
	}

	public void serAtacadoPor(MinaConRetardo minaConRetardo) {

		if(minaConRetardo.getRetardo() == 0){
			for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
				if ((minaConRetardo.getPosicion().esIgualA(it.next().getPosicion()))){
					it.next().reducirResistencia(1);
					minaConRetardo.explotar();
				}
		}
	}

	public void serAtacadoPor(MinaDobleConRetardo minaDobleConRetardo) {
		
		if(minaDobleConRetardo.getRetardo() == 0){
			for (Posicion posicion : minaDobleConRetardo.getOndaExpansiva()){
				for (ParteDeNave parte : this.getPartes()){
					if (posicion.esIgualA(parte.getPosicion())){
						parte.reducirResistencia(1);
						minaDobleConRetardo.explotar();
					}
				}
			}
		}	
	}

	public void serAtacadoPor(MinaTripleConRetardo minaTripleConRetardo) {
		
		if(minaTripleConRetardo.getRetardo() == 0){
			for (Posicion posicion : minaTripleConRetardo.getOndaExpansiva()){
				for (ParteDeNave parte : this.getPartes()){
					if (posicion.esIgualA(parte.getPosicion())){
						parte.reducirResistencia(1);
						minaTripleConRetardo.explotar();
					}
				}
			}
		}
	}

	public void serAtacadoPor(MinaPorContacto minaPorContacto) {
		
		for (Iterator<ParteDeNave> it = getPartes().iterator(); it.hasNext();)
			if ((minaPorContacto.getPosicion().esIgualA(it.next().getPosicion()))){
				it.next().reducirResistencia(1);
				minaPorContacto.explotar();
			}
		
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<VistaElementoDelJuego> generarVista() {
		LinkedList<VistaElementoDelJuego> listaVistas = new LinkedList<VistaElementoDelJuego>();
		for (ParteDeNave unaParte : this.getPartes()){
			listaVistas.add(new VistaLancha(unaParte));
		}
		return listaVistas;
	}




}
