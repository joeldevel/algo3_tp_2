package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso29Test {

    @Test
    @DisplayName("Un protoss con 200 de suministros no puede incrementarlo")
    public void protossLlegaAlLimiteDeSuministrosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(4100);
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon();
        }

        Assertions.assertEquals(200, jugadorProtoss.cupo());
        jugadorProtoss.crearPilon();
        Assertions.assertEquals(200, jugadorProtoss.cupo());
    }

    @Test
    @DisplayName("Un zerg con 200 de suministros no puede incrementarlo")
    public void zergLlegaAlLimiteDeSuministrosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(8200);
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero();
        }

        Assertions.assertEquals(200, jugadorZerg.cupo());
        jugadorZerg.crearCriadero();
        Assertions.assertEquals(200, jugadorZerg.cupo());
    }
    
}
