package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso32Test {

    @Test
    public void test01AlgoStarAvanzaDiezTurnosSinQueSeConstruyanEdificiosYSeFinaliza() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");

        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();

        assertThrows(AlgoStarFinalizadoException.class, () -> juego.avanzarTurno());
    }
}