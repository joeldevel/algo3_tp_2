package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Cambios en el nombre de la excepcion.
// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso26Test {

    /* UNIDADES PROTOSS */

    @Test
    @DisplayName("Un jugador Protoss no puede construir un Zealot si no tiene al menos 2 de poblacion libre")
    public void test01protossSinRecursosZealotTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    @DisplayName("Un jugador Protoss puede construir un Zealot si tiene al menos 2 de poblacion libre")
    public void test02protossConRecursosZealotTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearZealot());
        assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 1);
    }

    @Test
    @DisplayName("Un jugador Protoss puede construir dos Zealot si tiene al menos 4 de poblacion libre")
    public void test03protossConRecursosConstruyeDosZealotTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearZealot());
        assertDoesNotThrow(() -> jugadorProtoss.crearZealot());
        assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 2);
    }

    @Test
    @DisplayName("Contruir Zealots reduce la cantidad de cupos disponibles")
    public void test04protossConRecursosConstruyeDosZealotsYNoPuedeConstruirUnTerceroTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearZealot());
        assertDoesNotThrow(() -> jugadorProtoss.crearZealot());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    @DisplayName("Un jugador Protoss no puede construir un Dragon si no tiene al menos 3 de poblacion libre")
    public void test05protossSinRecursosDragonTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    @DisplayName("Un jugador Protoss puede construir un Dragon si tiene al menos 3 de poblacion libre")
    public void test06protossConRecursosDragonTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearDragon());
        assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 1);
    }

    @Test
    @DisplayName("Un jugador Pprotoss puede construir dos Dragones si tiene al menos 6 de poblacion libre")
    public void protossConRecursosConstruyeDosDragonesTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertDoesNotThrow(() -> jugadorProtoss.crearDragon());
        assertDoesNotThrow(() -> jugadorProtoss.crearDragon());
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 2);
    }

    @Test
    @DisplayName("Contruir Dragones reduce la cantidad de cupos disponibles")
    public void protossConRecursosConstruyeUnDragonYNoPuedeConstruirUnSegundoTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearDragon());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    @DisplayName("Un jugador Protoss no puede construir un Scout si no tiene al menos 4 de poblacion libre")
    public void protossSinRecursosScoutTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    @Test
    @DisplayName("Un jugador Protoss puede construir un Scout si tiene al menos 4 de poblacion libre")
    public void protossConRecursosScoutTest() {
        Recursos recursos = new Recursos(0, 100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorProtoss.crearScout());
        assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 1);
    }

    @Test
    @DisplayName("Un jugador Protoss puede construir dos Scout si tiene al menos 8 de poblacion libre")
    public void protossConRecursosConstruyeDosScoutTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertDoesNotThrow(() -> jugadorProtoss.crearScout());
        assertDoesNotThrow(() -> jugadorProtoss.crearScout());
        assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 2);
    }

    @Test
    @DisplayName("Contruir Scouts reduce la cantidad de cupos disponibles")
    public void protossConRecursosConstruyeDosScoutsYNoPuedeConstruirUnTerceroTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        jugadorProtoss.crearPilon(new Ubicacion(0,0));
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertDoesNotThrow(() -> jugadorProtoss.crearScout());
        assertDoesNotThrow(() -> jugadorProtoss.crearScout());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    /* UNIDADES ZERG */

    @Test
    @DisplayName("Un jugador Zerg no puede construir un Zángano si no tiene al menos 1 poblacion libre")
    public void zergSinRecursosZanganoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir un Zángano si tiene al menos 1 de poblacion libre")
    public void zergConRecursosZanganoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 1);
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir 5 Zánganos si tiene al menos 5 de poblacion libre")
    public void zergConRecursosConstruyeCincoZanganosTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 5);
    }

    @Test
    @DisplayName("Contruir Zánganos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeCincoZanganosYNoPuedeConstruirUnSextoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertDoesNotThrow(() -> jugadorZerg.crearZangano());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    @DisplayName("Un jugador Zerg no puede construir un Zerling si no tiene al menos 1 de poblacion libre")
    public void zergSinRecursosZerlingTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir un Zerling si tiene al menos 1 de poblacion libre")
    public void zergConRecursosZerlingTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 1);
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir 5 Zerlings si tiene al menos 5 de poblacion libre")
    public void zergConRecursosConstruyeCincoZerlingsTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 5);

    }

    @Test
    @DisplayName("Contruir Zerlings reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeCincoZerlingsYNoPuedeConstruirUnSextoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertDoesNotThrow(() -> jugadorZerg.crearZerling());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    @DisplayName("Un jugador Zerg no puede construir un Hidralisco si no tiene al menos 2 de poblacion libre")
    public void zergSinRecursosHidraliscoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir un Hidralisco si tiene al menos 2 de poblacion libre")
    public void zergConRecursosHidraliscoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearHidralisco());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 1);
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir 2 Hidraliscos si tiene al menos 4 de poblacion libre")
    public void zergConRecursosConstruyeDosHidraliscosTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearHidralisco());
        assertDoesNotThrow(() -> jugadorZerg.crearHidralisco());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 2);
    }

    @Test
    @DisplayName("Contruir Hidraliscos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeDosHidraliscosYNoPuedeConstruirUnTerceroTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearHidralisco());
        assertDoesNotThrow(() -> jugadorZerg.crearHidralisco());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    @DisplayName("Un jugador Zerg no puede construir un Mutalisco si no tiene al menos 4 de poblacion libre")
    public void zergSinRecursosMutaliscoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir un Mutalisco si tiene al menos 2 de poblacion libre")
    public void zergConRecursosMutaliscoTest() {
        Recursos recursos = new Recursos(0, 200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        assertDoesNotThrow(() -> jugadorZerg.crearMutalisco());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 1);
    }

    @Test
    @DisplayName("Un jugador Zerg puede construir 2 Mutaliscos si tiene al menos 8 de poblacion libre")
    public void zergConRecursosConstruyeDosMutaliscosTest() {
        Recursos recursos = new Recursos(0, 400);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertDoesNotThrow(() -> jugadorZerg.crearMutalisco());
        assertDoesNotThrow(() -> jugadorZerg.crearMutalisco());
        assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 2);
    }

    @Test
    @DisplayName("Contruir Mutaliscos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeDosMutaliscosYNoPuedeConstruirUnTerceroTest() {
        Recursos recursos = new Recursos(0, 400);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        jugadorZerg.crearCriadero(new Ubicacion(0,0));
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertDoesNotThrow(() -> jugadorZerg.crearMutalisco());
        assertDoesNotThrow(() -> jugadorZerg.crearMutalisco());
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }
}