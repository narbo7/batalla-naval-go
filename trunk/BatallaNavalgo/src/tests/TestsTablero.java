package tests;

import junit.framework.TestCase;
import model.Tablero;

import org.junit.Test;

public class TestsTablero extends TestCase{

	@Test
	public void testUnTableroSeDeberiaCrearVacio() {
		
		Tablero miTablero = new Tablero();
		
		assertTrue(miTablero.getCantidadDeElementos() == 0);
		
	}
	

}
