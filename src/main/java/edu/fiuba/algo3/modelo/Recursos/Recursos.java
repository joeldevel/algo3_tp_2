package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;

public class Recursos {

    public int cantidadDeGas;
    public int cantidadDeMineral;

    public Recursos() {
        this.cantidadDeGas = 0;
        this.cantidadDeMineral = 0;
    }

    // Constructor utilizado unicamente para simplificar pruebas.
    public Recursos(int unaCantidadDeGas, int unaCantidadDeMineral) {
        this.cantidadDeGas = unaCantidadDeGas;
        this.cantidadDeMineral = unaCantidadDeMineral;
    }

    public void guardar(int unaCantidadDeGas, int unaCantidadDeMineral) {
        this.cantidadDeGas += unaCantidadDeGas;
        this.cantidadDeMineral += unaCantidadDeMineral;
    }

    public void utilizar(int unaCantidadDeGas, int unaCantidadDeMineral) {

        if((this.obtenerGas() - unaCantidadDeGas < 0) || (this.obtenerMineral() - unaCantidadDeMineral < 0)) {
            throw new SinRecursosSuficientesException();
        }

        this.cantidadDeGas -= unaCantidadDeGas;
        this.cantidadDeMineral -= unaCantidadDeMineral;
    }

    public int obtenerGas() {
        return this.cantidadDeGas;
    }

    public int obtenerMineral() {
        return this.cantidadDeMineral;
    }
}