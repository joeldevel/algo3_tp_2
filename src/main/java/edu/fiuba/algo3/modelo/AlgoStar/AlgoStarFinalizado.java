package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;

public class AlgoStarFinalizado implements AlgoStarEstado {

    public AlgoStarFinalizado() {
    }

    @Override
    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {
        throw new AlgoStarFinalizadoException();
    }

    @Override
    public Mapa obtenerMapa() {
        throw new AlgoStarFinalizadoException();
    }

    @Override
    public void avanzarTurno() {
        throw new AlgoStarFinalizadoException();
    }

    @Override
    public Jugador obtenerJugadorTurno() {
        throw new AlgoStarFinalizadoException();
    }
}