package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso07Test {

    Mapa mapa = new Mapa();

    /* Protoss */

    @Test
    void test01SeConstruyeUnNexoMineralEnUnNodoMineralYSeAvanzanCincoTurnosDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        // Act
        nexoMineral.avanzarTurno(5);

        // Assert
        assertEquals(10, jugadorProtoss.obtenerMineral());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Zerg */

    @Test
    void test02SeConstruyeUnZanganoEnUnNodoMineralYSeAvanzanTresTurnosDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Zangano tipoZangano =  new Zangano(jugadorZerg);
        Unidad zangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoZangano);
        zangano.avanzarTurno(1);
        zangano.conNodo(nodoMineral);

        // Act
        zangano.avanzarTurno();
        zangano.avanzarTurno();
        zangano.avanzarTurno();

        // Assert
        assertEquals(30, jugadorZerg.obtenerMineral());
    }

    @Test
    void test03UnZanganoQueNoEstaTrabajandoEnUnNodoMineralNoDeberiaRecolecarMineral() {
        // Arrange
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Zangano tipoZangano =  new Zangano(jugadorZerg);
        Unidad zangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoZangano);
        zangano.avanzarTurno(1);

        // Act
        zangano.avanzarTurno();
        zangano.avanzarTurno();
        zangano.avanzarTurno();

        // Assert
        assertEquals(0, jugadorZerg.obtenerMineral());
    }
}
