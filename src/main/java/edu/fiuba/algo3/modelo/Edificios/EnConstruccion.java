package edu.fiuba.algo3.modelo.Edificios;

public class EnConstruccion extends EstadoOperativo{
	
	
	public EnConstruccion(Edificio unEdificio) {
		super(unEdificio);
	}
	
	@Override
	public void ejecutar() {
		this.edificio.ejecutaEnConstruccion();
	}
	

}
