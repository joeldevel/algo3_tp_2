package edu.fiuba.algo3.entidades.EdificiosTest.EdificiosZergTest;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtractorTest {
	
    @Test
    void test01SeConstruyeUnExtractorEnUnVolcanYNoSeEncuentraOperativo(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

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
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        // Act
        extractor.avanzarTurno(6);

        // Assert
        assertEquals(0, extractor.obtenerGas());
    }

    @Test
    void test04SeConstruyeUnExtractorEnUnVolcanYSeAvanzanSieteTurnosConUnZanganoDevuelveElResultadoIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,125);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        Zangano zangano =  new Zangano(jugadorZerg);
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
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        Zangano primerZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(jugadorZerg);
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
        Recursos recursos = new Recursos(0,175);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        Zangano primerZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(TercerZangano);

        // Act
        extractor.avanzarTurno(7);

        // Assert
        assertEquals(30, extractor.obtenerGas());
    }

    @Test
    void test07SeConstruyeUnExtractorEnUnVolcanSeRecibenTresZanganoYUnCuartoYaNoPuedeRecibirse(){
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        Zangano primerZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(primerZangano);
        Zangano SegundoZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(SegundoZangano);
        Zangano TercerZangano =  new Zangano(jugadorZerg);
        extractor.guardarZangano(TercerZangano);
        Zangano CuartoZangano =  new Zangano(jugadorZerg);

        assertThrows(CantidadMaximaDeZanganosEnExtractorException.class,()->{
            extractor.guardarZangano(CuartoZangano);
        });
    }

    @Test
    void test08SeConstruyeUnExtractorYRecibeDanio(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
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
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.recibirAtaque(10);

        // Act
        extractor.avanzarTurno(1);

        // Assert
        assertEquals(extractor.obtenerVida(), 750);
    }

    @Test
    void test10SeIntentaConstruirUnExtractorSinRecursosYSeLanzaUnaExcepcion() {
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,99);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        assertThrows(SinRecursosSuficientesException.class,()->{
            Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        });
    }
}