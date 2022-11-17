package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Areas.AreaEspacial;
import edu.fiuba.algo3.modelo.Areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.Areas.Base;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import java.util.ArrayList;

public class Mapa {

    private int cantidadDeBases;

    static final int cantidadDeJugadores = 2;

    private Base baseJugadorUno, baseJugadorDos;

    private ArrayList<Base> bases;

    private ArrayList<AreaTerrestre> areasTerrestres;

    private ArrayList<AreaEspacial> areasEspaciales;

    public Mapa(int unaCantidadDeBases) {
        if (unaCantidadDeBases < cantidadDeJugadores) {
            throw new CantidadInsuficienteDeBasesException();
        }

        this.cantidadDeBases = unaCantidadDeBases;
        this.bases = new ArrayList<Base>();
        this.areasTerrestres = new ArrayList<AreaTerrestre>();
        this.areasEspaciales = new ArrayList<AreaEspacial>();

        this.crearAreas();
    }

    private void crearAreas() {
        int i;

        for (i = 0; i < this.cantidadDeBases; ++i) {
            this.bases.add(new Base(i, i));

            if (i < (this.cantidadDeBases - 1)) {
                this.areasTerrestres.add(new AreaTerrestre(i, i + 1));
                this.areasEspaciales.add(new AreaEspacial(i + 1, i));
            }
        }

        //baseJugadorUno = this.bases.get(0);
        //baseJugadorDos = this.bases.get(i);
    }

    public boolean basesEstanEnExtremosOpuestos() {
        /* Comparar bases si son iguales o equidistantes. */

        return true;
    }
}

