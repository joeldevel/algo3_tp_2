package edu.fiuba.algo3.modelo;

public class Mineral {

    public Mineral(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean sePuedeMinar(int cantidad) {
        return this.cantidadDisponible >= cantidad;
    }

    public int extraer(int cantidad) {
        if (this.cantidadDisponible >= cantidad) {
            this.cantidadDisponible -= cantidad;
            return cantidad;
        }
        return 0;
    }

    private int cantidadDisponible;
}