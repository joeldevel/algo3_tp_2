package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso29Test {

    /* Protoss */

    @Test
    public void test01JugadorProtossLlegaAlLimiteDePoblacionCreandoCuarentaPilonesYElValorDePoblacionEsElIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 4000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        // Assert
        assertEquals(200, jugadorProtoss.calcularPoblacion());
    }

    @Test
    public void test02JugadorProtossLlegaAlLimiteDePoblacionCreandoCuarentaPilonesYAlIntentarCrearOtroYaNoAumentaLaPoblacion() {
        // Arrange
        Recursos recursos = new Recursos(0, 4100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        // Act
        jugadorProtoss.crearPilon(new Ubicacion(0,1));

        // Assert
        assertEquals(200, jugadorProtoss.calcularPoblacion());
    }

    /* Zerg */

    @Test
    public void test03JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaCriaderosYElValorDePoblacionEsElIndicado() {
        // Act
        Recursos recursos = new Recursos(0, 8000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test04JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaAmosSupremosYElValorDePoblacionEsElIndicado() {
        // Act
        Recursos recursos = new Recursos(0, 2000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearAmoSupremo(new Ubicacion(i,0));
        }

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test05JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaCriaderosYAlIntentarCrearOtroYaNoAumentaLaPoblacion() {
        // Arrange
        Recursos recursos = new Recursos(0, 8200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        // Act
        jugadorZerg.crearCriadero(new Ubicacion(1,1));

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }
}