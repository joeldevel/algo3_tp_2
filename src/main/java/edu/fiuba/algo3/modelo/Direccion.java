package edu.fiuba.algo3.modelo;

public class Direccion {
	
	private String direccion;
	
	public Direccion() {
		this.direccion = "Derecha";
	}
	
	public void cambiarDireccion() {
		if(this.direccion == "Derecha") {
			this.direccion = "Abajo";
		}
		else if(this.direccion == "Abajo") {
			this.direccion = "Izquierda";
		}
		else if(this.direccion == "Izquierda") {
			this.direccion = "Arriba";
		}
		else if(this.direccion == "Arriba") {
			this.direccion = "Derecha";
		}
	}
	
	public Ubicacion obtenerSiguienteUbicacion(Ubicacion unaUbicacion) {
		Ubicacion ubicacion = new Ubicacion();
		if(this.direccion == "Derecha") {
			ubicacion = unaUbicacion.derecha();
		}
		if(this.direccion == "Abajo") {
			ubicacion = unaUbicacion.abajo();
		}
		if(this.direccion == "Izquierda") {
			ubicacion = unaUbicacion.izquierda();
		}
		if(this.direccion == "Arriba") {
			ubicacion = unaUbicacion.arriba();
		}
		return ubicacion;
	}

}
