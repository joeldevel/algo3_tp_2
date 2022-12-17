package edu.fiuba.algo3.modelo.Recursos.Minerales;

public interface Mineral {

	public int getCantidadDeMineralDisponible();
	
	public int recolectarMineral(int unaCantidad);
	
	boolean tieneMineral();

	}