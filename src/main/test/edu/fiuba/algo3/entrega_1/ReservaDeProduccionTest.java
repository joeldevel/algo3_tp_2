package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReservaDeProduccionTest {

    @Test
    void test01SeConstruyeUnaReservaDeProduccionYRecibeDanio(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion();
        rdp.recibirDanio(10);

        // Act
        int resultado = rdp.obtenerVida();

        // Assert
        assertEquals(resultado, 990);
    }

    @Test
    void test02SeConstruyeUnaReservaDeProduccionQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion();
        rdp.recibirDanio(10);

        // Act
        rdp.avanzarTurno();

        // Assert
        assertEquals(rdp.obtenerVida(), 1000);
    }
}
