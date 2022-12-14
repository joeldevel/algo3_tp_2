package edu.fiuba.algo3.modelo;


public class Energia {

	private boolean energia;
	
	public Energia() {
		this.energia = false;
	}
	
	public void prenderEnergia() {
		this.energia = true;
	}
	
	public void apagarEnergia() {
		this.energia = false;
	}
	
	public boolean tieneEnergia() {
		return (this.energia);
	}
}
