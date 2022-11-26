package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.SinCupoSuficienteException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.UNIDADES_PROTOSS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso31Test {

    /*@Test
    @DisplayName("Al destruir el único pilon disponible el suministro disminuye y no se puede crear otro Zealot")
    public void disminucionDeSuministrosAlDestruitPilonNoSePuedeCrearZealotTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100 + 100);

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearZealot();

        Assertions.assertEquals(1, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));

        jugadorProtoss.destruirPilon();

        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearZealot());
        Assertions.assertEquals(1, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
    }

    @Test
    @DisplayName("Al destruir el único pilon disponible el suministro disminuye y no se puede crear un Dragon")
    public void disminucionDeSuministrosAlDestruitPilonNoSePuedeCrearDragonTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100 + 125);
        jugadorProtoss.incrementarGas(50);

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearZealot();

        Assertions.assertEquals(1, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));

        jugadorProtoss.destruirPilon();

        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearDragon());
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
    }

    @Test
    @DisplayName("Al destruir un pilon  el suministro disminuye y no se puede crear un Scout")
    public void disminucionDeSuministrosAlDestruitPilonNoSePuedeCrearScoutTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(200 + 225 + 300);
        jugadorProtoss.incrementarGas(100 + 150);

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearPilon();
        jugadorProtoss.crearDragon();
        jugadorProtoss.crearDragon();

        Assertions.assertEquals(2, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));

        jugadorProtoss.destruirPilon();

        Assertions.assertThrows(SinCupoSuficienteException.class, () -> jugadorProtoss.crearScout());
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
    }*/
}
