package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Rompehielo;

import org.junit.Test;

public class TestsRompehielo extends TestCase {

	@Test
	public void testUnRompehieloDeberiaCrearseConTresPosiciones() {
		
		Rompehielo rompehielo = new Rompehielo();
		
		assertTrue((rompehielo.getCantidadDePosiciones()) == 3);
			
	}
	
	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Rompehielo rompehielo = new Rompehielo();
		Disparo disparo = new Disparo(rompehielo.getPosicion());
		
		disparo.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistencia()) == 5);
	}

}
