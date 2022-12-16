package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso15Test {

    Mapa mapa = new Mapa();

    /* Protoss */

    @Test
    void test01SeConstruyeUnAsimiladorEnUnVolcanYEstandoYaOperativoSeAvanzan251TurnosYElVolcanSeQuedaSinGasVespeno(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.avanzarTurno(6);

        // Act
        // Al avanzar el turno 250 veces el Volcan se queda sin gas y el jugador recolecto 5000 de gas. Luego, si avanzamos el turno 50 veces mas el jugador deberia seguir teniendo 5000 de gas.
        asimilador.avanzarTurno(300);

        // Assert
        assertEquals(5000, jugadorProtoss.obtenerRecursos().obtenerGas());
    }

    @Test
    void test02SeConstruyeUnNexoMineralEnUnNodoMineralYEstandoYaOperativoSeAvanzan201TurnosYElNodoMineralSeQuedaSinMineral() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);

        // Assert
        // Al avanzar el turno 200 veces el Nodo se queda sin mineral y el jugador recolecto 2000 de mineral. Luego, si avanzamos el turno 50 veces mas el jugador deberia seguir teniendo 2000 de mineral.
        nexoMineral.avanzarTurno(250);

        // Act
        assertEquals(2000, jugadorProtoss.obtenerRecursos().obtenerMineral());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Zerg */

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanYEstandoYaOperativoSeAvanzan168TurnosYElVolcanSeQuedaSinGasVespeno(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,175);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.avanzarTurno(6);

        Zangano tipoPrimerZangano =  new Zangano(jugadorZerg);
        Unidad primerZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoPrimerZangano);
        extractor.guardarZangano(primerZangano);
        Zangano tipoSegundoZangano =  new Zangano(jugadorZerg);
        Unidad segundoZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoSegundoZangano);
        extractor.guardarZangano(segundoZangano);
        Zangano tipoTercerZangano =  new Zangano(jugadorZerg);
        Unidad tercerZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoTercerZangano);
        extractor.guardarZangano(tercerZangano);

        // Act
        // Al avanzar el turno 167 veces el Volcan se queda sin gas y el jugador recolecto 5000 de gas. Luego, si avanzamos el turno 33 veces mas el jugador deberia seguir teniendo 5000 de gas.
        extractor.avanzarTurno(167);

        // Assert
        assertEquals(5000, jugadorZerg.obtenerRecursos().obtenerGas());
    }

    @Test
    void test04SeConstruyeUnZanganoEnUnNodoMineralYEstandoYaOperativoSeAvanzan201TurnosYElNodoMineralSeQuedaSinMineral() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Zangano tipoZangano =  new Zangano(jugadorZerg);
        Unidad zangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoZangano);
        zangano.avanzarTurno(1);
        zangano.trabajarEn(nodoMineral);

        // Act
        // Al avanzar el turno 200 veces el Nodo se queda sin mineral y el jugador recolecto 2000 de mineral. Luego, si avanzamos el turno 50 veces mas el jugador deberia seguir teniendo 2000 de mineral.
        zangano.avanzarTurno(250);

        // Assert
        assertEquals(2000, jugadorZerg.obtenerRecursos().obtenerMineral());
    }
}
