package tests;

import junit.framework.TestCase;

import model.MinaTripleConRetardo;
import model.Posicion;

import org.junit.Test;

public class TestsMinaTripleConRetardo extends TestCase{

	@Test
	public void testUnaMinaDobleDeberiaTenerUnaOndaExpansivaDe25Posiciones() {
		
		MinaTripleConRetardo minaTriple = new MinaTripleConRetardo(new Posicion(4,4));
		
		assertTrue(minaTriple.getTamanioOndaExpansiva() == 25);
		
	}

}
