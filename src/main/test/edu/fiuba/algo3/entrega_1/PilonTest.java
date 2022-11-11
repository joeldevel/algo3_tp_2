package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Pilon.Pilon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PilonTest {

    @Test
    void test01SeConstruyeUnPilonYNoSeEncuentraOperativo(){
        // Arrange
        Pilon pilon = new Pilon();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            pilon.energizar();
        });
    }

    @Test
    void test02SeConstruyeUnPilonYDespuesDeCincoTurnosSeEncuentraOperativO(){
        // Arrange
        Pilon pilon = new Pilon();

        pilon.avanzarTurno();
        pilon.avanzarTurno();
        pilon.avanzarTurno();
        pilon.avanzarTurno();
        pilon.avanzarTurno();

        // Act
        boolean resultado = pilon.energizar();

        // Assert
        assertTrue(resultado);
    }
}

