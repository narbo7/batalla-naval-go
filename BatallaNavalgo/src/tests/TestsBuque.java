package tests;

import junit.framework.TestCase;

import model.Buque;
import model.Disparo;

import org.junit.Test;

public class TestsBuque extends TestCase{

	@Test
	public void testUnBuquerDeberiaCrearseConCuatroPosiciones() {
		
		Buque buque = new Buque();
		
		assertTrue((buque.getCantidadDePosiciones()) == 4);		
		
	}
	
	@Test
	public void testAlRecibirUnDisparoDeberiaPerderTodaSuResistencia(){
		
		Buque buque = new Buque();
		Disparo disparo = new Disparo(buque.getPosicion());
		
		disparo.atacar(buque);
		
		assertTrue((buque.getResistencia()) == 0);
		
		
	}

}
