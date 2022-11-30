package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.Excepciones.AlgoStarFinalizadoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

// Cuando se instancia AlgoStar ya se considera como inicializado el juego.

public class CasoDeUso32Test {

    @Test
    @DisplayName("Un juego iniciado puede ser finalizado")
    public void test01AlgoStarInicializadoEsFinalizado() {
        AlgoStar juego = new AlgoStar();
        juego.finalizarAlgoStar();
        assertThrows(AlgoStarFinalizadoException.class, () -> juego.avanzarTurno());
    }
}
