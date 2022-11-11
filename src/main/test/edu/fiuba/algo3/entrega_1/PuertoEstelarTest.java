package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.PuertoEstelar.PuertoEstelar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuertoEstelarTest {

    @Test
    void test01SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            puertoEstelar.transportarUnidades();
        });
    }

    @Test
    void test02SeConstruyeUnPuertoEstelarYDespuesDeDiezTurnosSeEncuentraOperativo(){
        // Arrange
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        
        puertoEstelar.avanzarTurno(10);
        // Act
        boolean resultado = puertoEstelar.transportarUnidades();

        // Assert
        assertTrue(resultado);
    }
}
