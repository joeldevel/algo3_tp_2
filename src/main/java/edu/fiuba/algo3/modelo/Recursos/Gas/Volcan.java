package edu.fiuba.algo3.modelo.Recursos.Gas;

import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;

public class Volcan {

    private static final int GAS_INICIAL = 5000;

	private RefineriaDeGas refineria;
    private int cantidadDeGasVespenoDisponible;
    private Ubicacion ubicacion;

    public Volcan(Ubicacion unaUbicacion) {
    	this.refineria = new SinRefineria();
        this.cantidadDeGasVespenoDisponible = GAS_INICIAL;
        this.ubicacion = unaUbicacion;
    }

    public int getCantidadDeGasVespenoDisponible() {
        return this.cantidadDeGasVespenoDisponible;
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

        if(this.gasVespenoRestante() < unaCantidadDeGasParaExtraer) {
            unaCantidadDeGasParaExtraer = this.gasVespenoRestante();
            this.cantidadDeGasVespenoDisponible = 0;
            return unaCantidadDeGasParaExtraer;
        }

        this.cantidadDeGasVespenoDisponible = this.cantidadDeGasVespenoDisponible - unaCantidadDeGasParaExtraer;
        return unaCantidadDeGasParaExtraer;
    }
    
    public boolean estaEn(Ubicacion unaUbicacion) {
    	return (this.ubicacion.esIgualA(unaUbicacion));
    }

    public Ubicacion ubicacion() {
        return this.ubicacion;
    }
}