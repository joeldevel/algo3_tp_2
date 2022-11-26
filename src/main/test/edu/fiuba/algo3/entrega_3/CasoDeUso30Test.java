package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Jugador.UNIDADES_PROTOSS;
import edu.fiuba.algo3.modelo.Jugador.UNIDADES_ZERG;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso30Test {

    /*@Test
    @DisplayName("Un protoss con 200 de población completa no puede crear un Zealot más")
    public void protossAlLimiteDeSuministrosNoPuedeConstruirUnZealot() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(4000);
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }

        jugadorProtoss.incrementarMineral(10000);
        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.incrementarMineral(200);

        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearZealot();

        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
    }

    @Test
    @DisplayName("Un protoss con 200 de población completa no puede crear un Dragon más")
    public void protossAlLimiteDeSuministrosNoPuedeConstruirUnDragon() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(4000);
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }

        jugadorProtoss.incrementarMineral(10000);
        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.incrementarMineral(100 + 125);
        jugadorProtoss.incrementarGas(50);

        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearDragon();

        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
    }

    @Test
    @DisplayName("Un protoss con 200 de población completa no puede crear un Scout más")
    public void protossAlLimiteDeSuministrosNoPuedeConstruirUnScout() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(4000);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }

        jugadorProtoss.incrementarMineral(10000);
        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.incrementarMineral(100 + 300);
        jugadorProtoss.incrementarGas(150);

        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));

        jugadorProtoss.crearPilon();
        jugadorProtoss.crearScout();

        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
    }

    @Test
    @DisplayName("Un zerg con 200 de población completa no puede crear un Zángano más")
    public void zergAlLimiteDeSuministrosNoPuedeConstruirUnZangano() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(8000);
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero();
        }

        jugadorZerg.incrementarMineral(25 * 200);
        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.incrementarMineral(200);

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));

        jugadorZerg.crearCriadero();
        jugadorZerg.crearZangano();

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
    }

    @Test
    @DisplayName("Un zerg con 200 de población completa no puede crear un Zerling más")
    public void zergAlLimiteDeSuministrosNoPuedeConstruirUnZerling() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(8000);
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero();
        }

        jugadorZerg.incrementarMineral(25 * 200);
        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.incrementarMineral(200);

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING));

        jugadorZerg.crearCriadero();
        jugadorZerg.crearZerling();

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZERLING));
    }

    @Test
    @DisplayName("Un zerg con 200 de población completa no puede crear un Hidralisco más")
    public void zergAlLimiteDeSuministrosNoPuedeConstruirUnHidralisco() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(8000);
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero();
        }

        jugadorZerg.incrementarMineral(25 * 200);
        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.incrementarMineral(200 + 75);
        jugadorZerg.incrementarGas(25);

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO));

        jugadorZerg.crearCriadero();
        jugadorZerg.crearHidralisco();

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.HIDRALISCO));
    }

    @Test
    @DisplayName("Un zerg con 200 de población completa no puede crear un Mutalisco más")
    public void zergAlLimiteDeSuministrosNoPuedeConstruirUnMutalisco() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(8000);
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero();
        }

        jugadorZerg.incrementarMineral(25 * 200);
        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.incrementarMineral(200 + 100);
        jugadorZerg.incrementarGas(100);

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO));

        jugadorZerg.crearCriadero();
        jugadorZerg.crearMutalisco();

        Assertions.assertEquals(200, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.ZANGANO));
        Assertions.assertEquals(0, jugadorZerg.cantidadDeUnidades(UNIDADES_ZERG.MUTALISCO));
    }*/
}
