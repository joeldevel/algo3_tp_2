package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PilonTest {

    @Test
    void test01SeConstruyeUnPilonYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Falta implementar la logica de Pilon.
    }

    @Test
    void test02SeConstruyeUnPilonYDespuesDeOchoTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Falta implementar la logica de Pilon.
    }

    @Test
    void test03SeConstruyeUnPilonYRecibeDanio() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Act
        pilon.recibirAtaque(10);

        // Assert
        assertEquals(290, pilon.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPilonQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(10);

        // Act
        pilon.avanzarTurno(1);

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25); // Recupera (300 x 0.05) = 15 de escudo por turno.

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25);

        // Assert
        assertEquals(100, pilon.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnPilonSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0, 99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Pilon pilon = new Pilon(recursos, new Ubicacion(0,0), jugadorProtoss);
        });
    }
}