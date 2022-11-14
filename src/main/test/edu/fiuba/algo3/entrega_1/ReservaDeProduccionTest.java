package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeProduccion;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void test03SeConstruyeUnaReservaDeProduccionYNoSeEncuentraOperativa(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            rdp.evolucionarLarva();
        });
    }

    @Test
    void test04SeConstruyeUnaReservaDeProduccionYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        ReservaDeProduccion rdp = new ReservaDeProduccion();
        
        rdp.avanzarTurno(12);

        // Act
        boolean resultado = rdp.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }
}
