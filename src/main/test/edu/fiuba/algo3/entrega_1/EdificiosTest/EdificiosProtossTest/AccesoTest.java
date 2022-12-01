package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccesoTest {

    @Test
    void test01SeConstruyeUnAccesoYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Falta implementar la logica de Acceso.
    }

    @Test
    void test02SeConstruyeUnAccesoYDespuesDeOchoTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Falta implementar la logica de Acceso.
    }

    @Test
    void test03SeConstruyeUnPuertoEstelarYRecibeDanio() {
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);

        // Act
        acceso.recibirAtaque(10);

        // Assert
        assertEquals(490, acceso.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPuertoEstelarQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(10);

        // Act
        acceso.avanzarTurno(1);

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.

        // Act
        acceso.avanzarTurno(25); // Recupera (500 x 0.05) = 25 de escudo por turno.

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        acceso.avanzarTurno(25);

        // Assert
        assertEquals(200, acceso.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnAccesoSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0, 149);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Acceso acceso = new Acceso(recursos, new Ubicacion(0,0), jugadorProtoss);
        });
    }
}