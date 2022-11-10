package edu.fiuba.algo3.modelo;

public class Tiempo {
	
	private int tiempo;
	private int transcurrido;
	
	public Tiempo(int unTiempo) {
		this.tiempo = unTiempo;
		this.transcurrido = 0;
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
		this.transcurrido++;
	}
	
	public int transcurrido() {
		return this.transcurrido;
	}
	
	

}
