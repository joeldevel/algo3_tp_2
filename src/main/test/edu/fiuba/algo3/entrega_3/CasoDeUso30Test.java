package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Excepciones.CupoSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso30Test {

    /* Protoss */

    @Test
    public void test01JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnZealot() {
        // Arrange
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.crearPilon(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearZealot());
    }

    @Test
    public void test02JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnDragon() {
        // Arrange
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.crearPilon(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearDragon());
    }

    @Test
    public void test03JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnScout() {
        // Arrange
        Recursos recursos = new Recursos(0, 14200);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorProtoss.crearPilon(new Ubicacion(i,0));
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.crearZealot();
        }

        jugadorProtoss.crearPilon(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorProtoss.crearScout());
    }

    /* Zerg */

    @Test
    public void test04JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZangano() {
        // Arrange
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.crearCriadero(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZangano());
    }

    @Test
    public void test05JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZerling() {
        // Arrange
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.crearCriadero(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearZerling());
    }

    @Test
    public void test06JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnHidralisco() {
        // Arrange
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.crearCriadero(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearHidralisco());
    }

    @Test
    public void test07JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnMutalisco() {
        // Arrange
        Recursos recursos = new Recursos(0, 13200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);

        for (int i = 0; i < 40; i++) {
            jugadorZerg.crearCriadero(new Ubicacion(i,0));
        }

        for (int i = 0; i < 200; i++) {
            jugadorZerg.crearZangano();
        }

        jugadorZerg.crearCriadero(new Ubicacion(1,1));

        // Act & Assert
        assertThrows(CupoSuperaElNumeroDePoblacionException.class, () -> jugadorZerg.crearMutalisco());
    }
}