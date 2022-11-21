package edu.fiuba.algo3.entrega_1.Repetidos;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

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
