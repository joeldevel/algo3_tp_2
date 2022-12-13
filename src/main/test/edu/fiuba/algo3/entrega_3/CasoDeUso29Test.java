package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Edificios.EdificiosZerg.Criadero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso29Test {

    Mapa mapa = new Mapa();

    /* Protoss */

    @Test
    public void test01JugadorProtossLlegaAlLimiteDePoblacionCreandoCuarentaPilonesYElValorDePoblacionEsElIndicado() {
        // Arrange
        Recursos recursos = new Recursos(0, 4000);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(i,0),jugadorProtoss));
        }

        // Assert
        assertEquals(200, jugadorProtoss.calcularPoblacion());
    }

    @Test
    public void test02JugadorProtossLlegaAlLimiteDePoblacionCreandoCuarentaPilonesYAlIntentarCrearOtroYaNoAumentaLaPoblacion() {
        // Arrange
        Recursos recursos = new Recursos(0, 4100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos, mapa);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(i,0),jugadorProtoss));
        }

        // Act
        jugadorProtoss.agregarEdificio(new Pilon(new Ubicacion(0,1),jugadorProtoss));

        // Assert
        assertEquals(200, jugadorProtoss.calcularPoblacion());
    }

    /* Zerg */

    @Test
    public void test03JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaCriaderosYElValorDePoblacionEsElIndicado() {
        // Act
        Recursos recursos = new Recursos(0, 8000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        } 

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test04JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaAmosSupremosYElValorDePoblacionEsElIndicado() {
        // Act
        Recursos recursos = new Recursos(0, 2000);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        // Act
        for (int i = 0; i < 40; i++) {
            jugadorZerg.construir("AmoSupremo", new Ubicacion(i,0), jugadorZerg, mapa); //crearAmoSupremo(new Ubicacion(i,0));
        }

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }

    @Test
    public void test05JugadorZergLlegaAlLimiteDePoblacionCreandoCuarentaCriaderosYAlIntentarCrearOtroYaNoAumentaLaPoblacion() {
        // Arrange
        Recursos recursos = new Recursos(0, 8200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos, mapa);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(i,0),jugadorZerg));
        }

        // Act
        jugadorZerg.agregarEdificio(new Criadero(new Ubicacion(1,1),jugadorZerg));

        // Assert
        assertEquals(200, jugadorZerg.calcularPoblacion());
    }
}