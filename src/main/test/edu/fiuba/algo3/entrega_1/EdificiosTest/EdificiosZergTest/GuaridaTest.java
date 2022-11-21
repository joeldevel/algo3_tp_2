package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuaridaTest {
	
    @Test
    void test01SeConstruyeUnaGuaridaYNoSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);

        // Falta la logica de Guarida.
    }

    @Test
    void test02SeConstruyeUnaGuaridaYRecibeDanioAunSinEstarOperativaYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnaGuaridaYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);
        guarida.avanzarTurno(12);

        // Act
        boolean resultado = guarida.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test04SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);
        guarida.avanzarTurno(12);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test05SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);
        guarida.avanzarTurno(12);
        guarida.recibirAtaque(10);

        // Act
        guarida.avanzarTurno(1);

        // Assert
        assertEquals(1250, guarida.obtenerVida());
    }


    @Test
    void test06SeConstruyeUnaGuaridaYRecibeDanio(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test07SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 200);
        Guarida guarida = new Guarida(recursosJugador);
        guarida.recibirAtaque(10);

        // Act
        guarida.avanzarTurno(1);

        // Assert
        assertEquals(1250, guarida.obtenerVida());
    }

    @Test
    void test08SeIntentaConstruirUnaGuaridaSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(100, 199);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Guarida guarida = new Guarida(recursosJugador);
        });
    }
}