package edu.fiuba.algo3.modelo.Recursos.Gas;

public class SinRefineria implements RefineriaDeGas {
	
	public SinRefineria() {
	}

	@Override
	public int extraerGasDe(Volcan unVolcan) {
		return 0;
	}

	@Override
	public int obtenerGas() {
		return 0;
	}

	@Override
	public boolean tieneRefineria() {
		return false;
	}

}
