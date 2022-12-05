package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;

public class Moho {
 
	private ArrayList<Origen> origenes;
	private ArrayList<Ubicacion> ubicacionesAfectadas;
	
	public Moho() {
		this.origenes = new ArrayList<Origen>();
		this.ubicacionesAfectadas = new ArrayList<Ubicacion>();
	}
	
	public boolean tieneUbicacionesAfectadas() {
		return (! (this.ubicacionesAfectadas.isEmpty()));
	}
	
	public void agregarOrigen(Ubicacion unaUbicacion) {
		Origen nuevoOrigen = new Origen(unaUbicacion,new Tiempo(0),5);
		origenes.add(nuevoOrigen);
		this.actualizarUbicacionesAfectadas();
	}
	
	private void actualizarUbicacionesAfectadas() {
		
		for(Origen actual: this.origenes) {
			
			for(int i = actual.limiteIzquierdo(); i <= actual.limiteDerecho(); i++) {
				for(int j = actual.limiteInferior(); j <= actual.limiterSuperior(); j++) {
					Ubicacion nueva = new Ubicacion(i,j);
					if((actual.afectaLaUbicacion(nueva)) && (!(this.estaAfectadaLaUbicacion(nueva)))) {
						this.ubicacionesAfectadas.add(nueva);
					}
				}
			}
		}
		
	}
	
	public boolean estaAfectadaLaUbicacion(Ubicacion unaUbicacion) {
		boolean esta = false;
		for(Ubicacion afectada: this.ubicacionesAfectadas) {
			if(afectada.esIgualA(unaUbicacion)) {
				esta = true;
			}
		}
		return esta;
	}
	
	public int contarUbicacionesAfectadas() {
		return (this.ubicacionesAfectadas.size());
	}
	
	public void avanzarTurno(int cantidad) {
		if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
	}
	
	public void avanzarTurno() {
		for(Origen actual: this.origenes) {
			actual.avanzarTurno();
		}
		this.actualizarUbicacionesAfectadas();			
	}
	
}