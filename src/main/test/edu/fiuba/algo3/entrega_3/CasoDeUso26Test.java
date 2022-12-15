package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasoDeUso26Test {

    Mapa mapa = new Mapa();
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(5000, 5000), mapa);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(5000, 5000), mapa);

    /* Protoss */

    @Test
    public void test01JugadorProtossSinPoblacionIntentaCrearUnZealotYNoPuede() {
        // Arrange
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test02JugadorProtossConUnPilonConstruidoPuedeTransportarZealotsYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(2, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test04JugadorProtossConUnPilonConstruidoPuedeConstruirDosZealotYNoPuedeConstruirUnTercerZealot() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Zealot", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Zealot", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test05JugadorProtossSinPoblacionIntentaCrearUnDragonYNoPuede() {
        // Arrange
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test06JugadorProtossConUnPilonConstruidoPuedeConstruirUnDragonYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(3, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test07JugadorProtossConDosPilonesConstruidosPuedeConstruirDosDragonesYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(6, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test08JugadorProtossConDosPilonConstruidosPuedeConstruirTresDragonesYNoPuedeConstruirUnCuartoDragon() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(9, jugadorProtoss.calcularSuministro());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test09JugadorProtossSinPoblacionIntentaCrearUnScoutYNoPuede() {
        // Arrange
        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(0, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test10JugadorProtossConUnPilonConstruidoPuedeConstruirUnScoutYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);

        for(int i = 0; i < 5; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(2,2), jugadorZerg, mapa);
        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test11JugadorProtossConDosPilonesConstruidosPuedeConstruirDosScoutYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 5; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(2,2), jugadorZerg, mapa);
        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(8, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test12JugadorProtossConDosPilonConstruidosPuedeConstruirDosScoutYNoPuedeConstruirUnTercerScout() {
        // Arrange
        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa);
        jugadorProtoss.construir("Pilon", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 5; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(2,2), jugadorZerg, mapa);
        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(0,1), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(0,1), jugadorZerg, mapa);

        // Assert
        assertEquals(8, jugadorProtoss.calcularSuministro());
    }

    /* Zerg */

    @Test
    public void test13JugadorZergSinPoblacionIntentaCrearUnZanganoYNoPuede() {
        // Arrange
        // Jugadores y mapa...

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Assert
        assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test14JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZanganoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test15JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 3; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test16JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYNoPuedeConstruirUnSextoZangano() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 3; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

   @Test
    public void test17JugadorZergSinPoblacionIntentaCrearUnZerlingYNoPuede() {
       // Arrange
       jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(0,0), jugadorProtoss, mapa);

       // Act
       jugadorZerg.construir("Zerling", new Ubicacion(0,0), jugadorProtoss, mapa);

       // Assert
       assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test18JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZerlingYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test19JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 3; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test20JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYNoPuedeConstruirUnSextoZerling() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 3; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        // Act
        jugadorZerg.construir("Zerling", new Ubicacion(1,1), jugadorProtoss, mapa);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test21JugadorZergSinPoblacionIntentaCrearUnHidraliscoYNoPuede() {
        // Arrange
       jugadorZerg.construir("Guarida", new Ubicacion(0,0), jugadorProtoss, mapa);

       // Act
       jugadorZerg.construir("Hidralisco", new Ubicacion(0,0), jugadorProtoss, mapa);

       // Assert
       assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test22JugadorZergConUnCriaderoConstruidoPuedeConstruirUnHidraliscoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test23JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);
        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test24JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYNoPuedeConstruirUnTercerHidralisco() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);
        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);

        // Act
        jugadorZerg.construir("Hidralisco", new Ubicacion(2,2), jugadorProtoss, mapa);

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test25JugadorZergSinPoblacionIntentaCrearUnMutaliscoYNoPuede() {
        // Arrange
        jugadorZerg.construir("Espiral", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(0,0), jugadorProtoss, mapa);

        // Assert
        assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test26JugadorZergConUnCriaderoConstruidoPuedeConstruirUnMutaliscoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Espiral", new Ubicacion(3,3), jugadorProtoss, mapa);

        for (int i = 0; i < 10; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test27JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Criadero", new Ubicacion(0,1), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Espiral", new Ubicacion(3,3), jugadorProtoss, mapa);

        for (int i = 0; i < 10; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);
        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);

        // Assert
        assertEquals(8, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test28JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYNoPuedeConstruirUnTercerMutalisco() {
        // Arrange
        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);
        jugadorZerg.construir("Criadero", new Ubicacion(0,1), jugadorProtoss, mapa);

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(2,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Espiral", new Ubicacion(3,3), jugadorProtoss, mapa);

        for (int i = 0; i < 10; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);
        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(3,3), jugadorProtoss, mapa);

        // Assert
        assertEquals(8, jugadorZerg.calcularSuministro());
    }
}