package edu.fiuba.algo3.modelo;


import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.OrigenNoEncontradoError;

public class Moho {
 
	private ArrayList<Origen> origenes;
	private ArrayList<Ubicacion> ubicacionesAfectadas;
	private ArrayList<Ubicacion> ubicacionesQueNoSePuedenAfectar;
	
	public Moho() {
		this.origenes = new ArrayList<Origen>();
		this.ubicacionesAfectadas = new ArrayList<Ubicacion>();
		this.ubicacionesQueNoSePuedenAfectar = new ArrayList<Ubicacion>();
	}

	public ArrayList<Ubicacion> ubicacionesConMoho() {
		return this.ubicacionesAfectadas;
	}
	
	public boolean tieneUbicacionesAfectadas() {
		return (! (this.ubicacionesAfectadas.isEmpty()));
	}
	
	public void agregarOrigen(Ubicacion unaUbicacion,ArrayList<Edificio> edificios) {
		Origen nuevoOrigen = new Origen(unaUbicacion,new Tiempo(0),5);
		origenes.add(nuevoOrigen);
		this.actualizarUbicacionesAfectadas(edificios);
	}
	
	private void actualizarUbicacionesAfectadas(ArrayList<Edificio> edificios) {
		
		for(Origen actual: this.origenes) {
			
			for(int i = actual.limiteIzquierdo(); i <= actual.limiteDerecho(); i++) {
				for(int j = actual.limiteInferior(); j <= actual.limiterSuperior(); j++) {
					Ubicacion nueva = new Ubicacion(i,j);
					if( (actual.afectaLaUbicacion(nueva)) && (!(this.estaAfectadaLaUbicacion(nueva))) &&
						((this.sePuedeAfectarLaUbicacion(nueva)))) {
						this.ubicacionesAfectadas.add(nueva);
					}
				}
			}
		}

		ArrayList<Ubicacion> aBorrar = new ArrayList<Ubicacion>();
		for(Ubicacion ubicacion: this.ubicacionesAfectadas) {
			for(Edificio edificio: edificios) {
				if(edificio.estaEn(ubicacion)) {
					aBorrar.add(ubicacion);
				}
			}
		}
		for(Ubicacion ubicacion: aBorrar) {
			this.ubicacionesAfectadas.remove(ubicacion);
		}
	}
	
	public void agregarUbicacionesInafectables(ArrayList<Ubicacion> unasUbicaciones) {
		this.ubicacionesQueNoSePuedenAfectar.addAll(unasUbicaciones);
	}
	
	public boolean sePuedeAfectarLaUbicacion(Ubicacion unaUbicacion) {
		
		for(Ubicacion actual: this.ubicacionesQueNoSePuedenAfectar) {
			if(actual.esIgualA(unaUbicacion)) {
				return false;
			}
		}
		return true;
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
	
	public void avanzarTurno(int cantidad,ArrayList<Edificio> edificios) {
		if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno(edificios);
    		}
    	}
	}
	
	public void avanzarTurno(ArrayList<Edificio> edificios) {
		for(Origen actual: this.origenes) {
			actual.avanzarTurno();
		}

		this.actualizarUbicacionesAfectadas(edificios);			
	}
	
	public void destruirOrigenEn(Ubicacion unaUbicacion) {
		Origen origen = this.obtenerOrigenEn(unaUbicacion);
		this.origenes.remove(origen);
	}
	
	private Origen obtenerOrigenEn(Ubicacion unaUbicacion) {
		Origen origen = null;
		for(Origen actual: this.origenes) {
			if(actual.estaEn(unaUbicacion)) {
				origen = actual;
			}
		}
		if(origen == null) {
			throw new OrigenNoEncontradoError();
		}
		return origen;
	}
}