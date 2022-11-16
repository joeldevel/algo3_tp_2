package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Mapa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MapaTest {

    @Test
    void test01CreoUnMapaNuevoConCeroJugadoresYAlQuererSaberSiEstanEnExtremosOpuestosMeSaleUnError() {
        // Arrange
        Mapa mapa = new Mapa(0, 6);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            mapa.basesEstanEnExtremosOpuestos();
        });
    }

    @Test
    void test02CreoUnaMapaNuevoConDosJugadoresYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa(2, 6);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }
}
