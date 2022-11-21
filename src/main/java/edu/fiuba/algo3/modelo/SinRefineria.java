package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;

public class SinRefineria implements RefineriaDeGas {
	
	private int cantidadExtraida;
	private Volcan volcan;
	
	public SinRefineria(Volcan unVolcan) {
		this.cantidadExtraida = 0;
		this.volcan = unVolcan;
	}

	@Override
	public int extraerGasDe(Volcan unVolcan) {
		throw new VolcanSinRefineriaDeGasConstruidaException();
	}

	@Override
	public int obtenerGas() {
		throw new VolcanSinRefineriaDeGasConstruidaException();
	}

	@Override
	public boolean tieneRefineria() {
		// TODO Auto-generated method stub
		return false;
	}

}
