package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EspiralTest {
	
    @Test
    void test01SeConstruyeUnaEspiralYRecibeDanio(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act
        espiral.recibirAtaque(10);

        // Assert
        assertEquals(1290, espiral.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnaEspiralQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        espiral.recibirAtaque(10);

        // Act
        espiral.avanzarTurno(1);

        // Assert
        assertEquals(1300, espiral.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnaEspiralYNoSeEncuentraOperativa(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Falta la logica de Espiral.
    }

    @Test
    void test04SeConstruyeUnaEspiralYDespuesDeDiezTurnosSeEncuentraOperativa(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        
       // Falta la logica de Espiral.
    }

    @Test
    void test05SeIntentaConstruirUnaEspiralSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(99,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        });
    }
}
