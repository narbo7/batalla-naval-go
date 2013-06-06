package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Rompehielo;
import model.Posicion;

import org.junit.Test;

public class TestsRompehielo extends TestCase {

	@Test
	public void testUnRompehieloDeberiaCrearseConTresPosiciones() {
		
		Rompehielo rompehielo = new Rompehielo();
		
		assertTrue((rompehielo.getCantidadDePosiciones()) == 3);
			
	}
	
	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Rompehielo rompehielo = new Rompehielo();
		Disparo disparo = new Disparo(rompehielo.getPosicion());
		
		disparo.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistencia()) == 5);
	}

	
	@Test
	public void testBordeSuperiorIzquierdo(){
		
		Posicion posicion = new Posicion(1,1);
		Rompehielo rompehielo = new Rompehielo(posicion);
		
		int fila = rompehielo.getPosicion().getFila();
		int columna = rompehielo.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 3));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho(){
		
		Posicion posicion = new Posicion(1,10);
		Rompehielo rompehielo = new Rompehielo(posicion);
		
		int fila = rompehielo.getPosicion().getFila();
		int columna = rompehielo.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 8));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo(){
		
		Posicion posicion = new Posicion(10,1);
		Rompehielo rompehielo = new Rompehielo(posicion);
		
		int fila = rompehielo.getPosicion().getFila();
		int columna = rompehielo.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 3));
			
	}
	
	@Test
	public void testBordeInferiorDerecho(){
		
		Posicion posicion = new Posicion(10,10);
		Rompehielo rompehielo = new Rompehielo(posicion);
		
		int fila = rompehielo.getPosicion().getFila();
		int columna = rompehielo.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 8));
			
	}
}
