package edu.fiuba.algo3.modelo.Edificios;

public abstract class EstadoOperativo {
	
	protected Edificio edificio;
	
	protected EstadoOperativo(Edificio unEdificio) {
		this.edificio = unEdificio;
	}
	
	public void ejecutar() {
		
	}
	
	

}
