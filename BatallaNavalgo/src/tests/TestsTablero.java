package tests;

import junit.framework.TestCase;
import model.ElementoDelJuego;
import model.Posicion;
import model.Tablero;

import org.junit.Test;

public class TestsTablero extends TestCase{

	@Test
	public void testAlAgregarUnElementoLaPosicionNoDeberiaEstarVacia() {
		
		Tablero tablero = new Tablero(100);
		Posicion posicion = new Posicion(1,1);
		ElementoDelJuego unElemento = new ElementoDelJuego();
		
		tablero.agregarElemento(unElemento, posicion);
		
		assertTrue((tablero.getCasilleros().get(1)) != null);		
		
	}

}
