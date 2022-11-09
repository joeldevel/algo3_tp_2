package edu.fiuba.algo3.modelo;

public class Volcan {

    private RefineriaDeGas refineria;
    private int cantidadDeGasVespenoDisponible;

    public Volcan(int unaCantidadDeGasVespeno) {
        this.refineria = null;
        this.cantidadDeGasVespenoDisponible = unaCantidadDeGasVespeno;
    }

    public void construirRefineriaDeGas(RefineriaDeGas unaRefineria) {
        /* Chequear que el tipo de parametro sea RefineriaDeGas. En caso contrario, lanzar excepcion. */

        if(this.refineria != null) {
            throw new VolcanYaTieneUnaRefineriaDeGasConstruidaException();
        }

        this.refineria = unaRefineria;
    }

    public int extraerGasUsandoRefineria() {

        if(this.cantidadDeGasVespenoDisponible == 0) {
            throw new VolcanSinGasVespenoParaExtraerException();
        }

        if(this.refineria == null) {
            throw new VolcanSinRefineriaDeGasConstruidaException();
        }

        return this.refineria.extraerGasUsandoRefineria(this);
    }

    public int extraerGas(int unaCantidadDeGasParaExtraer) {

        /* Caso borde donde por ejemplo tenemos 10 de gas y nos piden 20. Deberiamos devolver esos 10 y dejar al Volcan en 0. */
        if(this.cantidadDeGasVespenoDisponible < unaCantidadDeGasParaExtraer) {
            unaCantidadDeGasParaExtraer = this.cantidadDeGasVespenoDisponible;
            this.cantidadDeGasVespenoDisponible = 0;
            return unaCantidadDeGasParaExtraer;
        }

        this.cantidadDeGasVespenoDisponible = this.cantidadDeGasVespenoDisponible - unaCantidadDeGasParaExtraer;
        return unaCantidadDeGasParaExtraer;
    }
}