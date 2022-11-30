package edu.fiuba.algo3.modelo;

public interface Revelable {

    void serRevelado();

    public Ubicacion ubicacion();

    public Superficie obtenerSuperficie();

    boolean compararSuperficie(String otraSuperficie);
}
