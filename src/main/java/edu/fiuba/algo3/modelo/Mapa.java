package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Areas.AreaEspacial;
import edu.fiuba.algo3.modelo.Areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.Areas.Base;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import java.util.ArrayList;

public class Mapa {

    static final int cantidadDeJugadores = 2;

    private int cantidadDeBases;

    private Base baseJugadorUno, baseJugadorDos;

    private int baseJugadorUnoPosicionX, baseJugadorUnoPosicionY, baseJugadorDosPosicionX, baseJugadorDosPosicionY;

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

        this.baseJugadorUnoPosicionX = 0;
        this.baseJugadorUnoPosicionY = 0;
        this.baseJugadorDosPosicionX = unaCantidadDeBases - 1;
        this.baseJugadorDosPosicionY = unaCantidadDeBases - 1;

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

        this.baseJugadorUno = this.bases.get(0);
        this.baseJugadorDos = this.bases.get(i - 1);
    }

    public boolean basesEstanEnExtremosOpuestos() {
        if ((this.baseJugadorUno.getX() == baseJugadorUnoPosicionX) && (this.baseJugadorUno.getY() == baseJugadorUnoPosicionY) && (this.baseJugadorDos.getX() == baseJugadorDosPosicionX) && (this.baseJugadorDos.getY() == baseJugadorDosPosicionY)) {
            return true;
        }

        return false;
    }
}

