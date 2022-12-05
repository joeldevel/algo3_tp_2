package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon.CONSTRUCCION_DRAGON;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso10Test {

    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000, 1000));

    @Test
    void test01SeConstruyeUnCriaderoQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(criadero);

        // Assert
        assertEquals(480, criadero.obtenerVida());
    }

    @Test
    void test02SeConstruyeUnCriaderoQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(criadero);

        // Act
        criadero.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(criadero);

        // Assert
        assertEquals(480, criadero.obtenerVida());
    }

    @Test
    void test04SeConstruyeUnCriaderoQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        criadero.avanzarTurno(4);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(criadero);

        // Act
        criadero.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(espiral);

        // Assert
        assertEquals(1280, espiral.obtenerVida());
    }

    @Test
    void test06SeConstruyeUnaEspiralQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(espiral);

        // Act
        espiral.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(espiral);

        // Assert
        assertEquals(1280, espiral.obtenerVida());
    }

    @Test
    void test08SeConstruyeUnaEspiralQueLuegoDeDiezTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        espiral.avanzarTurno(10);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(espiral);

        // Act
        espiral.avanzarTurno(2);

        // Assert
        assertEquals(1300, espiral.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnExtractorQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(extractor);

        // Assert
        assertEquals(730, extractor.obtenerVida());
    }

    @Test
    void test10SeConstruyeUnExtractorQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(extractor);

        // Act
        extractor.avanzarTurno(2);

        // Assert
        assertEquals(750, extractor.obtenerVida());
    }

    @Test
    void test11SeConstruyeUnExtractorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.avanzarTurno(6);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(extractor);

        // Assert
        assertEquals(730, extractor.obtenerVida());
    }

    @Test
    void test12SeConstruyeUnExtractorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Extractor extractor = new Extractor(volcan, new Ubicacion(0,0), jugadorZerg);
        extractor.avanzarTurno(6);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(extractor);

        // Act
        extractor.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(guarida);

        // Assert
        assertEquals(1230, guarida.obtenerVida());
    }

    @Test
    void test14SeConstruyeUnaGuaridaQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(guarida);

        // Act
        guarida.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(guarida);

        // Assert
        assertEquals(1230, guarida.obtenerVida());
    }

    @Test
    void test16SeConstruyeUnaGuaridaQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        guarida.avanzarTurno(12);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(guarida);

        // Act
        guarida.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(rdp);

        // Assert
        assertEquals(980, rdp.obtenerVida());
    }

    @Test
    void test18SeConstruyeUnaReservaDeReproduccionQueNoSeEncuentraOperativaYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(rdp);

        // Act
        rdp.avanzarTurno(2);

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

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);

        // Act
        dragon.atacar(rdp);

        // Assert
        assertEquals(980, rdp.obtenerVida());
    }

    @Test
    void test20SeConstruyeUnaReservaDeReproduccionQueLuegoDeDoceTurnosSeEncuentraOperativaYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        ReservaDeProduccion rdp = new ReservaDeProduccion(new Ubicacion(0,0), jugadorZerg);
        rdp.avanzarTurno(12);

        Dragon tipoDragon = new Dragon(new Ubicacion(0, 0), jugadorProtoss); // Ataque de tierra y aire
        Unidad dragon = new Unidad(new Tiempo(CONSTRUCCION_DRAGON), new Ubicacion(0, 0), tipoDragon);
        dragon.avanzarTurno(6);
        dragon.atacar(rdp);

        // Act
        rdp.avanzarTurno(2);

        // Assert
        assertEquals(1000, rdp.obtenerVida());
    }
}
