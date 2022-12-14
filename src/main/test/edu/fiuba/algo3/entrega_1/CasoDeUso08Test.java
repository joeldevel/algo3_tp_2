package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso08Test {

    Mapa mapa = new Mapa();

    /* Protoss */

    @Test
    void test07SeIntentaConstruirUnAccesoSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0, 149);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test08SeIntentaConstruirUnAsimiladorSinRecursosYSeLanzaUnaExcepcion() {
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test07SeIntentaConstruirUnNexoMineralSinRecursosYSeLanzaUnaExcepcion() {
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 49);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test07SeIntentaConstruirUnPilonSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0, 99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test07SeIntentaConstruirUnPuertoEstelarSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(149,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        });
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Zerg */

    @Test
    void test05SeIntentaConstruirUnCriaderoSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0,199);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        });
    }

    @Test
    void test05SeIntentaConstruirUnaEspiralSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(99,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        });
    }

    @Test
    void test10SeIntentaConstruirUnExtractorSinRecursosYSeLanzaUnaExcepcion() {
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,99);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        });
    }

    @Test
    void test08SeIntentaConstruirUnaGuaridaSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(99,199);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        });
    }

    @Test
    void test05SeIntentaConstruirUnaGuaridaSinRecursosYSeLanzaUnaExcepcion() {
        Recursos recursos = new Recursos(0,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        assertThrows(SinRecursosSuficientesException.class,()->{
            ReservaDeReproduccion rdp = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);
        });
    }
}
