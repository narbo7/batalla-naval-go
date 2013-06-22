package tests;

import junit.framework.TestCase;

import model.Buque;
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
	
	@Test
	public void testUnDisparoDeberiaExplotarAunqueNoHayaColisionadoConAlgunaNave(){
		
		Buque buque = new Buque(new Posicion(5,5));
		Disparo disparo = new Disparo(new Posicion(2,2));
		
		disparo.atacar(buque);
		
		assertTrue(disparo.estaExplotada());
	}

}
