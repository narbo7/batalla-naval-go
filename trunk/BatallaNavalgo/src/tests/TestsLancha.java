package tests;

import junit.framework.TestCase;

import model.Lancha;

import org.junit.Test;

public class TestsLancha extends TestCase{

	@Test
	public void testUnaLanchaDeberiaCrearseConDosPosiciones() {
		
		Lancha lancha = new Lancha();
		
		assertTrue((lancha.getCantidadDePosiciones()) == 2);

	}

}
