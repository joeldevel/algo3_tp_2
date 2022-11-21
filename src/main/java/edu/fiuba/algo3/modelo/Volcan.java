package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;

public class Volcan {

	private RefineriaDeGas refineria;
    private int cantidadDeGasVespenoDisponible;

    public Volcan() {
    	this.refineria = new SinRefineria(this);
        this.cantidadDeGasVespenoDisponible = 5000;
    }

    public void construirRefineriaDeGas(RefineriaDeGas unaRefineriaDeGas) {
    	
    	if(this.refineria.tieneRefineria()) {
    		throw new VolcanYaTieneUnaRefineriaDeGasConstruidaException();
    	}
    	this.refineria = unaRefineriaDeGas;
    }
    
    public int gasVespenoRestante() {
        return this.cantidadDeGasVespenoDisponible;
    }
    
    public int extraerGas(int unaCantidadDeGasParaExtraer) {

        if(this.gasVespenoRestante() == 0) {
            throw new VolcanSinGasVespenoParaExtraerException();
        }

        if(!this.refineria.tieneRefineria()) {
            throw new VolcanSinRefineriaDeGasConstruidaException();
        }

        /* Caso borde donde por ejemplo tenemos 10 de gas y nos piden 20. Deberiamos devolver esos 10 y dejar al Volcan en 0. */
        if(this.gasVespenoRestante() < unaCantidadDeGasParaExtraer) {
            unaCantidadDeGasParaExtraer = this.gasVespenoRestante();
            this.cantidadDeGasVespenoDisponible = 0;
            return unaCantidadDeGasParaExtraer;
        }

        this.cantidadDeGasVespenoDisponible = this.cantidadDeGasVespenoDisponible - unaCantidadDeGasParaExtraer;
        return unaCantidadDeGasParaExtraer;
    }
}