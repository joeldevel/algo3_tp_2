package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import org.junit.jupiter.api.Test;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian.CONSTRUCCION_GUARDIAN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso11Test {

    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000));

    @Test
    void test01SeConstruyeUnAccesoQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(acceso);

        // Assert
        assertEquals(475, acceso.obtenerEscudo());
    }

    @Test
    void test02SeConstruyeUnAccesoQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(acceso);

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

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(acceso);

        // Assert
        assertEquals(475, acceso.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnAccesoQueLuegoDeOchoTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(50 + 50 + 50 + 50 + 50, 150 + 125 + 125 + 125 + 125 + 125 + 150 + 150 + 150 + 150 + 150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.avanzarTurno(8);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(acceso);

        // Act
        acceso.avanzarTurno(1);

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05SeConstruyeUnAsimiladorQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(asimilador);

        // Assert
        assertEquals(425, asimilador.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnAsimiladorQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(asimilador);

        // Act
        asimilador.avanzarTurno(2);

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test07SeConstruyeUnAsimiladorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.avanzarTurno(6);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(asimilador);

        // Assert
        assertEquals(425, asimilador.obtenerEscudo());
    }

    @Test
    void test08SeConstruyeUnAsimiladorQueLuegoDeSeisTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.avanzarTurno(6);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(asimilador);

        // Act
        asimilador.avanzarTurno(2);

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnNexoMineralQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(nexoMineral);

        // Assert
        assertEquals(225, nexoMineral.obtenerEscudo());
    }

    @Test
    void test10SeConstruyeUnNexoMineralQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(nexoMineral);

        // Act
        nexoMineral.avanzarTurno(3);

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    @Test
    void test11SeConstruyeUnNexoMineralQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(nexoMineral);

        // Assert
        assertEquals(225, nexoMineral.obtenerEscudo());
    }

    @Test
    void test12SeConstruyeUnNexoMineralQueLuegoDeCuatroTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.avanzarTurno(4);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(nexoMineral);

        // Act
        nexoMineral.avanzarTurno(3);

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

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(pilon);

        // Assert
        assertEquals(275, pilon.obtenerEscudo());
    }

    @Test
    void test14SeConstruyeUnPilonQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(pilon);

        // Act
        pilon.avanzarTurno(2);

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

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(pilon);

        // Assert
        assertEquals(275, pilon.obtenerEscudo());
    }

    @Test
    void test16SeConstruyeUnPilonQueLuegoDeCincoTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.avanzarTurno(5);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(pilon);

        // Act
        pilon.avanzarTurno(2);

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test17SeConstruyeUnPuertoEstelarQueNoSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(puertoEstelar);

        // Assert
        assertEquals(575, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test18SeConstruyeUnPuertoEstelarQueNoSeEncuentraOperativoYRecibeDanioYAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(puertoEstelar);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test19SeConstruyeUnPuertoEstelarQueLuegoDeDiezTurnosSeEncuentraOperativoYRecibeDanioYElResultadoEsElIndicado(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);
        puertoEstelar.avanzarTurno(10);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        // Act
        unidad.atacar(puertoEstelar);

        // Assert
        assertEquals(575, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test20SeConstruyeUnPuertoEstelarQueLuegoDeDiezTurnosSeEncuentraOperativoYRecibeDanioAlAvanzarOtroTurnoRecuperaSuVidaCorrectamente(){
        // Arrange
        Recursos recursos = new Recursos(10000,10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);
        puertoEstelar.avanzarTurno(10);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);
        unidad.atacar(puertoEstelar);

        // Act
        puertoEstelar.avanzarTurno(1);

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }
}
