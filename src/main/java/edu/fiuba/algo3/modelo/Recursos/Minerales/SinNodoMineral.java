package edu.fiuba.algo3.modelo.Recursos.Minerales;

public class SinNodoMineral implements Mineral {

	public SinNodoMineral() {
	}

	@Override
	public int getCantidadDeMineralDisponible() {
		return 0;
	}
	@Override
	public int recolectarMineral(int unaCantidad) {
		return 0;
	}
}
