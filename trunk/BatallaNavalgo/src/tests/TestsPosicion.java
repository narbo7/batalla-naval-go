package tests;

import static org.junit.Assert.*;

import model.ErrorFueraDeRango;
import model.Posicion;

import org.junit.Test;

public class TestsPosicion {

	@Test
	public void testGenerarCoordenadaEntre() {
		
		Posicion unaPosicion = new Posicion();
		int unaCoordenada = 1;
		int otraCoordenada = 10;
		int coordenadaDePrueba = unaPosicion.generarCoordenadaEntre(unaCoordenada, otraCoordenada);
		
		assertTrue((coordenadaDePrueba >= unaCoordenada) && (coordenadaDePrueba <= otraCoordenada));
	}

	@Test
	public void testEsIgualA() throws ErrorFueraDeRango {
		
		Posicion unaPosicion = new Posicion(1,10);
		Posicion otraPosicion = new Posicion(1,10);
		
		assertTrue(unaPosicion.esIgualA(otraPosicion));
		
		otraPosicion = new Posicion(7,8);
		assertFalse(unaPosicion.esIgualA(otraPosicion));
	}
	
	@Test
	public void testPosicionFueraDeRangoDeberiaLanzarUnaExcepcion() throws ErrorFueraDeRango {
		
		try {			
			
			@SuppressWarnings("unused")
			Posicion unaPosicion = new Posicion(11,3);		
			
		} catch (ErrorFueraDeRango e){
			
		}
	}

}
