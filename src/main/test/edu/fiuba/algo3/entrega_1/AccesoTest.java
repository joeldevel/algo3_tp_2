package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Acceso.Acceso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccesoTest {

    @Test
    void test01SeConstruyeUnAccesoYNoSeEncuentraOperativo(){
        // Arrange
        Acceso acceso = new Acceso();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            acceso.transportarTropas();
        });
    }

    @Test
    void test02SeConstruyeUnaGuaridaYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        Acceso acceso = new Acceso();

        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();
        acceso.avanzarTurno();

        // Act
        boolean resultado = acceso.transportarTropas();

        // Assert
        assertTrue(resultado);
    }
}
