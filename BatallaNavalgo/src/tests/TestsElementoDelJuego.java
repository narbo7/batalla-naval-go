package tests;

import junit.framework.TestCase;
import model.Destructor;
import model.Nave;

import org.junit.Test;

public class TestsElementoDelJuego extends TestCase {

	@Test
	public void testUnaNaveDeberiaCrearseDentroDeLosLimitesDelTablero() {
		
		Nave unElemento = new Destructor();
		
		assertTrue(unElemento.getPosicion().getFila() <= 10);
		assertTrue(unElemento.getPosicion().getColumna()<= 10);		
		
	}

}
