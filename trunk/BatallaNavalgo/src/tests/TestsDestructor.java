package tests;

import junit.framework.TestCase;

import model.Destructor;
import model.ErrorFueraDeRango;

import org.junit.Test;

public class TestsDestructor extends TestCase {

	@Test
	public void testUnDestructorDeberiaCrearseConTresPosiciones() throws ErrorFueraDeRango {
		
		Destructor destructor = new Destructor();
		
		destructor.determinarPosiciones();
		
		assertTrue(destructor.getCantidadDePosiciones() == 3);
		
	}

}
