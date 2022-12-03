package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {

    @Test
    void test01SeConstruyeUnCriaderoQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        // Act
        criadero.recibirAtaque(10);

        // Assert
        assertEquals(490, criadero.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnCriaderoQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        criadero.recibirAtaque(10);

        // Act
        criadero.avanzarTurno(1);

        // Assert
        assertEquals(500, criadero.obtenerVida());
    }

    @Test
    void test03SeConstruyeUnCriaderoQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        criadero.avanzarTurno(4);

        // Act
        criadero.recibirAtaque(10);

        // Assert
        assertEquals(490, criadero.obtenerVida());
    }

    @Test
    void test04SeConstruyeUnCriaderoQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        criadero.avanzarTurno(4);
        criadero.recibirAtaque(10);

        // Act
        criadero.avanzarTurno(1);

        // Assert
        assertEquals(500, criadero.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05SeConstruyeUnaEspiralQueNoSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act
        espiral.recibirAtaque(10);

        // Assert
        assertEquals(1290, espiral.obtenerVida());
    }

    @Test
    void test06SeConstruyeUnaEspiralQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        espiral.recibirAtaque(10);

        // Act
        espiral.avanzarTurno(1);

        // Assert
        assertEquals(1300, espiral.obtenerVida());
    }

    @Test
    void test07SeConstruyeUnaEspiralQueLuegoDeDiezTurnosSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        espiral.avanzarTurno(10);

        // Act
        espiral.recibirAtaque(10);

        // Assert
        assertEquals(1290, espiral.obtenerVida());
    }

    @Test
    void test08SeConstruyeUnaEspiralQueLuegoDeDiezTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        espiral.avanzarTurno(10);
        espiral.recibirAtaque(10);

        // Act
        espiral.avanzarTurno(1);

        // Assert
        assertEquals(1300, espiral.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnExtractorQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        // Act
        extractor.recibirAtaque(10);

        // Assert
        assertEquals(740, extractor.obtenerVida());
    }

    @Test
    void test10SeConstruyeUnExtractorQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.recibirAtaque(10);

        // Act
        extractor.avanzarTurno(1);

        // Assert
        assertEquals(750, extractor.obtenerVida());
    }

    @Test
    void test11SeConstruyeUnExtractorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.avanzarTurno(6);

        // Act
        extractor.recibirAtaque(10);

        // Assert
        assertEquals(740, extractor.obtenerVida());
    }

    @Test
    void test12SeConstruyeUnExtractorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.avanzarTurno(6);
        extractor.recibirAtaque(10);

        // Act
        extractor.avanzarTurno(1);

        // Assert
        assertEquals(750, extractor.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test13SeConstruyeUnaGuaridaQueNoSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test14SeConstruyeUnaGuaridaQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.recibirAtaque(10);

        // Act
        guarida.avanzarTurno(1);

        // Assert
        assertEquals(1250, guarida.obtenerVida());
    }

    @Test
    void test15SeConstruyeUnaGuaridaQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.avanzarTurno(12);

        // Act
        guarida.recibirAtaque(10);

        // Assert
        assertEquals(1240, guarida.obtenerVida());
    }

    @Test
    void test16SeConstruyeUnaGuaridaQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.avanzarTurno(12);
        guarida.recibirAtaque(10);

        // Act
        guarida.avanzarTurno(1);

        // Assert
        assertEquals(1250, guarida.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test17SeConstruyeUnaReservaDeReproduccionQueNoSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);

        // Act
        rdp.recibirAtaque(10);

        // Assert
        assertEquals(990, rdp.obtenerVida());
    }

    @Test
    void test18SeConstruyeUnaReservaDeReproduccionQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);
        rdp.recibirAtaque(10);

        // Act
        rdp.avanzarTurno(1);

        // Assert
        assertEquals(1000, rdp.obtenerVida());
    }

    @Test
    void test19SeConstruyeUnaReservaDeReproduccionQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);
        rdp.avanzarTurno(12);

        // Act
        rdp.recibirAtaque(10);

        // Assert
        assertEquals(990, rdp.obtenerVida());
    }

    @Test
    void test20SeConstruyeUnaReservaDeReproduccionQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);
        rdp.avanzarTurno(12);
        rdp.recibirAtaque(10);

        // Act
        rdp.avanzarTurno(1);

        // Assert
        assertEquals(1000, rdp.obtenerVida());
    }
}
