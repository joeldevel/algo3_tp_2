package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

import java.util.ArrayList;

public class Mapa {

    private int cantidadDeJugadores;

    private int cantidadDeBases;

    private ArrayList<Base> bases;

    public Mapa(int unaCantidadDeJugadores, int unaCantidadDeBases) {
        this.cantidadDeJugadores = unaCantidadDeJugadores;
        this.cantidadDeBases = unaCantidadDeBases;
        this.crearBase();
    }

    private void calcularTamanio() {

    }

    private void crearBase() {
        bases = new ArrayList<Base>();
        for (int i = 1; i <= this.cantidadDeBases; ++i) {
            bases.add(new Base());
        }
    }

    public boolean basesEstanEnExtremosOpuestos() {
        if (this.cantidadDeJugadores == 0) {
            throw new EdificioNoOperativoException();
        }
        // Comparar bases si son iguales o equidistantes.

        return true;
    }
}
