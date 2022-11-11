package edu.fiuba.algo3.modelo;

public class CostoDeGas implements CostoDeConstruccion {

	private int cantidad;
	private GasVespeno gas;
	
	public CostoDeGas(int unaCantidad, GasVespeno unGas) {
		this.cantidad = unaCantidad;
		this.gas = unGas;
	}
}
