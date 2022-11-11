package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.NexoMineral.NexoMineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodoMineralTest {

    @Test
    void test01SeCreaUnNodoMineralSinUnRecolectorDeMineralYAlIntentarRecolectarMineralSeLanzaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral(2000);

        assertThrows(NodoMineralSinRecolectorDeMineralConstruidoException.class,()->{
            int mineralRecolectado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();
        });
    }

    @Test
    void test02SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnNexoMineralConstruidoYSeLanzaUnaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral(2000);
        NexoMineral primerNexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        NexoMineral segundoNexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        nodoMineral.construirRecolectorDeMineral(primerNexoMineral);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            nodoMineral.construirRecolectorDeMineral(segundoNexoMineral);
        });
    }

    @Test
    void test03SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnZanganoYSeLanzaUnaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral(2000);
        Zangano zangano = new Zangano(10);
        NexoMineral nexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        nodoMineral.construirRecolectorDeMineral(zangano);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            nodoMineral.construirRecolectorDeMineral(nexoMineral);
        });
    }

    @Test
    void test04SeConstruyeUnNexoMineralEnUnNodoMineralSinMineralYAlIntentarRecolectarSeLanzaUnaExcepcion(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(0);
        NexoMineral nexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        nodoMineral.construirRecolectorDeMineral(nexoMineral);
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();

        // Act & Assert
        assertThrows(NodoMineralSinMineralParaRecolectarException.class,()->{
            int mineralRecolectado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();
        });
    }

    @Test
    void test05SeConstruyeUnNexoMineralEnUnNodoMineralYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        NexoMineral nexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        NodoMineral nodoMineral = new NodoMineral(2000);
        nodoMineral.construirRecolectorDeMineral(nexoMineral);

        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();

        // Act
        int resultado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();

        // Assert
        assertEquals(resultado, 10);
    }

    @Test
    void test06SeConstruyeUnZanganoEnUnNodoMineralYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        Zangano zangano = new Zangano(10);
        NodoMineral nodoMineral = new NodoMineral(2000);
        nodoMineral.construirRecolectorDeMineral(zangano);

        // Act
        int resultado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();

        // Assert
        assertEquals(resultado, 10);
    }
}
