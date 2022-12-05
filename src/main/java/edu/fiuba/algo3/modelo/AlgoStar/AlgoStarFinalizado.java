package edu.fiuba.algo3.modelo.AlgoStar;

import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;

public class AlgoStarFinalizado implements AlgoStarEstado {

    public AlgoStarFinalizado() {
    }

    @Override
    public void avanzarTurno() {
        throw new AlgoStarFinalizadoException();
    }
}
