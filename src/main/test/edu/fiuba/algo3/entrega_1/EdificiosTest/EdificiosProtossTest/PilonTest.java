package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PilonTest {

    @Test
    void test01SeConstruyeUnPilonYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);

        // Falta implementar la logica de Pilon.
    }

    @Test
    void test02SeConstruyeUnPilonYDespuesDeOchoTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);

        // Falta implementar la logica de Pilon.
    }

    @Test
    void test03SeConstruyeUnPilonYRecibeDanio() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);

        // Act
        pilon.recibirAtaque(10);

        // Assert
        assertEquals(290, pilon.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPilonQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);
        pilon.recibirAtaque(10);

        // Act
        pilon.avanzarTurno(1);

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25); // Recupera (300 x 0.05) = 15 de escudo por turno.

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Pilon pilon = new Pilon(recursosJugador);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25);

        // Assert
        assertEquals(100, pilon.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnPilonSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 99);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Pilon pilon = new Pilon(recursosJugador);
        });
    }
}