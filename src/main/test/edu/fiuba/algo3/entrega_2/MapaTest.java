package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Mapa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MapaTest {
    @Test
    void test01CreoUnaMapaNuevoYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 6);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }
}
