package view;

import java.io.File;
import java.io.IOException;

import java.util.Observable;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaBuque extends VistaNave{
	private static int number;
	
	public VistaBuque(ObjetoPosicionable modelo) throws IOException{
		super(new File("./imagenes/naves/buque/vertical/buque"+(number+1)+".png").toURI().toURL(),modelo);
		System.out.println("./imagenes/naves/buque/vertical/buque"+(number+1)+".png");
		number++;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
