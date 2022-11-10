package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.CostoDeConstruccion;
import edu.fiuba.algo3.modelo.EnConstruccion;
import edu.fiuba.algo3.modelo.EstadoDeEdificio;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Larva;
import edu.fiuba.algo3.modelo.Moho;
import edu.fiuba.algo3.modelo.RequisitoDeConstruccion;
import edu.fiuba.algo3.modelo.ReservaDeProduccion.ReservaDeProduccion;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Espiral.Espiral;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EspiralTest {
	
	Vida vida = new Vida(1300,10);
	Tiempo tiempo = new Tiempo(-10);
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	ArrayList<CostoDeConstruccion> costos = new ArrayList<CostoDeConstruccion>();

    @Test
    void test01SeConstruyeUnaEspiralYRecibeDanio(){
        // Arrange
        Espiral espiral = new Espiral(vida, tiempo, requisitos, costos);
        espiral.recibirDanio(10);

        // Act
        int resultado = espiral.obtenerVida();

        // Assert
        assertEquals(resultado, 1290);
    }

    @Test
    void test02SeConstruyeUnaEspiralQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Espiral espiral = new Espiral(vida, tiempo, requisitos, costos);
        espiral.recibirDanio(10);

        // Act
        espiral.avanzarTurno();

        // Assert
        assertEquals(espiral.obtenerVida(), 1300);
    }

    @Test
    void test03SeConstruyeUnaEspiralYNoSeEncuentraOperativa(){
        // Arrange
        Espiral espiral = new Espiral(vida, tiempo, requisitos, costos);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class,()->{
            espiral.crear();
        });
    }

    @Test
    void test04SeConstruyeUnaEspiralYDespuesDeDiezTurnosSeEncuentraOperativa(){
        // Arrange
        Espiral espiral = new Espiral(vida, tiempo, requisitos, costos);
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();
        espiral.avanzarTurno();

        // Act
        boolean resultado = espiral.crear();

        // Assert
        assertTrue(resultado);
    }
}
