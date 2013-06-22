package tests;

import junit.framework.TestCase;

import model.Disparo;
import model.Portaavion;
import model.MinaDobleConRetardo;
import model.MinaTripleConRetardo;
import model.Posicion;


import org.junit.Test;

public class TestsPortaavion extends TestCase {

	@Test
	public void testUnPortaavionesDeberiaCrearseConCincoPartes() {
		
		Portaavion portaavion = new Portaavion();
		
		assertTrue((portaavion.getCantidadDePartes()) == 5);
		
	}

	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Portaavion portaavion = new Portaavion();
		Disparo disparo = new Disparo(portaavion.getPosicion());
		
		disparo.atacar(portaavion);
		
		assertTrue((portaavion.getResistenciaTotal()) == 4);
	}
	
	
	@Test
	public void testBordeSuperiorIzquierdo(){
		
		Posicion posicion = new Posicion(1,1);
		Portaavion portaavion = new Portaavion(posicion);
		
		int fila = portaavion.getPosicion().getFila();
		int columna = portaavion.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 3));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho(){
		
		Posicion posicion = new Posicion(1,10);
		Portaavion portaavion = new Portaavion(posicion);
		
		int fila = portaavion.getPosicion().getFila();
		int columna = portaavion.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 8));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo(){
		
		Posicion posicion = new Posicion(10,1);
		Portaavion portaavion = new Portaavion(posicion);
		
		int fila = portaavion.getPosicion().getFila();
		int columna = portaavion.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 3));
			
	}
	
	@Test
	public void testBordeInferiorDerecho(){
		
		Posicion posicion = new Posicion(10,10);
		Portaavion portaavion = new Portaavion(posicion);
		
		int fila = portaavion.getPosicion().getFila();
		int columna = portaavion.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 8));
			
	}
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaDobleDeberiaAtacarAlPortaaviones(){
		
		Portaavion portaavion = new Portaavion(new Posicion(4,4));
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(5,5));
		
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		
		
		minaDoble.atacar(portaavion);
		
		assertTrue((portaavion.getResistenciaTotal()) == 2);	
	}
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaTripleDeberiaAtacarAlPortaaviones(){
		
		Portaavion portaavion = new Portaavion(new Posicion(3,3));
		MinaTripleConRetardo minaTriple = new MinaTripleConRetardo(new Posicion(5,5));
		
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		
		
		minaTriple.atacar(portaavion);
		
		assertTrue((portaavion.getResistenciaTotal()) == 2);	
	}
}
