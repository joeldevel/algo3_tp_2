package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso30Test {

    @Test
    @DisplayName("Un jugador Protoss con 200 de población completa no puede crear un Zealot más")
    public void test01ProtossAlLimiteDeSuministrosNoPuedeConstruirUnZealot() {
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    @DisplayName("Un jugador Protoss con 200 de población completa no puede crear un Dragon más")
    public void test02ProtossAlLimiteDeSuministrosNoPuedeConstruirUnDragon() {
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
        assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    @DisplayName("Un jugador Protoss con 200 de población completa no puede crear un Scout más")
    public void test03ProtossAlLimiteDeSuministrosNoPuedeConstruirUnScout() {
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }


        assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
        assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    @Test
    @DisplayName("Un jugaor Zerg con 200 de población completa no puede crear un Zángano más")
    public void test04ZergAlLimiteDeSuministrosNoPuedeConstruirUnZangano() {
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    @DisplayName("Un jugador Zerg con 200 de población completa no puede crear un Zerling más")
    public void test05ZergAlLimiteDeSuministrosNoPuedeConstruirUnZerling() {
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    @DisplayName("Un jugador Zerg con 200 de población completa no puede crear un Hidralisco más")
    public void test06ZergAlLimiteDeSuministrosNoPuedeConstruirUnHidralisco() {
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    @DisplayName("Un jugador Zerg con 200 de población completa no puede crear un Mutalisco más")
    public void test07ZergAlLimiteDeSuministrosNoPuedeConstruirUnMutalisco() {
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }
}