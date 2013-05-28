package tests;

import junit.framework.TestCase;

import model.Buque;

import org.junit.Test;

public class TestsBuque extends TestCase{

	@Test
	public void testUnBuquerDeberiaCrearseConCuatroPosiciones() {
		
		Buque buque = new Buque();
		
		assertTrue((buque.getCantidadDePosiciones()) == 4);		
		
	}

}
