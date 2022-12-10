package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;

public interface AlgoStarEstado {
    Jugador obtenerJugadorContrario(Jugador jugadorTurno);
    Mapa obtenerMapa();
    void avanzarTurno();
    Jugador obtenerJugadorTurno();
}
