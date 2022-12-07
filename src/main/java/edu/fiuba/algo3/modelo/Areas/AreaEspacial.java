package edu.fiuba.algo3.modelo.Areas;

import edu.fiuba.algo3.modelo.Ubicacion;

public class AreaEspacial {

    private Ubicacion ubicacion;

    boolean estaOcupada;

    public AreaEspacial(int x, int y) {
        this.ubicacion = new Ubicacion(x, y);
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

    public void desocupar() {
        this.estaOcupada = false;
    }

    public boolean estaOcupada() {
        return (this.estaOcupada);
    }
}
