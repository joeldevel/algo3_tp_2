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
	
	private final int RADIO = 5;
	
	private ArrayList<Ubicacion> origenes;
	private ArrayList<Ubicacion> ubicacionesAfectadas;
	
	public Moho() {
		this.origenes = new ArrayList<Ubicacion>();
		this.ubicacionesAfectadas = new ArrayList<Ubicacion>();
	}
	
	public boolean tieneOrigenes() {
		return (!(this.origenes.isEmpty()));
	}
	
	public boolean tieneUbicacionesAfectadas() {
		return (! (this.ubicacionesAfectadas.isEmpty()));
	}
	
	public void agregarOrigen(Ubicacion unaUbicacion) {
		origenes.add(unaUbicacion);
		this.actualizarUbicacionesAfectadas();
	}
	
	private void actualizarUbicacionesAfectadas() {
		
		for(Ubicacion origenActual: this.origenes) {
			int limiteIzquierdo = origenActual.obtenerX() - this.RADIO;
			int limiteDerecho = origenActual.obtenerX() + this.RADIO;
			int limiteInferior = origenActual.obtenerY() - this.RADIO;
			int limiteSuperior = origenActual.obtenerY() + this.RADIO;
			/* falta agregar mas verificaciones por si una ubicacion ya esta afectadad
			 * o por ejemplo si una ubicacion cae fuera del limite del mapa
			 * o tambien hay que cambiar lo del radio, porque por ahora es 5 pero aumenta
			 * cada 2 turnos*/
			for(int i = limiteIzquierdo; i <= limiteDerecho; i++) {
				for(int j = limiteInferior; j <= limiteSuperior; j++) {
					Ubicacion ubicacionActual = new Ubicacion(i,j);
					if(ubicacionActual.distanciaCon(origenActual) <= this.RADIO) {
						this.ubicacionesAfectadas.add(ubicacionActual);
					}
				}
			}
		}
		
	}
	
	public boolean estaAfectada(Ubicacion unaUbicacion) {
		return (this.ubicacionesAfectadas.contains(unaUbicacion));
	}

}