package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Guarida.Guarida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuaridaTest {

    @Test
    void test01SeConstruyeUnaGuaridaYRecibeDanio(){
        // Arrange
        Guarida guarida = new Guarida();
        guarida.recibirDanio(10);

        // Act
        int resultado = guarida.obtenerVida();

        // Assert
        assertEquals(resultado, 1240);
    }

    @Test
    void test02SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Guarida guarida = new Guarida();
        guarida.recibirDanio(10);

        // Act
        guarida.avanzarTurno();

        // Assert
        assertEquals(guarida.obtenerVida(), 1250);
    }
}
