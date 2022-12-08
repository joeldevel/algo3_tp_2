package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class AlgoStarFinalizado implements AlgoStarEstado {

    public AlgoStarFinalizado() {
    }

    @Override
    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {
        return null;
    }

    @Override
    public void avanzarTurno() {
        throw new AlgoStarFinalizadoException();
    }

    @Override
    public Jugador obtenerJugadorTurno() {
        return null;
    }
}