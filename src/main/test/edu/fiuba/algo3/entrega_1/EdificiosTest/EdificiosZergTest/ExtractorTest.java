package edu.fiuba.algo3.entrega_1.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorTest {
	
    @Test
    void test01SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativo(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);

        // Act
        int resultado = extractor.obtenerGas();

        // Assert
        assertEquals(0, resultado);
    }

    @Test
    void test02UnCriaderoNoPuedeConstruirseSobreUnVolcan(){
        // ...
    }

    @Test
    void test03SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSeisTurnosSinTenerZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);

        // Act
        extractor.avanzarTurno(6);

        // Assert
        assertEquals(0, extractor.obtenerGas());
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConUnZanganoDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano zangano =  new Zangano();
        extractor.guardarZangano(zangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(10, extractor.obtenerGas());
    }

    @Test
    void test05SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConDosZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano();
        extractor.guardarZangano(SegundoZangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(20, extractor.obtenerGas());
    }

    @Test
    void test06SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConTresZanganosDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        Zangano primerZangano =  new Zangano();
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano();
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano();
        extractor.guardarZangano(TercerZangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(30, extractor.obtenerGas());
    }

    @Test
    void test07SeConstruyeUnExtractorEnUnVolcanSeRecibenTresZanganoYUnCuartoYaNoPuedeRecibirse(){
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
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

    @Test
    void test08SeConstruyeUnExtractorYRecibeDanio(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        extractor.recibirAtaque(10);

        // Act
        int resultado = extractor.obtenerVida();

        // Assert
        assertEquals(resultado, 740);
    }

    @Test
    void test09SeConstruyeUnExtractorQueRecibeDanioYAlAvanzarElTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 100);
        Extractor extractor = new Extractor(volcan, recursosJugador);
        extractor.recibirAtaque(10);

        // Act
        extractor.avanzarTurno(1);

        // Assert
        assertEquals(extractor.obtenerVida(), 750);
    }

    @Test
    void test10SeIntentaConstruirUnExtractorSinRecursosYSeLanzaUnaExcepcion() {
        Volcan volcan = new Volcan();
        Recursos recursosJugador = new Recursos();
        recursosJugador.guardar(0, 99);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Extractor extractor = new Extractor(volcan, recursosJugador);
        });
    }
}