package tests;

import junit.framework.TestCase;

import model.MinaDobleConRetardo;
import model.Posicion;

import org.junit.Test;

public class TestsMinaDobleConRetardo extends TestCase {

	@Test
	public void testUnaMinaDobleDeberiaTenerUnaOndaExpansivaDeNuevePosiciones() {
		
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(3,3));
		
		assertTrue(minaDoble.getTamanioOndaExpansiva() == 9);
		
	}

}
