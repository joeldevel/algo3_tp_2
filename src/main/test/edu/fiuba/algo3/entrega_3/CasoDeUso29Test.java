package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso29Test {

    @Test
    @DisplayName("Un jugador Protoss con 200 de poblacion no puede incrementarlo")
    public void test01ProtossLlegaAlLimiteDeSuministrosTest() {
        Recursos recursos = new Recursos(0, 4100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        assertEquals(200, jugadorProtoss.calcularPoblacion());
        jugadorProtoss.crearPilon(new Ubicacion(1,1));
        assertEquals(200, jugadorProtoss.calcularPoblacion());
    }

    @Test
    @DisplayName("Un jugador Zerg con 200 de poblacion no puede incrementarlo")
    public void test02ZergLlegaAlLimiteDeSuministrosTest() {
        Recursos recursos = new Recursos(0, 8200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        assertEquals(200, jugadorZerg.calcularPoblacion());
        jugadorZerg.crearCriadero(new Ubicacion(1,1));
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }
}