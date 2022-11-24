package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.UNIDADES_PROTOSS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso30Test {

    //Verificar que alcanzado el limite máximo de 200 de suministros no se puedan construir
    //más unidades
    @Test
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
        // cada pilon aumenta el cupo en 5, 40 pilones llega al limite = 200
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }
        // cada zealot incrementa la poblacion tomando 2 cupos = 2000
        jugadorProtoss.incrementarMineral(10000);
        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }
        jugadorProtoss.incrementarMineral(100 + 125); // un pilos + el costo del dragon
        jugadorProtoss.incrementarGas(50);
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
        jugadorProtoss.crearPilon(); // aumenta cupo
        jugadorProtoss.crearDragon();
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.DRAGON));
    }

    @Test
    @DisplayName("Un protoss con 200 de población completa no puede crear un Scout más")
    public void protossAlLimiteDeSuministrosNoPuedeConstruirUnScout() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(4000);
        // cada pilon aumenta el cupo en 5, 40 pilones llega al limite = 200
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }
        // cada zealot incrementa la poblacion tomando 2 cupos = 2000
        jugadorProtoss.incrementarMineral(10000);
        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }
        jugadorProtoss.incrementarMineral(100 + 300); // un pilos + el costo del scout
        jugadorProtoss.incrementarGas(150);
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
        Assertions.assertEquals(100, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.ZEALOT));
        jugadorProtoss.crearPilon(); // aumenta cupo
        jugadorProtoss.crearScout();
        Assertions.assertEquals(0, jugadorProtoss.cantidadDeUnidades(UNIDADES_PROTOSS.SCOUT));
    }
}
