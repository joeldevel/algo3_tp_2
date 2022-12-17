package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso16Test {

    Mapa mapa = new Mapa();

    /* Nodo Mineral */

    @Test
    void test01SeCreaUnNodoMineralSinUnMineroYAlIntentarRecolectarMineralSeLanzaExcepcion(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        int unaCantidadExtraible = 50;

        // Act
        int gasExtraido = nodoMineral.recolectarMineral(unaCantidadExtraible);

        // Assert
        assertEquals(0, gasExtraido);
    }

    @Test
    void test02SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnNexoMineralConstruidoYSeLanzaUnaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral primerNexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral segundoNexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test03SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnZanganoYSeLanzaUnaExcepcion(){
        Recursos recursos = new Recursos(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));

        Recursos recursosZerg = new Recursos(0,25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursosZerg, mapa);
        Zangano zangano = new Zangano(jugadorZerg);
        zangano.trabajarEn(nodoMineral);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Volcan */

    @Test
    void test01SeCreaUnVolcanSinUnaRefineriaDeGasYAlIntentarExtraerGasSeLanzaExcepcion(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        int unaCantidadExtraible = 50;

        // Act
        int gasExtraido = volcan.extraerGas(unaCantidadExtraible);

        // Assert
        assertEquals(0, gasExtraido);
    }

    @Test
    void test02SeIntentaConstruirUnExtractorEnUnVolcanDondeYaHayUnExtractorConstruidoYSeLanzaUnaExcepcion(){
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor primerExtractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        assertThrows(VolcanYaTieneUnaRefineriaDeGasConstruidaException.class,()->{
            Extractor segundoExtractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        });
    }
}
