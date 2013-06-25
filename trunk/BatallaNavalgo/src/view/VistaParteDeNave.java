package view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaParteDeNave extends Imagen implements Observer {
	//private static URL imgURL = new URL("./imagenes/naves/buque/horizontal/buque1.png");

	public VistaParteDeNave(ObjetoPosicionable modelo) throws IOException, MalformedURLException {
		//super(modelo.getX(),modelo.getY(), modelo);
		super(new URL("./imagenes/naves/buque/horizontal/buque1.png"),modelo);
		System.out.println("DASLKJAFKHAJKHADKFJHFDJAKFJHASDKJFHKSDJFHSAKDJFHSDFKJSDHFAKJSDFHASDKFJHASDFK");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
