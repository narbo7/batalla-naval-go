package tests;

import static org.junit.Assert.*;

import model.Partida;

import org.junit.Test;

public class TestsPartida {

	@Test
	public void testUnaPartidaDebeComenzarCon7Barcos() {
		Partida unaPartida = new Partida();
		assertTrue(unaPartida.getCantidadDeElementosEnTablero() == 7);
	}
	
	@Test
	public void testEstoEsUnTestQueVaAFallar() {
		assertTrue (1==0);
	}
}
