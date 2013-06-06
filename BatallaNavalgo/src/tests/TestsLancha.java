package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Lancha;
import model.Posicion;


import org.junit.Test;

public class TestsLancha extends TestCase{

	@Test
	public void testUnaLanchaDeberiaCrearseConDosPosiciones() {
		
		Lancha lancha = new Lancha();
		
		assertTrue((lancha.getCantidadDePosiciones()) == 2);

	}


	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Lancha lancha = new Lancha();
		Disparo disparo = new Disparo(lancha.getPosicion());
		
		disparo.atacar(lancha);
		
		assertTrue((lancha.getResistencia()) == 1);
		
	}
	
	@Test
	public void testBordeSuperiorIzquierdo(){
		
		Posicion posicion = new Posicion(1,1);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 3));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho(){
		
		Posicion posicion = new Posicion(1,10);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 8));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo(){
		
		Posicion posicion = new Posicion(10,1);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 3));
			
	}
	
	@Test
	public void testBordeInferiorDerecho(){
		
		Posicion posicion = new Posicion(10,10);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 8));
			
	}
}
