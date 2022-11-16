package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Base {

    private Volcan volcan;

    private ArrayList<NodoMineral> nodosMinerales;

    private Ubicacion ubicacion;

    public Base() {
        this.volcan = new Volcan(5000);
        this.ubicacion = new Ubicacion();
        nodosMinerales = new ArrayList<NodoMineral>() {{ add(new NodoMineral(2000)); add(new NodoMineral(2000)); add(new NodoMineral(2000));}};
    }
}
