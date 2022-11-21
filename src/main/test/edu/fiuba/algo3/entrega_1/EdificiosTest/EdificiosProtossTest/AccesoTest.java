package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccesoTest {

    @Test
    void test01SeConstruyeUnAccesoYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);

        // Falta implementar la logica de Acceso.
    }

    @Test
    void test02SeConstruyeUnAccesoYDespuesDeOchoTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);

        // Falta implementar la logica de Acceso.
    }

    @Test
    void test03SeConstruyeUnPuertoEstelarYRecibeDanio() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);

        // Act
        acceso.recibirAtaque(10);

        // Assert
        assertEquals(490, acceso.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPuertoEstelarQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);
        acceso.recibirAtaque(10);

        // Act
        acceso.avanzarTurno(1);

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.

        // Act
        acceso.avanzarTurno(25); // Recupera (500 x 0.05) = 25 de escudo por turno.

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 150);
        Acceso acceso = new Acceso(recursosJugador);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        acceso.avanzarTurno(25);

        // Assert
        assertEquals(200, acceso.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnAccesoSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 149);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Acceso acceso = new Acceso(recursosJugador);
        });
    }
}