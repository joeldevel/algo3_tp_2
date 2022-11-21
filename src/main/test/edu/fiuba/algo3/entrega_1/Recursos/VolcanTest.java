package edu.fiuba.algo3.entrega_1.Recursos;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Recursos.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VolcanTest {

    @Test
    void test01SeCreaUnVolcanSinUnaRefineriaDeGasYAlIntentarExtraerGasSeLanzaExcepcion(){
        Volcan volcan = new Volcan(5000);
        int unaCantidadExtraible = 50;

        assertThrows(VolcanSinRefineriaDeGasConstruidaException.class,()->{
            int gasExtraido = volcan.extraerGas(unaCantidadExtraible);
        });
    }

    @Test
    void test02SeIntentaConstruirUnExtractorEnUnVolcanDondeYaHayUnExtractorConstruidoYSeLanzaUnaExcepcion(){
        Volcan volcan = new Volcan(5000);
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 200);
        Extractor primerExtractor = new Extractor(volcan, recursosJugador);

        assertThrows(VolcanYaTieneUnaRefineriaDeGasConstruidaException.class,()->{
            Extractor segundoExtractor = new Extractor(volcan, recursosJugador);
        });
    }

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanSinGasVespenoYAlIntentarExtraerSeLanzaUnaExcepcion(){
        // Arrange
        Volcan volcan = new Volcan(0);
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano =  new Zangano(10);
        extractor.guardarZangano(primerZangano);

        // Act & Assert
        assertThrows(VolcanSinGasVespenoParaExtraerException.class,()->{
			extractor.avanzarTurno(7);
        });
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanCon10UnidadesDeGasVespenoYConDosZanganosTrabajandoYAlExtraerGasSoloExtraemosLas10UnidadesQueLeQuedanAlVolcan() {
        // Arrange
        Volcan volcan = new Volcan(10);
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano = new Zangano(10);
        extractor.guardarZangano(primerZangano);
        Zangano segundoZangano = new Zangano(10);
        extractor.guardarZangano(segundoZangano);

        // Act
		extractor.avanzarTurno(7);

        // Assert
        assertEquals(10, extractor.obtenerGas());
    }
}