package tests;

import junit.framework.TestCase;

import model.Buque;
import model.MinaPorContacto;
import model.Posicion;

import org.junit.Test;

public class TestsMinaPorContacto extends TestCase {

	@Test
	public void testUnaMinaPorContactoPoseeUnCostoDe150Puntos() {
		
		MinaPorContacto minaPC = new MinaPorContacto();
		
		assertTrue(minaPC.getCosto() == 150);
		
	}

	@Test
	public void testUnaMinaPorContactoDeberiaSeguirExistiendoSiNoHuboContacto(){
		
		Buque buque = new Buque (new Posicion(5,5));
		MinaPorContacto minaPC = new MinaPorContacto(new Posicion(2,2));
		
		minaPC.atacar(buque);
		
		assertFalse(minaPC.estaExplotada());
		
	}
}
