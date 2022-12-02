package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PuertoEstelarTest {

    @Test
    void test01SeConstruyeUnPuertoEstelarYNoSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);

        // Falta implementar la logica de Puerto Estelar.
    }

    @Test
    void test02SeConstruyeUnPuertoEstelarYDespuesDeDiezTurnosSeEncuentraOperativo(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);

        // Falta implementar la logica de Puerto Estelar.
    }

    @Test
    void test03SeConstruyeUnPuertoEstelarYRecibeDanio() {
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);

        // Act
        puertoEstelar.recibirAtaque(10);

        // Assert
        assertEquals(590, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnPuertoEstelarQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente() {
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(10);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25); // Recupera (600 x 0.05) = 30 de escudo por turno.

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25);

        // Assert
        assertEquals(400, puertoEstelar.obtenerVida());
    }

    @Test
    void test07SeIntentaConstruirUnPuertoEstelarSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(149,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        });
    }
}