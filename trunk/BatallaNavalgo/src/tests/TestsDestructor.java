package tests;

import junit.framework.TestCase;

import model.Destructor;
import model.Disparo;
import model.ErrorFueraDeRango;
import model.Posicion;



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

	@Test
	public void testBordeSuperiorIzquierdo() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(1,1);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 2) && (columna == 2));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(1,10);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 2) && (columna == 9));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(10,1);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 9) && (columna == 2));
			
	}
	
	@Test
	public void testBordeInferiorDerecho() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(10,10);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 9) && (columna == 9));
			
	}
}
