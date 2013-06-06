package tests;

import junit.framework.TestCase;

import model.Destructor;
import model.Disparo;
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
	public void testBordeSuperiorIzquierdo(){
		
		Posicion posicion = new Posicion(1,1);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 3));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho(){
		
		Posicion posicion = new Posicion(1,10);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 8));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo(){
		
		Posicion posicion = new Posicion(10,1);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 3));
			
	}
	
	@Test
	public void testBordeInferiorDerecho(){
		
		Posicion posicion = new Posicion(10,10);
		Destructor destructor = new Destructor(posicion);
		
		int fila = destructor.getPosicion().getFila();
		int columna = destructor.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 8));
			
	}
}
