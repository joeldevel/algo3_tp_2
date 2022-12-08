package edu.fiuba.algo3.modelo;


public class Origen {
	
	private Ubicacion ubicacion;
	private Tiempo tiempo;
	private int radio;
	
	public Origen(Ubicacion unaUbicacion, Tiempo unTiempo, int unRadio) {
		this.ubicacion = unaUbicacion;
		this.tiempo = unTiempo;
		this.radio = unRadio;
	}
	
	public Ubicacion obtenerUbicacion() {
		return (this.ubicacion);
	}
	
	public int radio() {
		return (this.radio);
	}
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		if(tiempo.transcurrido() % 2 == 0) {
			this.radio++;
		}
	}
	
	public int limiteIzquierdo() {
		return (this.ubicacion.obtenerX() - this.radio);
	}

	public int limiteDerecho() {
		return (this.ubicacion.obtenerX() + this.radio);
		
	}
	
	public int limiteInferior() {
		return (this.ubicacion.obtenerY() - this.radio);
	}
	
	public int limiterSuperior() {
		return (this.ubicacion.obtenerY() + this.radio);
	}
	
	public boolean afectaLaUbicacion(Ubicacion unaUbicacion) {
		return (this.ubicacion.distanciaCon(unaUbicacion) <= this.radio);
	}
	
	public boolean estaEn(Ubicacion unaUbicacion) {
		return (this.ubicacion.esIgualA(unaUbicacion));
	}
}
