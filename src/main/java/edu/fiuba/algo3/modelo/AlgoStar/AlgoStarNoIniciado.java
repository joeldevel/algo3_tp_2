package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;

public class AlgoStarNoIniciado implements AlgoStarEstado {

    public AlgoStarNoIniciado() {
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