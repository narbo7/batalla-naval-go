package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Lancha;


import org.junit.Test;

public class TestsLancha extends TestCase{

	@Test
	public void testUnaLanchaDeberiaCrearseConDosPosiciones() {
		
		Lancha lancha = new Lancha();
		
		assertTrue((lancha.getCantidadDePosiciones()) == 2);

	}

	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Lancha lancha = new Lancha();
		Disparo disparo = new Disparo(lancha.getPosicion());
		
		disparo.atacar(lancha);
		
		assertTrue((lancha.getResistencia()) == 1);
		
	}
}
