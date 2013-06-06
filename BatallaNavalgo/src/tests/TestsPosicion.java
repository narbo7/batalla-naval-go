package tests;

import static org.junit.Assert.*;


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
	public void testEsIgualA(){
		
		Posicion unaPosicion = new Posicion(1,10);
		Posicion otraPosicion = new Posicion(1,10);
		
		assertTrue(unaPosicion.esIgualA(otraPosicion));
		
		otraPosicion = new Posicion(7,8);
		assertFalse(unaPosicion.esIgualA(otraPosicion));
	}
	


}
