package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Mapa {

    private int cantidadDeBases;

    private ArrayList<Base> bases;

    public Mapa(int unaCantidadDeBases) {
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
        // Comparar bases si son iguales o equidistantes.

        return true;
    }
}
