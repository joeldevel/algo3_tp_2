package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {

    @Test
    void test01SeConstruyeUnAccesoQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act
        acceso.recibirAtaque(10);

        // Assert
        assertEquals(490, acceso.obtenerEscudo());
    }

    @Test
    void test02SeConstruyeUnAccesoQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(10);

        // Act
        acceso.avanzarTurno(1);

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test03SeConstruyeUnAccesoQueLuegoDeOchoTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.avanzarTurno(8);

        // Act
        acceso.recibirAtaque(10);

        // Assert
        assertEquals(490, acceso.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnAccesoQueLuegoDeOchoTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(50 + 50 + 50 + 50 + 50, 150 + 125 + 125 + 125 + 125 + 125 + 150 + 150 + 150 + 150 + 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.avanzarTurno(8);
        acceso.recibirAtaque(10);

        // Act
        acceso.avanzarTurno(1);

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05SeConstruyeUnAsimiladorQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        // Act
        asimilador.recibirAtaque(10);

        // Assert
        assertEquals(440, asimilador.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnAsimiladorQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(10);

        // Act
        asimilador.avanzarTurno(1);

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test07SeConstruyeUnAsimiladorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.avanzarTurno(6);

        // Act
        asimilador.recibirAtaque(10);

        // Assert
        assertEquals(440, asimilador.obtenerEscudo());
    }

    @Test
    void test08SeConstruyeUnAsimiladorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.avanzarTurno(6);
        asimilador.recibirAtaque(10);

        // Act
        asimilador.avanzarTurno(1);

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnNexoMineralQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        // Act
        nexoMineral.recibirAtaque(10);

        // Assert
        assertEquals(240, nexoMineral.obtenerEscudo());
    }

    @Test
    void test10SeConstruyeUnNexoMineralQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.recibirAtaque(10);

        // Act
        nexoMineral.avanzarTurno(1);

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    @Test
    void test11SeConstruyeUnNexoMineralQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);

        // Act
        nexoMineral.recibirAtaque(10);

        // Assert
        assertEquals(240, nexoMineral.obtenerEscudo());
    }

    @Test
    void test12SeConstruyeUnNexoMineralQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);
        nexoMineral.recibirAtaque(10);

        // Act
        nexoMineral.avanzarTurno(1);

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test13SeConstruyeUnPilonQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        // Act
        pilon.recibirAtaque(10);

        // Assert
        assertEquals(290, pilon.obtenerEscudo());
    }

    @Test
    void test14SeConstruyeUnPilonQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(10);

        // Act
        pilon.avanzarTurno(1);

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test15SeConstruyeUnPilonQueLuegoDeCincoTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.avanzarTurno(5);

        // Act
        pilon.recibirAtaque(10);

        // Assert
        assertEquals(290, pilon.obtenerEscudo());
    }

    @Test
    void test16SeConstruyeUnPilonQueLuegoDeCincoTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.avanzarTurno(5);
        pilon.recibirAtaque(10);

        // Act
        pilon.avanzarTurno(1);

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test17SeConstruyeUnPuertoEstelarQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);

        // Act
        puertoEstelar.recibirAtaque(10);

        // Assert
        assertEquals(590, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test18SeConstruyeUnPuertoEstelarQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(10);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test19SeConstruyeUnPuertoEstelarQueLuegoDeDiezTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.avanzarTurno(10);

        // Act
        puertoEstelar.recibirAtaque(10);

        // Assert
        assertEquals(590, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test20SeConstruyeUnPuertoEstelarQueLuegoDeDiezTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.avanzarTurno(10);
        puertoEstelar.recibirAtaque(10);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }
}
