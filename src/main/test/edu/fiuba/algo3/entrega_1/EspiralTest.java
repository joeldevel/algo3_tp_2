package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Espiral.Espiral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EspiralTest {

    @Test
    void test01SeConstruyeUnaEspiralYRecibeDanio(){
        // Arrange
        Espiral espiral = new Espiral(1300, -10, 150, 100);
        espiral.recibirDanio(10);

        // Act
        int resultado = espiral.obtenerVida();

        // Assert
        assertEquals(resultado, 1290);
    }

    @Test
    void test02SeConstruyeUnaEspiralQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Espiral espiral = new Espiral(1300, -10, 150, 100);
        espiral.recibirDanio(10);

        // Act
        espiral.avanzarTurno();

        // Assert
        assertEquals(espiral.obtenerVida(), 1300);
    }
}
