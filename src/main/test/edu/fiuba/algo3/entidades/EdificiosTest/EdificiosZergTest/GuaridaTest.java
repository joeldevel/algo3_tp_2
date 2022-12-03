package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuaridaTest {

    @Test
    void test02SeConstruyeUnaGuaridaYRecibeDanioAunSinEstarOperativaYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    /*@Test
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
    }*/

    @Test
    void test04SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.avanzarTurno(12);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test05SeConstruyeUnaGuaridaYDespuesDeDoceTurnosRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
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
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test07SeConstruyeUnaGuaridaQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.recibirAtaque(10);

        // Act
        guarida.avanzarTurno(1);

        // Assert
        assertEquals(1250, guarida.obtenerVida());
    }
}