package edu.fiuba.algo3.entrega_1.Recursos;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinRecolectorDeMineralConstruidoException;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralYaTieneUnRecolectorDeMineralException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
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
        Recursos recursos = new Recursos(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral primerNexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral segundoNexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test03SeIntentaConstruirUnNexoMineralEnUnNodoMineralDondeYaHayUnZanganoYSeLanzaUnaExcepcion(){
        Recursos recursos = new Recursos(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NodoMineral nodoMineral = new NodoMineral();

        Recursos recursosZerg = new Recursos(0,25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursosZerg);
        Zangano zangano = new Zangano(jugadorZerg);
        zangano.conNodo(nodoMineral);

        assertThrows(NodoMineralYaTieneUnRecolectorDeMineralException.class,()->{
            NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        });
    }

    @Test
    void test04SeConstruyeUnNexoMineralEnUnNodoMineralSinMineralYAlIntentarRecolectarSeLanzaUnaExcepcion(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);


        // Act & Assert
        assertThrows(NodoMineralSinMineralParaRecolectarException.class,()->{
            nexoMineral.avanzarTurno(205); // Avanzamos tantos turnos como sea necesario para que el Nodo no tenga mas mineral.
        });
    }

    @Test
    void test05SeConstruyeUnNexoMineralEnUnNodoMineralYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        // Act
        nexoMineral.avanzarTurno(5);

        // Assert
        assertEquals(10, nexoMineral.obtenerMineral());
    }

    @Test
    void test06SeConstruyeUnZanganoEnUnNodoMineralYAlAvanzarUnTurnoElZanganoRecolectaMineralYDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0,25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(jugadorZerg);
        zangano.conNodo(nodoMineral);

        // Act
        zangano.avanzarTurno();

        // Assert
        assertEquals(10, zangano.obtenerMineral());
    }
}