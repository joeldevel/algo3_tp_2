package edu.fiuba.algo3.modelo.Recursos.Minerales;

public class SinMinero implements Minero {

	public SinMinero() {
	}
	
	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
		return 0;
	}

	@Override
	public int obtenerMineral() {
		return 0;
	}

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return false;
	}

}
