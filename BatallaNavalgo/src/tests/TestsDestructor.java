package tests;

import junit.framework.TestCase;

import model.Destructor;
import model.Disparo;



import org.junit.Test;

public class TestsDestructor extends TestCase {

	@Test
	public void testUnDestructorDeberiaCrearseConTresPosiciones(){
		
		Destructor destructor = new Destructor();
	
		assertTrue(destructor.getCantidadDePosiciones() == 3);
		
	}
	
	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){

		Destructor destructor = new Destructor();
		Disparo disparo = new Disparo(destructor.getPosicion());
		
		disparo.atacar(destructor);
		
		assertTrue((destructor.getResistencia()) == 2);
	}

}
