package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Raza;

public interface Jugador {
    void guardar(int costoGas, int costoMineral);
    void utilizar(int costoGas, int costoMineral);
    int obtenerGas();
    int obtenerMineral();
    void eliminar(Raza unaEntidad);
}

