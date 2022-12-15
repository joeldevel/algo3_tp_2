package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.NexoMineral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
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

        // Act & Assert
        assertThrows(VolcanSinGasVespenoParaExtraerException.class,()->{
            asimilador.avanzarTurno(251); // Avanzamos tantos turnos como sea necesario para que el Volcan no tenga mas gas.
        });
    }

    @Test
    void test02SeConstruyeUnNexoMineralEnUnNodoMineralYEstandoYaOperativoSeAvanzan201TurnosYElNodoMineralSeQuedaSinMineral() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);

        // Act & Assert
        assertThrows(NodoMineralSinMineralParaRecolectarException.class,()->{
            nexoMineral.avanzarTurno(201); // Avanzamos tantos turnos como sea necesario para que el Nodo Mineral no tenga mas gas.
        });
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

        // Act & Assert
        assertThrows(VolcanSinGasVespenoParaExtraerException.class,()->{
            extractor.avanzarTurno(168); // Avanzamos tantos turnos como sea necesario para que el Volcan no tenga mas gas.
        });
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

        // Act & Assert
        assertThrows(NodoMineralSinMineralParaRecolectarException.class,()->{
            zangano.avanzarTurno(201); // Avanzamos tantos turnos como sea necesario para que el Nodo Mineral no tenga mas gas.
        });
    }
}
