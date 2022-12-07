package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public interface AlgoStarEstado {
    void avanzarTurno();
    Jugador obtenerJugadorTurno();
}