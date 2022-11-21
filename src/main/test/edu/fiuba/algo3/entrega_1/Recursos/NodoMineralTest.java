package edu.fiuba.algo3.entrega_1.Recursos;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinRecolectorDeMineralConstruidoException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodoMineralTest {

    @Test
    void test01SeCreaUnNodoMineralSinUnMineroYAlIntentarRecolectarMineralSeLanzaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral();
        int unaCantidadExtraible = 50;

        assertThrows(NodoMineralSinRecolectorDeMineralConstruidoException.class,()->{
            int mineralRecolectado = nodoMineral.recolectarMineral(unaCantidadExtraible);
        });
    }

    @Test
    void test02SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnNexoMineralConstruidoYSeLanzaUnaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        NexoMineral primerNexoMineral = new NexoMineral(nodoMineral, recursosJugador);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral segundoNexoMineral = new NexoMineral(nodoMineral, recursosJugador);
        });
    }

    @Test
    void test03SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnZanganoYSeLanzaUnaExcepcion(){
        NodoMineral nodoMineral = new NodoMineral();
        Zangano zangano = new Zangano();
        zangano.conNodo(nodoMineral);

        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 50);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral nexoMineral = new NexoMineral(nodoMineral, recursosJugador);
        });
    }

    @Test // Hay que recolectar el mineral hasta que se quede vacio.
    void test04SeConstruyeUnNexoMineralEnUnNodoMineralSinMineralYAlIntentarRecolectarSeLanzaUnaExcepcion(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 50);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, recursosJugador);

        // Act & Assert
        assertThrows(NodoMineralSinMineralParaRecolectarException.class,()->{
            nexoMineral.avanzarTurno(5);
        });
    }

    @Test
    void test05SeConstruyeUnNexoMineralEnUnNodoMineralYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 50);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, recursosJugador);

        // Act
        nexoMineral.avanzarTurno(5);

        // Assert
        assertEquals(10, nexoMineral.obtenerMineral());
    }

    @Test
    void test06SeConstruyeUnZanganoEnUnNodoMineralYAlAvanzarUnTurnoElZanganoRecolectaMineralYDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Zangano zangano = new Zangano();
        zangano.conNodo(nodoMineral);

        // Act
        zangano.avanzarTurno();

        // Assert
        assertEquals(10, zangano.obtenerMineral());
    }
}