package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.ErrorFueraDeRango;
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
	public void testBordeSuperiorIzquierdo() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(1,1);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 2) && (columna == 2));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(1,10);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 2) && (columna == 9));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(10,1);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 9) && (columna == 2));
			
	}
	
	@Test
	public void testBordeInferiorDerecho() throws ErrorFueraDeRango{
		
		Posicion posicion = new Posicion(10,10);
		Lancha lancha = new Lancha(posicion);
		
		int fila = lancha.getPosicion().getFila();
		int columna = lancha.getPosicion().getColumna();
		
		assertTrue((fila == 9) && (columna == 9));
			
	}
}
