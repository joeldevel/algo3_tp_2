package edu.fiuba.algo3.modelo;

public class Volcan {

	private int cantidad;
    private RefineriaDeGas refineria;

    public Volcan() {
    	this.cantidad = 5000;
        this.refineria = null;
    }

    public void construirRefineriaDeGas(RefineriaDeGas unaRefineria) {
        /* Chequear que el tipo de parametro sea RefineriaDeGas. En caso contrario, lanzar excepcion. */

    	if( !(unaRefineria instanceof RefineriaDeGas)) {
    		//lanza una excepcion de que no se puede construir el edificio en el lugar
    	}
        if(this.refineria != null) {
            throw new VolcanYaTieneUnaRefineriaDeGasConstruidaException();
        }

        this.refineria = unaRefineria;
    }

    public int extraerGas() {

        if(this.gasRestante() == 0) {
            throw new VolcanSinGasVespenoParaExtraerException();
        }

        if(this.refineria == null) {
            throw new VolcanSinRefineriaDeGasConstruidaException();
        }

        return (this.refineria.extraerGasDe(this));
    }
    
    public int gasRestante() {
    	return (this.cantidad);
    }
    
    public int extraerGas(int unaCantidad) {

        /* Caso borde donde por ejemplo tenemos 10 de gas y nos piden 20. Deberiamos devolver esos 10 y dejar al Volcan en 0. */
        int extraido = 0;
    	if(unaCantidad > this.cantidad) {
            extraido = this.cantidad;
            this.cantidad = 0;
        }
    	else {
    		extraido = unaCantidad;
    		this.cantidad -= unaCantidad;
    	}
    	return extraido;
    }
}