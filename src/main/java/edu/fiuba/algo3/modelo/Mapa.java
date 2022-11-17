package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Areas.AreaEspacial;
import edu.fiuba.algo3.modelo.Areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.Areas.Base;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import java.util.ArrayList;

public class Mapa {

    private int cantidadDeBases;

    static final int cantidadDeJugadores = 2;

    private ArrayList<Base> bases;

    private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<AreaEspacial> areasEspaciales;

    public Mapa(int unaCantidadDeBases) {
        if (unaCantidadDeBases < cantidadDeJugadores) {
            throw new CantidadInsuficienteDeBasesException();
        }

        this.cantidadDeBases = unaCantidadDeBases;
        this.crearBase();
    }

    private void calcularTamanio() {

    }

    private void crearBase() {
        bases = new ArrayList<Base>();
        areasTerrestres = new ArrayList<AreaTerrestre>();
        areasEspaciales = new ArrayList<AreaEspacial>();

        for (int i = 0; i < this.cantidadDeBases; ++i) {
            bases.add(new Base(i, i));

            if (i < (this.cantidadDeBases - 1)) {
                areasTerrestres.add(new AreaTerrestre(i, i + 1));
                areasEspaciales.add(new AreaEspacial(i + 1, i));
            }
        }
    }

    public boolean basesEstanEnExtremosOpuestos() {
        /* Comparar bases si son iguales o equidistantes. */

        return true;
    }
}
