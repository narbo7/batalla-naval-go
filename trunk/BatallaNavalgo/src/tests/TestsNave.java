package tests;

import static org.junit.Assert.*;

import model.Lancha;
import model.Nave;
import model.Posicion;

import org.junit.Test;

public class TestsNave {

	@Test
	public void testUnaNaveNoPuedeIrParaArribaYParaAbajo() {

		Nave unaNave = new Lancha(); //Se instancia una clase hija de la nave, por ser una clase abstracta
		
		boolean tienenDistintaDireccion = ((unaNave.getDirArriba()) != (unaNave.getDirAbajo()));
		boolean ambasSonFalsas = ((unaNave.getDirArriba() == false) & (unaNave.getDirAbajo() == false));
		
		assertTrue (tienenDistintaDireccion ^ ambasSonFalsas); // XOR
	}

	@Test
	public void testUnaNaveNoPuedeIrParaLaDerechaYParaLaIzquierda() {

		Nave unaNave = new Lancha(); //Se instancia una clase hija de la nave, por ser una clase abstracta
		
		boolean tienenDistintaDireccion = (unaNave.getDirDerecha()) != (unaNave.getDirIzquierda());
		boolean ambasSonFalsas = ((unaNave.getDirDerecha() == false) & (unaNave.getDirIzquierda() == false));
		
		assertTrue (tienenDistintaDireccion ^ ambasSonFalsas); // XOR
	}
	
	@Test
	public void testUnaNaveQueSeMueveParaArribaYLlegaALaFilaUnoDebeDarLaVuelta(){
		
		Posicion unaPosicion = new Posicion(1,6);
		Nave unaNave = new Lancha(unaPosicion);
		unaNave.setDirArriba(true);
		unaNave.setDirAbajo(false);
		
		unaNave.mover();
		
		assertTrue(unaNave.getDirAbajo());
		assertTrue(!unaNave.getDirArriba());
	}
	
	@Test
	public void testUnaNaveQueSeMueveParaAbajoYLlegaALaUltimaFilaDebeDarLaVuelta(){
		
		Posicion unaPosicion = new Posicion(10,4);
		Nave unaNave = new Lancha(unaPosicion);
		unaNave.setDirArriba(false);
		unaNave.setDirAbajo(true);
		
		unaNave.mover();
		
		assertTrue(!unaNave.getDirAbajo());
		assertTrue(unaNave.getDirArriba());
		
	}
	
	@Test
	public void testUnaNaveQueSeMueveParaLaDerechaYLlegaALaUltimaColumnaDebeDarLaVuelta(){
		
		Posicion unaPosicion = new Posicion(5,10);
		Nave unaNave = new Lancha(unaPosicion);
		unaNave.setDirDerecha(true);
		unaNave.setDirIzquierda(false);
		
		unaNave.mover();
		
		assertTrue(!unaNave.getDirDerecha());
		assertTrue(unaNave.getDirIzquierda());
		
	}
	
	@Test
	public void testUnaNaveQueSeMueveParaLaIzquierdaYLlegaALaColumnaUnoDebeDarLaVuelta(){
		
		Posicion unaPosicion = new Posicion(9,1);
		Nave unaNave = new Lancha(unaPosicion);
		unaNave.setDirDerecha(false);
		unaNave.setDirIzquierda(true);
		
		unaNave.mover();
		
		assertTrue(unaNave.getDirDerecha());
		assertTrue(!unaNave.getDirIzquierda());
	}
}
