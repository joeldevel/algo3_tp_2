package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspiralTest {
	
    @Test
    void test01SeConstruyeUnaEspiralYRecibeDanio(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 150);
        Espiral espiral = new Espiral(recursosJugador, new Ubicacion(0,0));

        // Act
        espiral.recibirAtaque(10);

        // Assert
        assertEquals(1290, espiral.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnaEspiralQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 150);
        Espiral espiral = new Espiral(recursosJugador, new Ubicacion(0,0));
        espiral.recibirAtaque(10);

        // Act
        espiral.avanzarTurno(1);

        // Assert
        assertEquals(1300, espiral.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnaEspiralYNoSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 150);
        Espiral espiral = new Espiral(recursosJugador, new Ubicacion(0,0));

        // Falta la logica de Espiral.
    }

    @Test
    void test04SeConstruyeUnaEspiralYDespuesDeDiezTurnosSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 150);
        Espiral espiral = new Espiral(recursosJugador, new Ubicacion(0,0));
        
       // Falta la logica de Espiral.
    }

    @Test
    void test05SeIntentaConstruirUnaEspiralSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 149);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Espiral espiral = new Espiral(recursosJugador, new Ubicacion(0,0));
        });
    }
}
