package tests;

import junit.framework.TestCase;

import model.Bomba;
import model.Jugador;
import model.MinaPorContacto;

import org.junit.Test;

public class TestsJugador extends TestCase {

	@Test
	public void testUnJugadorDisparaBombaSeleccionada(){
		Bomba bomba = new MinaPorContacto();
		Jugador jugador = new Jugador();
		jugador.seleccionarBomba(bomba);
		assertEquals(bomba,jugador.dispararBomba());
	}
	
}
