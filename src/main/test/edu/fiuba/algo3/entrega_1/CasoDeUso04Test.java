package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano.CONSTRUCCION_ZANGANO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso04Test {

    Mapa mapa = new Mapa();

    /* Extractor */

    @Test
    void test01SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSeisTurnosSinTenerZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        // Act
        extractor.avanzarTurno(6);

        // Assert
        assertEquals(0, jugadorZerg.getGas());
    }

    @Test
    void test02SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConUnZanganoDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,125);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        Zangano tipoZangano =  new Zangano(jugadorZerg);
        Unidad zangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoZangano);
        extractor.guardarZangano(zangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(10, jugadorZerg.getGas());
    }

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConDosZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        Zangano tipoPrimerZangano =  new Zangano(jugadorZerg);
        Unidad primerZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoPrimerZangano);
        extractor.guardarZangano(primerZangano);
        Zangano tipoSegundoZangano =  new Zangano(jugadorZerg);
        Unidad segundoZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoSegundoZangano);
        extractor.guardarZangano(segundoZangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(20, jugadorZerg.getGas());
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConTresZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,175);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

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
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(30, jugadorZerg.getGas());
    }

    @Test
    void test05SeConstruyeUnExtractorEnUnVolcanSeRecibenTresZanganoYUnCuartoYaNoPuedeRecibirse(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        Zangano tipoPrimerZangano =  new Zangano(jugadorZerg);
        Unidad primerZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoPrimerZangano);
        extractor.guardarZangano(primerZangano);
        Zangano tipoSegundoZangano =  new Zangano(jugadorZerg);
        Unidad segundoZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoSegundoZangano);
        extractor.guardarZangano(segundoZangano);
        Zangano tipoTercerZangano =  new Zangano(jugadorZerg);
        Unidad tercerZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoTercerZangano);
        extractor.guardarZangano(tercerZangano);
        Zangano tipoCuartoZangano =  new Zangano(jugadorZerg);
        Unidad cuartoZangano = new Unidad(new Tiempo(CONSTRUCCION_ZANGANO), new Ubicacion(0,0), tipoCuartoZangano);

        // Act & Assert
        assertThrows(CantidadMaximaDeZanganosEnExtractorException.class,()->{
            extractor.guardarZangano(cuartoZangano);
        });
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    /* Asimilador */

    @Test
    void test06SeConstruyeUnAsimiladorEnUnVolcanYSeAvanzanSieteTurnosYSeDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.avanzarTurno(7);

        // Assert
        assertEquals(20, jugadorProtoss.getGas());
    }

    @Test
    void test07SeConstruyeUnAsimiladorEnUnVolcanYSeAvanzanDiezTurnosYSeDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.avanzarTurno(10);

        // Assert
        assertEquals(80, jugadorProtoss.getGas());
    }
}
