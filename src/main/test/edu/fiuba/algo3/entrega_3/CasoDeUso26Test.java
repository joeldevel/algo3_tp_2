package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.PuertoEstelar;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Espiral;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Guarida;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.ReservaDeReproduccion;
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

    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(1000, 1000));
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(1000, 1000));

    /* Protoss */

    @Test
    public void test01JugadorProtossSinPoblacionIntentaCrearUnZealotYNoPuede() {
        // Arrange
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot(acceso));
    }

    @Test
    public void test02JugadorProtossConUnPilonConstruidoPuedeConstruirUnZealotYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearZealot(acceso);

        // Assert
        assertEquals(2, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test03JugadorProtossConUnPilonConstruidoPuedeConstruirDosZealotYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearZealot(acceso);
        jugadorProtoss.crearZealot(acceso);

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test04JugadorProtossConUnPilonConstruidoPuedeConstruirDosZealotYNoPuedeConstruirUnTercerZealot() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearZealot(acceso);
        jugadorProtoss.crearZealot(acceso);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot(acceso));
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test05JugadorProtossSinPoblacionIntentaCrearUnDragonYNoPuede() {
        // Arrange
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon(acceso));
    }

    @Test
    public void test06JugadorProtossConUnPilonConstruidoPuedeConstruirUnDragonYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearDragon(acceso);

        // Assert
        assertEquals(3, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test07JugadorProtossConDosPilonesConstruidosPuedeConstruirDosDragonesYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearDragon(acceso);
        jugadorProtoss.crearDragon(acceso);

        // Assert
        assertEquals(6, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test08JugadorProtossConDosPilonConstruidosPuedeConstruirTresDragonesYNoPuedeConstruirUnCuartoDragon() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        Acceso acceso = new Acceso(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearDragon(acceso);
        jugadorProtoss.crearDragon(acceso);
        jugadorProtoss.crearDragon(acceso);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon(acceso));
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test09JugadorProtossSinPoblacionIntentaCrearUnScoutYNoPuede() {
        // Arrange
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout(puerto));
    }

    @Test
    public void test10JugadorProtossConUnPilonConstruidoPuedeConstruirUnScoutYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearScout(puerto);

        // Assert
        assertEquals(4, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test11JugadorProtossConDosPilonesConstruidosPuedeConstruirDosScoutYTieneElSuministroIndicado() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);

        // Act
        jugadorProtoss.crearScout(puerto);
        jugadorProtoss.crearScout(puerto);

        // Assert
        assertEquals(8, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test12JugadorProtossConDosPilonConstruidosPuedeConstruirDosScoutYNoPuedeConstruirUnTercerScout() {
        // Arrange
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(0,1));
        PuertoEstelar puerto = new PuertoEstelar(new Ubicacion(0,0), jugadorProtoss);
        jugadorProtoss.crearScout(puerto);
        jugadorProtoss.crearScout(puerto);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout(puerto));
    }

    /* Zerg */

    @Test
    public void test13JugadorZergSinPoblacionIntentaCrearUnZanganoYNoPuede() {
        // Arrange
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano(criadero));
    }

    @Test
    public void test14JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZanganoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearZangano(criadero);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test15JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test16JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZanganosYNoPuedeConstruirUnSextoZangano() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Criadero criadero = new Criadero(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);
        jugadorZerg.crearZangano(criadero);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano(criadero));
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test17JugadorZergSinPoblacionIntentaCrearUnZerlingYNoPuede() {
        // Arrange
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling(reserva));
    }

    @Test
    public void test18JugadorZergConUnCriaderoConstruidoPuedeConstruirUnZerlingYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearZerling(reserva);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test19JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);

        // Assert
        assertEquals(5, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test20JugadorZergConUnCriaderoConstruidoPuedeConstruirCincoZerlingsYNoPuedeConstruirUnSextoZerling() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        ReservaDeReproduccion reserva = new ReservaDeReproduccion(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);
        jugadorZerg.crearZerling(reserva);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling(reserva));
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test21JugadorZergSinPoblacionIntentaCrearUnHidraliscoYNoPuede() {
        // Arrange
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco(guarida));
    }

    @Test
    public void test22JugadorZergConUnCriaderoConstruidoPuedeConstruirUnHidraliscoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearHidralisco(guarida);

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test23JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearHidralisco(guarida);
        jugadorZerg.crearHidralisco(guarida);

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test24JugadorZergConUnCriaderoConstruidoPuedeConstruirDosHidraliscosYNoPuedeConstruirUnTercerHidralisco() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Guarida guarida = new Guarida(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.crearHidralisco(guarida);
        jugadorZerg.crearHidralisco(guarida);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco(guarida));
    }

    /* ------------------------------------------------------------------------------------------------------------- */

    @Test
    public void test25JugadorZergSinPoblacionIntentaCrearUnMutaliscoYNoPuede() {
        // Arrange
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco(espiral));
    }

    @Test
    public void test26JugadorZergConUnCriaderoConstruidoPuedeConstruirUnMutaliscoYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearMutalisco(espiral);

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test27JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYTieneElSuministroIndicado() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);

        // Act
        jugadorZerg.crearMutalisco(espiral);
        jugadorZerg.crearMutalisco(espiral);

        // Assert
        assertEquals(8, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test28JugadorZergConDosCriaderosConstruidosPuedeConstruirDosMutaliscosYNoPuedeConstruirUnTercerMutalisco() {
        // Arrange
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(0,1));
        Espiral espiral = new Espiral(new Ubicacion(0,0), jugadorZerg);
        jugadorZerg.crearMutalisco(espiral);
        jugadorZerg.crearMutalisco(espiral);

        // Act & Assert
        assertThrows(SuministroSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco(espiral));
    }
}