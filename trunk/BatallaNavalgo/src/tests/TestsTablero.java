package tests;

import junit.framework.TestCase;
import model.ElementoDelJuego;
import model.Lancha;
import model.Posicion;
import model.Tablero;

import org.junit.Test;

public class TestsTablero extends TestCase{

	@Test
	public void testUnTableroSeDeberiaCrearVacio() {
		
		Tablero miTablero = new Tablero();
		
		assertTrue(miTablero.getCantidadDeElementos() == 0);
	}
	
	@Test
	public void testAlAgregarDiezElementosAlTableroLaCantidadDeElementosDebeSerIgualADiez() {
		
		Tablero miTablero = new Tablero();
		ElementoDelJuego elemento = new Lancha();
		
		for (int i=0; i<10; i++) {miTablero.agregarElemento(elemento);}
		
		assertTrue(miTablero.getCantidadDeElementos() == 10);
	}
	
	@Test
	public void testQuitarElemento(){
		
		Tablero miTablero = new Tablero();
		Posicion posicion1 = new Posicion(3,5);
		ElementoDelJuego elemento = new Lancha(posicion1);
		
		//Agrego un elemento en posicion1 y cuento
		miTablero.agregarElemento(elemento);
		assertTrue(miTablero.getCantidadDeElementos() == 1);
		
		//Agrego otro elemento con distinta posicion y cuento
		Posicion posicion2 = new Posicion(3,8);
		ElementoDelJuego otroelemento = new Lancha(posicion2);
		miTablero.agregarElemento(otroelemento);
		assertTrue(miTablero.getCantidadDeElementos() == 2);
		
		//Quito todos los elementos en la posicion1 y cuento
		miTablero.quitarElemento(posicion1);
		assertTrue(miTablero.getCantidadDeElementos() == 1);

		//Quito todos los elementos en posicion2 y cuento
		miTablero.quitarElemento(posicion2);
		assertTrue(miTablero.getCantidadDeElementos() == 0);


		//Agrego tres elementos con posicion1 y un elemento en posicion2 y cuento
		miTablero.agregarElemento(elemento);
		miTablero.agregarElemento(elemento);
		miTablero.agregarElemento(elemento);
		miTablero.agregarElemento(otroelemento);
		assertTrue(miTablero.getCantidadDeElementos() == 4);
	
		
		//Quito todos los elementos en la posicion1 y cuento
		miTablero.quitarElemento(posicion1);
		assertTrue(miTablero.getCantidadDeElementos() == 1);

		}
	

}
