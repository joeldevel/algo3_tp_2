package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Cambios en el nombre de la excepcion.
// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso26Test {

    /* Protoss */

    @Test
    public void test01JugadorProtossSinPoblacionIntentaCrearUnZealotYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    public void test02JugadorProtossConUnPilonConstruidoPuedeConstruirUnZealotYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));

        // Act
        jugadorProtoss.crearZealot();

        // Assert
        assertEquals(2, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test03JugadorProtossConUnPilonConstruidoPuedeConstruirDosZealotYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));

        // Act
        jugadorProtoss.crearZealot();
        jugadorProtoss.crearZealot();

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test04JugadorProtossConUnPilonConstruidoPuedeConstruirDosZealotYNoPuedeConstruirUnTercerZealot() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearZealot();
        jugadorProtoss.crearZealot();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test05JugadorProtossSinPoblacionIntentaCrearUnDragonYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    public void test06JugadorProtossConUnPilonConstruidoPuedeConstruirUnDragonYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));

        // Act
        jugadorProtoss.crearDragon();

        // Assert
        assertEquals(3, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test07JugadorProtossConDosPilonesConstruidosPuedeConstruirDosDragonesYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));

        // Act
        jugadorProtoss.crearDragon();
        jugadorProtoss.crearDragon();

        // Assert
        assertEquals(6, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test08JugadorProtossConDosPilonConstruidosPuedeConstruirTresDragonesYNoPuedeConstruirUnCuartoDragon() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        jugadorProtoss.crearDragon();
        jugadorProtoss.crearDragon();
        jugadorProtoss.crearDragon();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test09JugadorProtossSinPoblacionIntentaCrearUnScoutYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    @Test
    public void test10JugadorProtossConUnPilonConstruidoPuedeConstruirUnScoutYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));

        // Act
        jugadorProtoss.crearScout();

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test11JugadorProtossConDosPilonesConstruidosPuedeConstruirDosScoutYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));

        // Act
        jugadorProtoss.crearScout();
        jugadorProtoss.crearScout();

        // Assert
        assertEquals(8, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test12JugadorProtossConDosPilonConstruidosPuedeConstruirDosScoutYNoPuedeConstruirUnTercerScout() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        jugadorProtoss.crearScout();
        jugadorProtoss.crearScout();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    /* Zerg */

    @Test
    public void test13JugadorZergSinPoblacionIntentaCrearUnZanganoYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    public void test14JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZanganoYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearZangano();

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test15JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test16JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYNoPuedeConstruirUnSextoZangano() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();
        jugadorZerg.crearZangano();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test17JugadorZergSinPoblacionIntentaCrearUnZerlingYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    public void test18JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZerlingYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearZerling();

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test19JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test20JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYNoPuedeConstruirUnSextoZerling() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();
        jugadorZerg.crearZerling();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test21JugadorZergSinPoblacionIntentaCrearUnHidraliscoYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    public void test22JugadorZergConUnCriaderoConstruidoPuedeConstruirUnHidraliscoYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearHidralisco();

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test23JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearHidralisco();
        jugadorZerg.crearHidralisco();

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test24JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYNoPuedeConstruirUnTercerHidralisco() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearHidralisco();
        jugadorZerg.crearHidralisco();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test25JugadorZergSinPoblacionIntentaCrearUnMutaliscoYNoPuede() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }

    @Test
    public void test26JugadorZergConUnCriaderoConstruidoPuedeConstruirUnMutaliscoYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));

        // Act
        jugadorZerg.crearMutalisco();

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test27JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYTieneElSuministroIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 400);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));

        // Act
        jugadorZerg.crearMutalisco();
        jugadorZerg.crearMutalisco();

        // Assert
        assertEquals(8, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test28JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYNoPuedeConstruirUnTercerMutalisco() {
        // Arrange
        Recursos recursos = new Recursos(0, 400);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        jugadorZerg.crearMutalisco();
        jugadorZerg.crearMutalisco();

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }
}