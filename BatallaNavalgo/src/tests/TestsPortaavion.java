package tests;

import junit.framework.TestCase;

import model.Portaavion;

import org.junit.Test;

public class TestsPortaavion extends TestCase {

	@Test
	public void testUnPortaavionesDeberiaCrearseConCincoPosiciones() {
		
		Portaavion portaavion = new Portaavion();
		
		assertTrue((portaavion.getCantidadDePosiciones()) == 5);
		
	}

}
