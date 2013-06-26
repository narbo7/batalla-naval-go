package tests;

import junit.framework.TestCase;

import model.Rompehielo;
import model.Disparo;
import model.MinaConRetardo;
import model.MinaDobleConRetardo;
import model.MinaPorContacto;
import model.MinaTripleConRetardo;
import model.Rompehielo;
import model.Posicion;

import org.junit.Test;

public class TestsRompehielo extends TestCase {

	@Test
	public void testUnRompehieloDeberiaCrearseConTresPartes() {
		
		Rompehielo rompehielo = new Rompehielo();
		
		assertTrue((rompehielo.getCantidadDePartes()) == 3);
			
	}
	
	@Test
	public void testAlSerAtacadoPorUnDisparoDeberiaReducirSuResistencia(){
		
		Rompehielo rompehielo = new Rompehielo();
		Disparo disparo = new Disparo(rompehielo.getPosicion());
		
		disparo.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistenciaTotal()) == 5);
	}

	@Test
	public void testAlSerAtacadoPorUnaMinaConRetardoDeberiaReducirSuResistencia(){
		
		Rompehielo rompehielo = new Rompehielo();
		MinaConRetardo mina = new MinaConRetardo(rompehielo.getPosicion());
		
		mina.descontarRetardo();
		mina.descontarRetardo();
		mina.descontarRetardo();
		
		mina.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistenciaTotal()) == 5);
	}
	
	@Test
	public void testAlserAtacadoPorUnaMinaPorContactoDeberiaReducirSuResistencia(){
		
		Rompehielo rompehielo = new Rompehielo();
		MinaPorContacto mina = new MinaPorContacto(rompehielo.getPosicion());
		
		mina.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistenciaTotal()) == 5);
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
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaDobleDeberiaAtacarAlRompehielo(){
		
		Rompehielo rompehielo = new Rompehielo(new Posicion(4,4));
		MinaDobleConRetardo minaDoble = new MinaDobleConRetardo(new Posicion(5,5));
		
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		minaDoble.descontarRetardo();
		
		
		minaDoble.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistenciaTotal()) == 4);	
	}
	
	@Test
	public void testLaOndaExpansivaDeUnaMinaTripleDeberiaAtacarAlRompehielo(){
		
		Rompehielo rompehielo = new Rompehielo(new Posicion(3,3));
		MinaTripleConRetardo minaTriple = new MinaTripleConRetardo(new Posicion(5,5));
		
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		minaTriple.descontarRetardo();
		
		
		minaTriple.atacar(rompehielo);
		
		assertTrue((rompehielo.getResistenciaTotal()) == 4);	
	}
}
