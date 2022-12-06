package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public interface Jugador {
    boolean compararNombres(String otroNombre);
    boolean compararColores(String otroColor);
    boolean compararRazas(String otraRaza);
    void guardar(int costoGas, int costoMineral);
    void utilizar(int costoGas, int costoMineral);
    int obtenerGas();
    int obtenerMineral();
    void eliminarEdificio(Edificio unEdificio);
    void eliminarUnidad(Unidad unaUnidad);
    public boolean tieneEdificioEnUbicacion(Ubicacion unaUbicacion);
}

