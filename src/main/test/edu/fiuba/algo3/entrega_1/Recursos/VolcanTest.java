package edu.fiuba.algo3.entrega_1.Recursos;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinGasVespenoParaExtraerException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanSinRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Excepciones.VolcanYaTieneUnaRefineriaDeGasConstruidaException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VolcanTest {

    @Test
    void test01SeCreaUnVolcanSinUnaRefineriaDeGasYAlIntentarExtraerGasSeLanzaExcepcion(){
        Volcan volcan = new Volcan();
        int unaCantidadExtraible = 50;

        assertThrows(VolcanSinRefineriaDeGasConstruidaException.class,()->{
            int gasExtraido = volcan.extraerGas(unaCantidadExtraible);
        });
    }

    @Test
    void test02SeIntentaConstruirUnExtractorEnUnVolcanDondeYaHayUnExtractorConstruidoYSeLanzaUnaExcepcion(){
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 200);
        Extractor primerExtractor = new Extractor(volcan, recursosJugador);

        assertThrows(VolcanYaTieneUnaRefineriaDeGasConstruidaException.class,()->{
            Extractor segundoExtractor = new Extractor(volcan, recursosJugador);
        });
    }

    @Test // Hay que extraer el gas del VOlcan hasta que se quede vacio.
    void test03SeConstruyeUnExtractorEnUnVolcanSinGasVespenoYAlIntentarExtraerSeLanzaUnaExcepcion(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);

        // Act & Assert
        assertThrows(VolcanSinGasVespenoParaExtraerException.class,()->{
			extractor.avanzarTurno(7);
        });
    }

    @Test // Hay que extraer el gas del Volcan hasta que solo le queden 10 unidades.
    void test04SeConstruyeUnExtractorEnUnVolcanCon10UnidadesDeGasVespenoYConDosZanganosTrabajandoYAlExtraerGasSoloExtraemosLas10UnidadesQueLeQuedanAlVolcan() {
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano = new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano segundoZangano = new Zangano();
        extractor.guardarZangano(segundoZangano);

        // Act
		extractor.avanzarTurno(7);

        // Assert
        assertEquals(10, extractor.obtenerGas());
    }
}