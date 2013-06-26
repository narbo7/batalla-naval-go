package model;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import view.VistaElementoDelJuego;
import view.VistaPortaAvion;

public class Portaavion extends Nave implements Atacable{
	
	static final int MAXIMA_RESISTENCIA = 5;
	
	public Portaavion(){
		super();
		determinarPosiciones();
	}

	public Portaavion(Posicion posicion){
		super(posicion);
		determinarPosiciones();
	}

	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos2 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos3 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos4 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				pos1.setColumna(pos1.getColumna() + 2);
				pos2.setColumna(pos2.getColumna() + 1);
				pos3.setColumna(pos3.getColumna() - 1);
				pos4.setColumna(pos4.getColumna() - 2);
				break;
		case 2: //Vertical
				pos1.setFila(pos1.getFila() + 2);
				pos2.setFila(pos2.getFila() + 1);
				pos3.setFila(pos3.getFila() - 1);
				pos4.setFila(pos4.getFila() - 2);
				break;
		}
		
		ParteDeNave parte1 = new ParteDeNave(pos1, 1);
		ParteDeNave parte2 = new ParteDeNave(pos2, 1);
		ParteDeNave parte3 = new ParteDeNave(pos3, 1);
		ParteDeNave parte4 = new ParteDeNave(pos4, 1);
		agregarParte(parte1);
		agregarParte(parte2);
		agregarParte(parte3);
		agregarParte(parte4);
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
		try{int i = 1;
		for (ParteDeNave unaParte : this.getPartes()){
			listaVistas.add(new VistaPortaAvion(unaParte,this.getUbicacion(),i));
			i++;
		}
		}catch(IOException e ){
			System.out.println(e.getMessage());
		}
		return listaVistas;
	}

}
