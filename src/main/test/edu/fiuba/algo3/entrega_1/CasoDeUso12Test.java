package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.*;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
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

public class CasoDeUso12Test {

    Mapa mapa = new Mapa();
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000, 1000), mapa);

    @Test
    void test01SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(10000, 10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 32; i++) { // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.
            unidad.atacar(acceso);
        }

        // Act
        acceso.avanzarTurno(25); // Recupera (500 x 0.05) = 25 de escudo por turno.

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test02SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(10000, 10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 32; i++) { // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.
            unidad.atacar(acceso);
        }

        // Act
        acceso.avanzarTurno(25);

        // Assert
        assertEquals(200, acceso.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test03SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) { // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.
            unidad.atacar(asimilador);
        }

        // Act
        asimilador.avanzarTurno(25); // Recupera (450 x 0.05) = 22 de escudo por turno.

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Volcan volcan = new Volcan(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 24; i++) { // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.
            unidad.atacar(asimilador);
        }

        // Act
        asimilador.avanzarTurno(25);

        // Assert
        assertEquals(300, asimilador.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 16; i++) { // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.
            unidad.atacar(nexoMineral);
        }

        // Act
        nexoMineral.avanzarTurno(25); // Recupera (250 x 0.05) = 12 de escudo por turno.

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(new Ubicacion(0,0));
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 16; i++) { // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.
            unidad.atacar(nexoMineral);
        }

        // Act
        nexoMineral.avanzarTurno(25);

        // Assert
        assertEquals(100, nexoMineral.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test07SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 20; i++) { // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.
            unidad.atacar(pilon);
        }

        // Act
        pilon.avanzarTurno(25); // Recupera (300 x 0.05) = 15 de escudo por turno.

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test08SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 20; i++) { // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.
            unidad.atacar(pilon);
        }

        // Act
        pilon.avanzarTurno(25);

        // Assert
        assertEquals(100, pilon.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(10000,10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 32; i++) { // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.
            unidad.atacar(puertoEstelar);
        }

        // Act
        puertoEstelar.avanzarTurno(25); // Recupera (600 x 0.05) = 30 de escudo por turno.

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test10SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(10000,10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        Guardian tipoGuardian = new Guardian(jugadorZerg);
        Unidad unidad = new Unidad(new Tiempo(CONSTRUCCION_GUARDIAN), new Ubicacion(0,0), tipoGuardian);
        unidad.avanzarTurno(4);

        for(int i = 0; i < 32; i++) { // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.
            unidad.atacar(puertoEstelar);
        }

        // Act
        puertoEstelar.avanzarTurno(25);

        // Assert
        assertEquals(400, puertoEstelar.obtenerVida());
    }
}