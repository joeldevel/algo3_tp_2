package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccionUtilizable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaDeProduccionTest {
    @Test
    void test01SeConstruyeUnaReservaDeProduccionYNoSeEncuentraOperativa(){
        // Arrange
        ReservaDeProduccion reservaDeProduccion = new ReservaDeProduccion();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            reservaDeProduccion.evolucionarLarva();
        });
    }

    @Test
    void test02SeConstruyeUnaReservaDeProduccionYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        ReservaDeProduccion reservaDeProduccion = new ReservaDeProduccion();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();
        reservaDeProduccion.avanzarTurno();

        // Act
        boolean resultado = reservaDeProduccion.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }
}