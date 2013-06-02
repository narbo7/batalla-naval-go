package tests;

import static org.junit.Assert.*;

import model.Lancha;
import model.Nave;

import org.junit.Test;

public class TestsNave {

	@Test
	public void testUnaNaveNoPuedeIrParaArribaYParaAbajo() {

		Nave unaNave = new Lancha(); //Se instancia una clase hija de la nave, por ser una clase abstracta
		
		assertTrue ((unaNave.getDirArriba()) != (unaNave.getDirAbajo()));
	}

	@Test
	public void testUnaNaveNoPuedeIrParaLaDerechaYParaLaIzquierda() {

		Nave unaNave = new Lancha(); //Se instancia una clase hija de la nave, por ser una clase abstracta
		
		assertTrue ((unaNave.getDirDerecha()) != (unaNave.getDirAbajo()));
	}
}
