package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExtractorTest {

    @Test
    void test01SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativo(){
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(extractor);

        assertThrows(EdificioNoOperativoException.class,()->{
            volcan.extraerGasUsandoRefineria();
        });
    }

    @Test
    void test02UnCriaderoNoPuedeConstruirseSobreUnVolcan(){
        // ...
    }

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeExtraeGasSinTenerZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(0, resultado);
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardaUnZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano zangano =  new Zangano();
        extractor.guardarZangano(zangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(10, resultado);
    }

    @Test
    void test05SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardanDosZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano();
        extractor.guardarZangano(SegundoZangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(20, resultado);
    }

    @Test
    void test06SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardanTresZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan();
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano();
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano();
        extractor.guardarZangano(TercerZangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(30, resultado);
    }

    @Test
    void test07SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeRecibenTresZanganoYUnCuartoYaNoPuedeRecibirse(){
        // Arrange
        Extractor extractor = new Extractor();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano();
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano();
        extractor.guardarZangano(TercerZangano);
        Zangano CuartoZangano =  new Zangano();

        assertThrows(CantidadMaximaDeZanganosEnExtractorException.class,()->{
            extractor.guardarZangano(CuartoZangano);
        });
    }
}
