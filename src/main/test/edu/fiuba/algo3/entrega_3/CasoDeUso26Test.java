package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;
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

    /*@Test
    @DisplayName("Un protoss no puede construir un Scout si no tiene al menos 4 de cupo en su casa")
    public void protossSinRecursosScoutTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearScout());
    }

    @Test
    @DisplayName("Un protoss puede construir un Scout si tiene al menos 4 de cupo en su casa")
    public void protossConRecursosScoutTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearScout);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 1);
    }

    @Test
    @DisplayName("Un protoss puede construir dos Scout si tiene al menos 8 de cupo en su casa")
    public void protossConRecursosConstruyeDosScoutTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(200);
        jugadorProtoss.crearPilon();
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearScout);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 1);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearScout);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 2);
    }

    @Test
    @DisplayName("Contruir Scouts reduce la cantidad de cupos disponibles")
    public void protossConRecursosConstruyeDosScoutsYNoPuedeConstruirUnTerceroTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(200);
        jugadorProtoss.crearPilon();
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearScout);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 1);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearScout);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 2);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearScout());
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT) == 2);
    }

    /* UNIDADES ZERG */

    /*@Test
    @DisplayName("Un zerg no puede construir un Zángano si no tiene al menos 1 de cupo en su casa")
    public void zergSinRecursosZanganoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    @DisplayName("Un zerg puede construir un Zángano si tiene al menos 1 de cupo en su casa")
    public void zergConRecursosZanganoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 1);
    }

    @Test
    @DisplayName("Un zerg puede construir 5 Zánganos si tiene al menos 5 de cupo en su casa")
    public void zergConRecursosConstruyeCincoZanganosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 2);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 3);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 4);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 5);
    }

    @Test
    @DisplayName("Contruir Zánganos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeCincoZanganosYNoPuedeConstruirUnSextoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 2);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 3);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 4);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZangano);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO) == 5);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    @DisplayName("Un zerg no puede construir un Zerling si no tiene al menos 1 de cupo en su casa")
    public void zergSinRecursosZerlingTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    @DisplayName("Un zerg puede construir un Zerling si tiene al menos 1 de cupo en su casa")
    public void zergConRecursosZerlingTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 1);
    }

    @Test
    @DisplayName("Un zerg puede construir 5 Zerlings si tiene al menos 5 de cupo en su casa")
    public void zergConRecursosConstruyeCincoZerlingsTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 2);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 3);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 4);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 5);

    }

    @Test
    @DisplayName("Contruir Zerlings reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeCincoZerlingsYNoPuedeConstruirUnSextoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 2);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 3);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 4);
        Assertions.assertDoesNotThrow(jugadorZerg::crearZerling);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING) == 5);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    @DisplayName("Un zerg no puede construir un Hidralisco si no tiene al menos 2 de cupo en su casa")
    public void zergSinRecursosHidraliscoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    @DisplayName("Un zerg puede construir un Hidralisco si tiene al menos 2 de cupos en su casa")
    public void zergConRecursosHidraliscoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearHidralisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 1);
    }

    @Test
    @DisplayName("Un zerg puede construir 2 Hidraliscos si tiene al menos 4 de cupo en su casa")
    public void zergConRecursosConstruyeDosHidraliscosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearHidralisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearHidralisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 2);
    }

    @Test
    @DisplayName("Contruir Hidraliscos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeDosHidraliscosYNoPuedeConstruirUnTerceroTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearHidralisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearHidralisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO) == 2);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    @DisplayName("Un zerg no puede construir un Mutalisco si no tiene al menos 4 de cupo en su casa")
    public void zergSinRecursosMutaliscoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearMutalisco());
    }

    @Test
    @DisplayName("Un zerg puede construir un Mutalisco si tiene al menos 2 de cupos en su casa")
    public void zergConRecursosMutaliscoTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearMutalisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 1);
    }

    @Test
    @DisplayName("Un zerg puede construir 2 Mutaliscos si tiene al menos 8 de cupo en su casa")
    public void zergConRecursosConstruyeDosMutaliscosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(400);
        jugadorZerg.crearCriadero();
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearMutalisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearMutalisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 2);
    }

    @Test
    @DisplayName("Contruir Mutaliscos reduce la cantidad de cupos disponibles")
    public void zergConRecursosConstruyeDosMutaliscosYNoPuedeConstruirUnTerceroTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(400);
        jugadorZerg.crearCriadero();
        jugadorZerg.crearCriadero();
        Assertions.assertDoesNotThrow(jugadorZerg::crearMutalisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 1);
        Assertions.assertDoesNotThrow(jugadorZerg::crearMutalisco);
        Assertions.assertTrue(jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO) == 2);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorZerg.crearMutalisco());
    }*/
}