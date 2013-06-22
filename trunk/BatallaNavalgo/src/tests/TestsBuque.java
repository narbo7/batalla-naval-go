package tests;

import junit.framework.TestCase;

import model.Buque;
import model.Disparo;
import model.MinaDobleConRetardo;
import model.MinaTripleConRetardo;
import model.Posicion;

import org.junit.Test;

public class TestsBuque extends TestCase{

	@Test
	public void testUnBuquerDeberiaCrearseConCuatroPartes() {
		
		Buque buque = new Buque();
		
		assertTrue((buque.getCantidadDePartes()) == 4);		
		
	}
	
	@Test
	public void testAlRecibirUnDisparoDeberiaPerderTodaSuResistencia(){
		
		Buque buque = new Buque();
		Disparo disparo = new Disparo(buque.getPosicion());
		
		disparo.atacar(buque);
		
		assertTrue((buque.getResistenciaTotal()) == 0);	
	}

	@Test
	public void testLaOndaExpansivaDeUnaMinaDobleDeberiaDestruirElBuque(){
		
		Buque buque = new Buque(new Posicion(4,4));
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(5,5));
		
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		
		
		minaDoble.atacar(buque);
		
		assertTrue((buque.getResistenciaTotal()) == 0);	
	}
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaTripleDeberiaDestruirElBuque(){
		
		Buque buque = new Buque(new Posicion(6,4));
		MinaTripleConRetardo minaTriple = new MinaTripleConRetardo(new Posicion(5,5));
		
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		
		
		minaTriple.atacar(buque);
		
		assertTrue((buque.getResistenciaTotal()) == 0);	
	}
	
	@Test
	public void testBordeSuperiorIzquierdo(){
		
		Posicion posicion = new Posicion(1,1);
		Buque buque = new Buque(posicion);
		
		int fila = buque.getPosicion().getFila();
		int columna = buque.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 3));
			
	}
	
	@Test
	public void testBordeSuperiorDerecho(){
		
		Posicion posicion = new Posicion(1,10);
		Buque buque = new Buque(posicion);
		
		int fila = buque.getPosicion().getFila();
		int columna = buque.getPosicion().getColumna();
		
		assertTrue((fila == 3) && (columna == 8));
			
	}
	
	@Test
	public void testBordeInferiorIzquierdo(){
		
		Posicion posicion = new Posicion(10,1);
		Buque buque = new Buque(posicion);
		
		int fila = buque.getPosicion().getFila();
		int columna = buque.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 3));
			
	}
	
	@Test
	public void testBordeInferiorDerecho(){
		
		Posicion posicion = new Posicion(10,10);
		Buque buque = new Buque(posicion);
		
		int fila = buque.getPosicion().getFila();
		int columna = buque.getPosicion().getColumna();
		
		assertTrue((fila == 8) && (columna == 8));
			
	}
}
