package edu.fiuba.algo3.modelo;

public class Tiempo {
	
	/* posiblemente haya que sacar el contador de aca, pues es solo para que funcione el 
	 * método de Moho expandirRadio, quizas otras clases necesiten otro contador, o quizas habria que
	 * instaciarlo de otra manera*/
	private int tiempo;
	private int contador;
	
	public Tiempo(int unTiempo) {
		this.tiempo = unTiempo;
		this.contador = 0;
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
		if( (this.contador == 0) || (this.contador == 2) ) {
			this.contador = 1;
		}
		else {
			this.contador++;
		}
	}
	
	public int contador() {
		return this.contador;
	}
	
	

}
