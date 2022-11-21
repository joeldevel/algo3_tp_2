package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeProduccion;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservaDeProduccionTest {
	
    @Test
    void test01SeConstruyeUnaReservaDeProduccionYRecibeDanio(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursosJugador);

        // Act
        rdp.recibirAtaque(10);

        // Assert
        assertEquals(990, rdp.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnaReservaDeProduccionQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursosJugador);
        rdp.recibirAtaque(10);

        // Act
        rdp.avanzarTurno(1);

        // Assert
        assertEquals(1000, rdp.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnaReservaDeProduccionYNoSeEncuentraOperativa(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        ReservaDeProduccion rdp = new ReservaDeProduccion(recursosJugador);

        // Falta la logica de la Reserva de Produccion.
    }

    @Test
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
    }

    @Test
    void test05SeIntentaConstruirUnaGuaridaSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 149);

        assertThrows(SinRecursosSuficientesException.class,()->{
            ReservaDeProduccion rdp = new ReservaDeProduccion(recursosJugador);
        });
    }
}
