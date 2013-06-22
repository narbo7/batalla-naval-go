package tests;

import junit.framework.TestCase;

import model.MinaConRetardo;

import org.junit.Test;

public class TestsMinaConRetardo extends TestCase {

	@Test
	public void testUnaMinaConRetardoPoseeUnCostDe50Puntos() {
		
		MinaConRetardo minaR = new MinaConRetardo();
		
		assertTrue(minaR.getCosto() == 50);
	}

}
