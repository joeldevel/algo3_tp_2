package edu.fiuba.algo3.modelo.Areas;

import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;
import Volcan;

import java.util.ArrayList;

public class Base {

    private Volcan volcan;

    private ArrayList<NodoMineral> nodosMinerales;

    private Ubicacion ubicacion;

    public Base(int x, int y) {
        this.volcan = new Volcan(5000);
        this.ubicacion = new Ubicacion(x, y);
        nodosMinerales = new ArrayList<NodoMineral>() {{ add(new NodoMineral(2000)); add(new NodoMineral(2000)); add(new NodoMineral(2000));}};
    }

    public int obtenerX() {
        return this.ubicacion.obtenerX();
    }

    public int obtenerY() {
        return this.ubicacion.obtenerY();
    }
}
