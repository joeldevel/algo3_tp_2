package edu.fiuba.algo3.modelo.Edificios;
	

public abstract class Operable extends EstadoOperativo {
	
	public Operable(Edificio unEdificio) {
		super(unEdificio);
	}

	@Override
	public void ejecutar() {
		this.edificio.ejecutaOperable();
	}

	
}
