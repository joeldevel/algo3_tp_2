package edu.fiuba.algo3.modelo;

public class Volcan {

    private RefineriaDeGas refineria;
    private int cantidadDeGasVespenoDisponible;

    public Volcan() {
        this.refineria = null;
        this.cantidadDeGasVespenoDisponible = 5000;
    }

    public void construirRefineriaDeGas(RefineriaDeGas unaRefineria) {
        /* Chequear que el tipo de parametro sea RefineriaDeGas. En caso contrario, lanzar excepcion. */
        this.refineria = unaRefineria;
    }

    public int extraerGasUsandoRefineria() {
        return this.refineria.extraerGasUsandoRefineria(this);
    }

    public int extraerGas(int unaCantidadDeGasParaExtraer) {
        /* Falta tener en cuenta el caso borde donde por ejemplo tenemos 20 de gas y nos piden 30. Deberiamos devolver esos 20. */
        return unaCantidadDeGasParaExtraer;
    }
}