package tests;

import junit.framework.TestCase;

import model.Lancha;
import model.Disparo;
import model.MinaDobleConRetardo;
import model.MinaTripleConRetardo;
import model.Posicion;


import org.junit.Test;

public class TestsLancha extends TestCase{

	@Test
	public void testUnaLanchaDeberiaCrearseConDosPartes() {
		
		Lancha lancha = new Lancha();
		
		assertTrue((lancha.getCantidadDePartes()) == 2);

	}
	
	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Lancha lancha = new Lancha();
		Disparo disparo = new Disparo(lancha.getPosicion());
		
		disparo.atacar(lancha);
	
		assertTrue((lancha.getResistenciaTotal()) == 1);
		
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
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaDobleDeberiaAtacarALaLancha(){
		
		Lancha lancha = new Lancha(new Posicion(4,4));
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(5,5));
		
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		
		
		minaDoble.atacar(lancha);
		
		assertTrue((lancha.getResistenciaTotal()) == 1);	
	}
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaTripleDeberiaAtacarALaLancha(){
		
		Lancha lancha = new Lancha(new Posicion(4,5));
		MinaTripleConRetardo minaTriple = new MinaTripleConRetardo(new Posicion(5,5));
		
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		
		
		minaTriple.atacar(lancha);
		
		assertTrue((lancha.getResistenciaTotal()) == 0);	
	}
}
