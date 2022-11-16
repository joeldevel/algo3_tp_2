package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Extractor.Extractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

class ExtractorTest {
	
    @Test
    void test01SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativo(){
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan(5000);
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
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas(extractor);
        
        extractor.avanzarTurno(6);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 0);
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardaUnZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas((extractor));
        
        extractor.avanzarTurno(6);
        
        Zangano zangano =  new Zangano(10);
        extractor.guardarZangano(zangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 10);
    }

    @Test
    void test05SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardanDosZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas(extractor);
        
        extractor.avanzarTurno(6);
        
        Zangano primerZangano =  new Zangano(10);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(10);
        extractor.guardarZangano(SegundoZangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 20);
    }

    @Test
    void test06SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeGuardanTresZanganoYSeExtraeElValorDeGasIndicado(){
        // Arrange
        Extractor extractor = new Extractor();
        Volcan volcan = new Volcan(5000);
        volcan.construirRefineriaDeGas(extractor);
        
        extractor.avanzarTurno(6);
        
        Zangano primerZangano =  new Zangano(10);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(10);
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano(10);
        extractor.guardarZangano(TercerZangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 30);
    }

    @Test
    void test07SeConstruyeUnExtractorEnUnVolcanYLuegoDeSeisTurnosSeRecibenTresZanganoYUnCuartoYaNoPuedeRecibirse(){
        // Arrange
        Extractor extractor = new Extractor();
        
        extractor.avanzarTurno(6);
        
        Zangano primerZangano =  new Zangano(10);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(10);
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano(10);
        extractor.guardarZangano(TercerZangano);
        Zangano CuartoZangano =  new Zangano(10);

        assertThrows(CantidadMaximaDeZanganosEnExtractorException.class,()->{
            extractor.guardarZangano(CuartoZangano);
        });
    }

    @Test
    void test08SeConstruyeUnExtractorYRecibeDanio(){
        // Arrange
        Extractor extractor = new Extractor();
        extractor.recibirDanio(10);

        // Act
        int resultado = extractor.obtenerVida();

        // Assert
        assertEquals(resultado, 740);
    }

    @Test
    void test09SeConstruyeUnExtractorQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Extractor extractor = new Extractor();
        extractor.recibirDanio(10);

        // Act
        extractor.avanzarTurno();

        // Assert
        assertEquals(extractor.obtenerVida(), 750);
    }
}