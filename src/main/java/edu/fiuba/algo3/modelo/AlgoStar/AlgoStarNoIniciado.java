package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Mapa;

public class AlgoStarNoIniciado implements AlgoStarEstado {

    Mapa mapa;
    public AlgoStarNoIniciado(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public Jugador obtenerJugadorContrario(Jugador jugadorTurno) {
        throw new AlgoStarFinalizadoException();
    }

    @Override
    public Mapa obtenerMapa() {
        return this.mapa;
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