package tests;

import junit.framework.TestCase;
import model.ElementoDelJuego;
import org.junit.Test;

public class TestsElementoDelJuego extends TestCase {

	@Test
	public void testUnElemendoDelJuegoDeberiaCrearseDentroDeLosLimitesDelTablero() {
		
		ElementoDelJuego unElemento = new ElementoDelJuego();
		
		assertTrue(unElemento.getPosicion().getFila() <= 10);
		assertTrue(unElemento.getPosicion().getColumna()<= 10);		
		
	}

}
