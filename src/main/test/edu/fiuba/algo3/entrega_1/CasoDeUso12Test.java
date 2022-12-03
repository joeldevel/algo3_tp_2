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

public class CasoDeUso12Test {

    @Test
    void test01SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(10000, 10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.

        // Act
        acceso.avanzarTurno(25); // Recupera (500 x 0.05) = 25 de escudo por turno.

        // Assert
        assertEquals(500, acceso.obtenerEscudo());
    }

    @Test
    void test02SeConstruyeUnAccesoQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(10000, 10000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        acceso.recibirAtaque(800); // Le sacamos todo el escudo con 500 de daño y luego 300 de vida.

        // Act
        acceso.avanzarTurno(25);

        // Assert
        assertEquals(200, acceso.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test03SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(600); // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.

        // Act
        asimilador.avanzarTurno(25); // Recupera (450 x 0.05) = 22 de escudo por turno.

        // Assert
        assertEquals(450, asimilador.obtenerEscudo());
    }

    @Test
    void test04SeConstruyeUnExtractorQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Volcan volcan = new Volcan();
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Asimilador asimilador = new Asimilador(volcan, new Ubicacion(0,0), jugadorProtoss);
        asimilador.recibirAtaque(600); // Le sacamos todo el escudo con 450 de daño y luego 150 de vida.

        // Act
        asimilador.avanzarTurno(25);

        // Assert
        assertEquals(300, asimilador.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test05SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.recibirAtaque(400); // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.

        // Act
        nexoMineral.avanzarTurno(25); // Recupera (250 x 0.05) = 12 de escudo por turno.

        // Assert
        assertEquals(250, nexoMineral.obtenerEscudo());
    }

    @Test
    void test06SeConstruyeUnNexoMineralQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        NexoMineral nexoMineral = new NexoMineral(nodoMineral, new Ubicacion(0,0), jugadorProtoss);
        nexoMineral.recibirAtaque(400); // Le sacamos todo el escudo con 250 de daño y luego 150 de vida.

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
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25); // Recupera (300 x 0.05) = 15 de escudo por turno.

        // Assert
        assertEquals(300, pilon.obtenerEscudo());
    }

    @Test
    void test08SeConstruyeUnPilonQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        Pilon pilon = new Pilon(new Ubicacion(0,0), jugadorProtoss);
        pilon.recibirAtaque(500); // Le sacamos todo el escudo con 300 de daño y luego 200 de vida.

        // Act
        pilon.avanzarTurno(25);

        // Assert
        assertEquals(100, pilon.obtenerVida());
    }

    /* ------------------------------------------------------------------------------------------------------------ */

    @Test
    void test09SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzar25TurnosRecuperaSuEscudoTotalmente(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25); // Recupera (600 x 0.05) = 30 de escudo por turno.

        // Assert
        assertEquals(600, puertoEstelar.obtenerEscudo());
    }

    @Test
    void test10SeConstruyeUnPuertoEstelarQueRecibeDanioHastaQuitarleTodoElEscudoYParteDeLaVidaYAlAvanzarElTurnoNoRecuperaSuVida(){
        // Arrange
        Recursos recursos = new Recursos(150,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        PuertoEstelar puertoEstelar = new PuertoEstelar(new Ubicacion(0,0), jugadorZerg);
        puertoEstelar.recibirAtaque(800); // Le sacamos todo el escudo con 600 de daño y luego 200 de vida.

        // Act
        puertoEstelar.avanzarTurno(25);

        // Assert
        assertEquals(400, puertoEstelar.obtenerVida());
    }
}