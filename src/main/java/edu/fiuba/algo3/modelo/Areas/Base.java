package edu.fiuba.algo3.modelo.Areas;

import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Ubicacion;

import java.util.ArrayList;

public class Base {

    private Volcan volcan;

    private ArrayList<NodoMineral> nodosMinerales;

    private Ubicacion ubicacion;

    boolean estaOcupada;

    public Base(int x, int y) {
        this.volcan = new Volcan(ubicacion);
        this.ubicacion = new Ubicacion(x, y);
        nodosMinerales = new ArrayList<NodoMineral>() {{ add(new NodoMineral(ubicacion)); add(new NodoMineral(ubicacion)); add(new NodoMineral(ubicacion));}};
        this.estaOcupada = false;
    }

    public int obtenerX() {
        return this.ubicacion.obtenerX();
    }

    public int obtenerY() {
        return this.ubicacion.obtenerY();
    }

    public void ocupar() {
        this.estaOcupada = true;
    }

    public boolean estaOcupada() {
        return (this.estaOcupada);
    }
}
