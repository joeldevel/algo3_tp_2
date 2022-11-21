package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.AlgoStar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Caso31VerificarFinDeJuego {

    @Test
    @DisplayName("Un juego no iniciado no puede ser finalizado")
    public void juegoNoInicialdoTest() {
        AlgoStar juego = new AlgoStar();

        Assertions.assertThrows(Exception.class, () -> juego.finalizar());
    }

    @Test
    @DisplayName("Un juego iniciado puede ser finalizado")
    public void juegoInicialdoTest() {
        AlgoStar juego = new AlgoStar();
        juego.iniciar();
        Assertions.assertDoesNotThrow(juego::finalizar);
    }
}
