package tests;

import junit.framework.TestCase;

import model.MinaDobleConRetardo;
import model.Posicion;

import org.junit.Test;

public class TestsMinaDobleConRetardo extends TestCase {
	
	
	@Test
	public void testUnaMinaDoblePoseeUnCostoDe100Puntos() {
		
		Posicion posicion = new Posicion();
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(posicion);
		
		assertTrue((minaDoble.getCosto()) == 100);
		
	}

	@Test
	public void testUnaMinaDobleDeberiaTenerUnaOndaExpansivaDeNuevePosiciones() {
		
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(3,3));
		
		assertTrue(minaDoble.getTamanioOndaExpansiva() == 9);
		
	}

}
