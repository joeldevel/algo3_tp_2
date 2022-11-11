package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Extractor.Extractor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

class VolcanTest {
	
	ArrayList<RequisitoDeConstruccion> requisitos = new ArrayList<RequisitoDeConstruccion>();
	Tiempo tiempo = new Tiempo(-6);
	Vida vida = new Vida(750,10);

    @Test
    void test01SeCreaUnVolcanSinUnaRefineriaDeGasYAlIntentarExtraerGasSeLanzaExcepcion(){
        Volcan volcan = new Volcan(5000);

        assertThrows(VolcanSinRefineriaDeGasConstruidaException.class,()->{
            int gasExtraido = volcan.extraerGasUsandoRefineria();
        });
    }

    @Test
    void test02SeIntentaConstruirUnExtractorEnUnVolcanDondeYaHayUnExtractorConstruidoYSeLanzaUnaExcepcion(){
        Volcan volcan = new Volcan(5000);
        Extractor primerExtractor = new Extractor(tiempo,requisitos,vida, 100, 0, 10);
        Extractor segundoExtractor = new Extractor(tiempo,requisitos,vida, 100, 0, 10);
        volcan.construirRefineriaDeGas(primerExtractor);

        assertThrows(VolcanYaTieneUnaRefineriaDeGasConstruidaException.class,()->{
            volcan.construirRefineriaDeGas(segundoExtractor);
        });
    }

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanSinGasVespenoYAlIntentarExtraerSeLanzaUnaExcepcion(){
        // Arrange
        Extractor extractor = new Extractor(tiempo,requisitos,vida, 100, 0, 10);
        Volcan volcan = new Volcan(0);
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano primerZangano =  new Zangano(10);
        extractor.guardarZangano(primerZangano);

        // Act & Assert
        assertThrows(VolcanSinGasVespenoParaExtraerException.class,()->{
            int gasExtraido = volcan.extraerGasUsandoRefineria();
        });
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanCon10UnidadesDeGasVespenoYConDosZanganosTrabajandoYAlExtraerGasSoloExtraemosLas10UnidadesQueLeQuedanAlVolcan() {
        // Arrange
        Extractor extractor = new Extractor(tiempo,requisitos,vida, 100, 0, 10);
        Volcan volcan = new Volcan(10);
        volcan.construirRefineriaDeGas(extractor);
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        extractor.avanzarTurno();
        Zangano primerZangano = new Zangano(10);
        extractor.guardarZangano(primerZangano);
        Zangano segundoZangano = new Zangano(10);
        extractor.guardarZangano(segundoZangano);

        // Act
        int resultado = volcan.extraerGasUsandoRefineria();

        // Assert
        assertEquals(resultado, 10);
    }
}