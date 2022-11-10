package edu.fiuba.algo3.modelo;

public class CostoDeMineral implements CostoDeConstruccion {

	private int cantidad;
	private Mineral mineral;
	
	public CostoDeMineral(int unaCantidad, Mineral unMineral) {
		this.cantidad = unaCantidad;
		this.mineral = unMineral;
	}
}
