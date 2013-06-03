package model;


public interface Atacable {
	
	public void serAtacadoPor(Disparo disparo) ;

	public void serAtacadoPor(MinaConRetardo minaConRetardo) ;

	public void serAtacadoPor(MinaDobleConRetardo minaDobleConRetardo) ;

	public void serAtacadoPor(MinaTripleConRetardo minaTripleConRetardo);

	public void serAtacadoPor(MinaPorContacto minaPorContacto) ;

}
