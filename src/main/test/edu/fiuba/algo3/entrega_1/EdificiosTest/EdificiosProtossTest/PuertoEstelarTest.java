package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuertoEstelarTest {

    @Test
    void test01SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);

        // Falta implementar la logica de Puerto Estelar.
    }

    @Test
    void test02SeConstruyeUnPuertoEstelarYDespuesDeDiezTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);

        // Falta implementar la logica de Puerto Estelar.
    }

    @Test
    void test03SeConstruyeUnPuertoEstelarYRecibeDanio() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);

        // Act
        puertoEstelar.recibirAtaque(10);

        // Assert
        assertEquals(590, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPuertoEstelarQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);
        puertoEstelar.recibirAtaque(10);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25); // Recupera (600 x 0.05) = 30 de escudo por turno.

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(150, 150);
        PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25);

        // Assert
        assertEquals(400, puertoEstelar.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnPuertoEstelarSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(149, 150);

        assertThrows(SinRecursosSuficientesException.class,()->{
            PuertoEstelar puertoEstelar = new PuertoEstelar(recursosJugador);
        });
    }
}