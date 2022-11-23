package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.UNIDADES_PROTOSS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso26 {

    @Test
    @DisplayName("Un protoss no puede construir un Zealot si no tiene al menos 2 de cupo en su casa")
    public void protossSinRecursosZealotTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    @DisplayName("Un protoss puede construir un Zealot si tiene al menos 2 de cupo en su casa")
    public void protossConRecursosZealotTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearZealot);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 1);
    }

    @Test
    @DisplayName("Un protoss puede construir dos Zealot si tiene al menos 4 de cupo en su casa")
    public void protossConRecursosConstruyeDosZealotTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearZealot);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 1);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearZealot);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 2);
    }

    @Test
    @DisplayName("Contruir Zealots reduce la cantidad de cupos disponibles")
    public void protossConRecursosConstruyeDosZealotsYNoPuedeConstruirUnTerceroTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearZealot);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 1);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearZealot);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 2);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearZealot());
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT) == 2);
    }

    @Test
    @DisplayName("Un protoss no puede construir un Dragon si no tiene al menos 3 de cupo en su casa")
    public void protossSinRecursosDragonTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    @DisplayName("Un protoss puede construir un Dragon si tiene al menos 3 de cupo en su casa")
    public void protossConRecursosDragonTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearDragon);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 1);
    }

    @Test
    @DisplayName("Un protoss puede construir dos Dragones si tiene al menos 6 de cupo en su casa")
    public void protossConRecursosConstruyeDosDragonesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(200);
        jugadorProtoss.crearPilon();
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearDragon);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 1);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearDragon);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 2);
    }

    @Test
    @DisplayName("Contruir Dragones reduce la cantidad de cupos disponibles")
    public void protossConRecursosConstruyeUnDragonYNoPuedeConstruirUnSegundoTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        jugadorProtoss.crearPilon();
        Assertions.assertDoesNotThrow(jugadorProtoss::crearDragon);
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 1);
        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearDragon());
        Assertions.assertTrue(jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON) == 1);
    }

    // Scout -> 4
    @Test
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
}
