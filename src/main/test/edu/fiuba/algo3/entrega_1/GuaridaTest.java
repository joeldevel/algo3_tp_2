package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Guarida.Guarida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GuaridaTest {
    /* A guarida le falta el prerequisito de reserva de producción. */
    @Test
    void test01SeConstruyeUnaGuaridaYNoSeEncuentraOperativa(){
        // Arrange
        Guarida guarida = new Guarida();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            guarida.evolucionarLarva();
        });
    }

    @Test
    void test02SeConstruyeUnaGuaridaYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        Guarida guarida = new Guarida();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();
        guarida.avanzarTurno();

        // Act
        boolean resultado = guarida.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }
}
