package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Posicion;

import org.junit.Test;

public class TestsDisparo extends TestCase {

	@Test
	public void testUnDisparoPoseeUnCostoDe200Puntos() {
		
		Posicion posicion = new Posicion();
		Disparo disparo = new Disparo(posicion);
		
		assertTrue((disparo.getCosto()) == 200);
		
	}

}
