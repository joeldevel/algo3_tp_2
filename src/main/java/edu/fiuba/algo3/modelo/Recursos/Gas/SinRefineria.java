package edu.fiuba.algo3.modelo.Recursos.Gas;

import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;

public class SinRefineria implements RefineriaDeGas {
	
	public SinRefineria() {
		
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
