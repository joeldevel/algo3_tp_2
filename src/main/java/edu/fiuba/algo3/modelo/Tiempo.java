package edu.fiuba.algo3.modelo;

public class Tiempo {

	private int tiempo;

	public Tiempo(int unTiempo) {
		this.tiempo = unTiempo;
	}

	public int restante() {
		int restante = 0;
		if(this.tiempo < 0 ) {
			restante = (-1 * this.tiempo);
		}
		return restante;
	}

	public void pasarTiempo() {
		this.tiempo++;
	}

	public int transcurrido() {
		return (this.tiempo);
	}
}