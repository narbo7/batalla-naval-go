package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Portaavion;


import org.junit.Test;

public class TestsPortaavion extends TestCase {

	@Test
	public void testUnPortaavionesDeberiaCrearseConCincoPosiciones() {
		
		Portaavion portaavion = new Portaavion();
		
		assertTrue((portaavion.getCantidadDePosiciones()) == 5);
		
	}

	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Portaavion portaavion = new Portaavion();
		Disparo disparo = new Disparo(portaavion.getPosicion());
		
		disparo.atacar(portaavion);
		
		assertTrue((portaavion.getResistencia()) == 4);
	}
}
