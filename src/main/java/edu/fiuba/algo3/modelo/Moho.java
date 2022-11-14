package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Moho {
 
	/*es buena idea que el moho tenga una coleccion de ubicacionesy que las ubicaciones
	 * tengan un radio. Para las ubicaciones en las que se cree un criadero, el radio sera 5
	 * y cada 2 turnos los radios de esas ubicaciones se expanden en 1. Si en esa ubicacion
	 * se destruye el criadero el radio del moho no va a aumentar pero el moho seguira afectando
	 * la construccion de edificios zerg, solo hay que preguntarle al moho si se puede construir
	 * un edificio en una ubicacion, si moho no tiene la ubicacion significa que esa ubicacion no esta
	 * afectada por el moho, por lo que no se puede construir. Hay que ir actualiando el moho cada
	 * vez que se avanza un turno*/
	
	private ArrayList<Ubicacion> ubicaciones;
	
	public Moho() {
		this.ubicaciones = new ArrayList<Ubicacion>();
	}
	
	/*private int radio;
	private Tiempo tiempo;
	
	public Moho() {
		this.radio = 5;
		this.tiempo = new Tiempo(0);
	}
	
	public Moho(Tiempo unTiempo) {
		this.radio = 5;
		this.tiempo = unTiempo;
	}

	public Moho(int unRadio, Tiempo unTiempo) {
		this.radio = unRadio;
		this.tiempo = unTiempo;
	}

	public int radio() {
		return this.radio;
	}
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		this.expandirRadio();
	}

	public void expandirRadio() {
		if((this.tiempo.transcurrido() > 0) && (this.tiempo.transcurrido() % 2) == 0) {
			this.radio++;
		}
	}*/

}