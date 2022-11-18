package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;

public class Volcan {

	private int cantidad;
    private RefineriaDeGas refineria;

    public Volcan() {
    	this.cantidad = 5000;
        this.refineria = new SinRefineria(this);
    }

    public void construirExtractor() {
    	if(this.refineria.tieneRefineria()) {
    		throw new VolcanYaTieneUnaRefineriaDeGasConstruidaException();
    	}
    	this.refineria = new Extractor(this);
    }
    
    public void construirAsimilador() {
    	if(this.refineria.tieneRefineria()) {
    		throw new VolcanYaTieneUnaRefineriaDeGasConstruidaException();
    	}
    	this.refineria = new Asimilador(this);
    }
    
    public int gasRestante() {
    	return (this.cantidad);
    }
    
    public int extraerGas(int unaCantidad) {

        /* Caso borde donde por ejemplo tenemos 10 de gas y nos piden 20. Deberiamos devolver esos 10 y dejar al Volcan en 0. */
    	if(this.gasRestante() == 0) {
            throw new VolcanSinGasVespenoParaExtraerException();
        }
    	int extraido = 0;
    	if(unaCantidad > this.gasRestante()) {
            extraido = this.gasRestante();
            this.cantidad = 0;
        }
    	else {
    		extraido = unaCantidad;
    		this.cantidad -= unaCantidad;
    	}
    	return extraido;
    }
}