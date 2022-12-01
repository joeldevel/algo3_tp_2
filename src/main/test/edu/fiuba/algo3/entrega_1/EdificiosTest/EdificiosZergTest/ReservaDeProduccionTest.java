package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeProduccion;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaDeProduccionTest {
	
    @Test
    void test01SeConstruyeUnaReservaDeProduccionYRecibeDanio(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursos, new Ubicacion(0,0), jugadorZerg);

        // Act
        rdp.recibirAtaque(10);

        // Assert
        assertEquals(990, rdp.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnaReservaDeProduccionQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursos, new Ubicacion(0,0), jugadorZerg);
        rdp.recibirAtaque(10);

        // Act
        rdp.avanzarTurno(1);

        // Assert
        assertEquals(1000, rdp.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnaReservaDeProduccionYNoSeEncuentraOperativa(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursos, new Ubicacion(0,0), jugadorZerg);

        // Falta la logica de la Reserva de Produccion.
    }

    /*@Test
    void test04SeConstruyeUnaReservaDeProduccionYDespuesDeDoceTurnosSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursosJugador);
        rdp.avanzarTurno(12);

        // Act
        boolean resultado = rdp.evolucionarLarva();

        // Assert
        assertTrue(resultado);
    }*/

    @Test
    void test05SeIntentaConstruirUnaGuaridaSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            ReservaDeProduccion rdp = new ReservaDeProduccion(recursos, new Ubicacion(0,0), jugadorZerg);
        });
    }
}
