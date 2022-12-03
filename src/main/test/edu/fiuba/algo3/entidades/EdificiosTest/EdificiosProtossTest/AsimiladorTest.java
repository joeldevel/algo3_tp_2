package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosProtossTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsimiladorTest {
    

    @Test
    void test02SeConstruyeUnAsimiladorEnUnVolcanYSeAvanzanSieteTurnosYSeDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.avanzarTurno(7);

        // Assert
        assertEquals(20, asimilador.obtenerGas());
    }

    @Test
    void test03SeConstruyeUnAsimiladorEnUnVolcanYSeAvanzanDiezTurnosYSeDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.avanzarTurno(10);

        // Assert
        assertEquals(80, asimilador.obtenerGas());
    }

    @Test
    void test04SeConstruyeUnaAsimiladorYRecibeDanio(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.recibirAtaque(10);

        // Assert
        assertEquals(440, asimilador.obtenerEscudo());
    }

    @Test
    void test05SeConstruyeUnExtractorQueRecibeDanioYAlAvanzarElTurnoRecuperaSuEscudoCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(10);

        // Act
        asimilador.avanzarTurno(1);

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(600); // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.

        // Act
        asimilador.avanzarTurno(25); // Recupera (450 x 0.05) = 22 de escudo por turno.

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test07SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(600); // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.

        // Act
        asimilador.avanzarTurno(25);

        // Assert
        assertEquals(300, asimilador.obtenerVida());
    }

    @Test
    void test08SeIntentaConstruirUnAsimiladorSinRecursosYSeLanzaUnaExcepcion() {
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        });
    }
}