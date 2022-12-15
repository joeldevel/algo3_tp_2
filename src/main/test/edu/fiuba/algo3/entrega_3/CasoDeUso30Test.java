package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

public class CasoDeUso30Test {

    Mapa mapa = new Mapa();
    JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);
    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

    /* Protoss */

    @Test
    public void test01JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnZealot() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.construir("Pilon", new Ubicacion(i,0), jugadorZerg, mapa);
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for (int i = 0; i < 15; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 100; i++) {
            jugadorProtoss.construir("Zealot", new Ubicacion(1,1), jugadorZerg, mapa);
        }

        // Act
        jugadorProtoss.construir("Zealot", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(200, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test02JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnDragon() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.construir("Pilon", new Ubicacion(i,0), jugadorZerg, mapa);
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for (int i = 0; i < 15; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 66; i++) {
            jugadorProtoss.construir("Dragon", new Ubicacion(1,1), jugadorZerg, mapa);
        }

        // Act
        jugadorProtoss.construir("Dragon", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(198, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test03JugadorProtossAlLimiteDeSuministroNoPuedeConstruirUnScout() {
        // Arrange
        for (int i = 0; i < 40; i++) {
            jugadorProtoss.construir("Pilon", new Ubicacion(i,0), jugadorZerg, mapa);
        }

        for (int i = 0; i < 5; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(0,1), jugadorZerg, mapa);

        for (int i = 0; i < 8; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(1,1), jugadorZerg, mapa);

        for (int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 49; i++) {
            jugadorProtoss.construir("Scout", new Ubicacion(1,1), jugadorZerg, mapa);
        }

        // Act
        jugadorProtoss.construir("Scout", new Ubicacion(1,1), jugadorZerg, mapa);

        // Assert
        assertEquals(200, jugadorProtoss.calcularSuministro());
    }

    /* Zerg */

    @Test
    public void test04JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZangano() {
        // Arrange
        for (int i = 0; i < 10; i++) {
            jugadorZerg.construir("Criadero", new Ubicacion(i,0), jugadorProtoss, mapa);
        }

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 50; i++) {
            jugadorZerg.construir("Zangano", new Ubicacion(0,0), jugadorProtoss, mapa);
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zangano", new Ubicacion(1,1), jugadorProtoss, mapa);

        // Assert
        assertEquals(50, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test05JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnZerling() {
        // Arrange
        for (int i = 0; i < 10; i++) {
            jugadorZerg.construir("Criadero", new Ubicacion(i,0), jugadorProtoss, mapa);
        }

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(0,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 50; i++) {
            jugadorZerg.construir("Zerling", new Ubicacion(0,1), jugadorProtoss, mapa);
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Zerling", new Ubicacion(0,1), jugadorProtoss, mapa);

        // Assert
        assertEquals(50, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test06JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnHidralisco() {
        // Arrange
        for (int i = 0; i < 10; i++) {
            jugadorZerg.construir("Criadero", new Ubicacion(i,0), jugadorProtoss, mapa);
        }

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(0,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(0,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 25; i++) {
            jugadorZerg.construir("Hidralisco", new Ubicacion(0,2), jugadorProtoss, mapa);
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Hidralisco", new Ubicacion(0,2), jugadorProtoss, mapa);

        // Assert
        assertEquals(50, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test07JugadorZergAlLimiteDeSuministroNoPuedeConstruirUnMutalisco() {
        // Arrange
        for (int i = 0; i < 10; i++) {
            jugadorZerg.construir("Criadero", new Ubicacion(i,0), jugadorProtoss, mapa);
        }

        for (int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(0,1), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Guarida", new Ubicacion(0,2), jugadorProtoss, mapa);

        for (int i = 0; i < 12; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.construir("Espiral", new Ubicacion(0,3), jugadorProtoss, mapa);

        for (int i = 0; i < 10; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        for (int i = 0; i < 16; i++) {
            jugadorZerg.construir("Mutalisco", new Ubicacion(0,3), jugadorProtoss, mapa);
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.construir("Mutalisco", new Ubicacion(0,3), jugadorProtoss, mapa);

        // Assert
        assertEquals(48, jugadorZerg.calcularSuministro());
    }
}