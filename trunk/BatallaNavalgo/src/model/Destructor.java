package model;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;

import view.VistaDestructor;
import view.VistaElementoDelJuego;


public class Destructor extends Nave implements Atacable{

	static final int RESISTENCIA_MAXIMA = 3;
	
	public Destructor(){		
		super();		
		determinarPosiciones();

	}
	
	//Solo para tests
	public Destructor(Posicion posicion){		
		super(posicion);		
		determinarPosiciones();

	}
	
	@Override
	public void determinarPosiciones(){
		
		Posicion miPosicion = evaluarPosicion(getPosicion());
		Posicion pos1 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		Posicion pos2 = new Posicion(miPosicion.getFila(), miPosicion.getColumna());
		
		
		switch (getUbicacion()){		
		case 1: //Horizontal
				pos1.setColumna(pos1.getColumna() + 1);
				pos2.setColumna(pos2.getColumna() - 1);
				break;
		case 2: //Vertical
				pos1.setFila(pos1.getFila() + 1);
				pos2.setFila(pos2.getFila() - 1);
				break;
		}
		
		ParteDeNave parte1 = new ParteDeNave(pos1, 1);
		ParteDeNave parte2 = new ParteDeNave(pos2, 1);
		agregarParte(parte1);
		agregarParte(parte2);
		
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
		//NO LE PROVOCA DANIO
		
	}

	public void serAtacadoPor(MinaDobleConRetardo minaDobleConRetardo) {
		//NO LE PROVOCA DANIO
		
	}

	public void serAtacadoPor(MinaTripleConRetardo minaTripleConRetardo) {
		//NO LE PROVOCA DANIO
		
	}

	public void serAtacadoPor(MinaPorContacto minaPorContacto) {
		//NO LE PROVOCA DANIO
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<VistaElementoDelJuego> generarVista() {
		LinkedList<VistaElementoDelJuego> listaVistas = new LinkedList<VistaElementoDelJuego>();
		try{
		for (ParteDeNave unaParte : this.getPartes()){
			listaVistas.add(new VistaDestructor(unaParte));
		}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return listaVistas;
	}


}
