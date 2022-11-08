package edu.fiuba.algo3.modelo;

public class Tiempo {

	private int unidadDeTiempo;
	private int contador;
	
	public Tiempo(int unTiempo) {
		this.unidadDeTiempo = unTiempo;
		this.contador = 0;
	}
	
	public int tiempoRestante() {
		int restante = 0;
		if(this.unidadDeTiempo < 0) {
			restante = (-1 * this.unidadDeTiempo);
		}
		return restante;
	}
	/* hay que pensar mejor lo de contador y sacar el if que queda horrible
	 * la idea con este codigo es que contador me pueda decir si pasaron dos turnos
	 * para aumentar el moho. Habra que cambiarlo pues otros edificios necesitaran
	 * otros contadores que no sean de a dos en dos*/
	public void pasarTiempo() {
		this.unidadDeTiempo++;
		if( (this.contador == 0) || (this.contador == 2) ){
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
