package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlgoStarTest {

    @Test
    public void test01SeIniciaAlgoStarYElTurnoLoTieneElJugadorIndicado() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");
        String jugadorEsperado = "JugadorZerg";

        // Act
        Jugador jugador = juego.obtenerJugadorTurno();

        // Assert
        assertEquals(true, jugador.compararNombres(jugadorEsperado));
    }

    @Test
    public void test02SeIniciaAlgoStarYSeAvanzaElTurnoYElTurnoLoTieneElJugadorIndicado() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");
        juego.avanzarTurno();
        String jugadorEsperado = "JugadorProtoss";

        // Act
        Jugador jugador = juego.obtenerJugadorTurno();

        // Assert
        assertEquals(true, jugador.compararNombres(jugadorEsperado));
    }

    @Test
    public void test03SeIniciaAlgoStarYSeAvanzaElTurnoDosVecesYElTurnoLoTieneElJugadorIndicado() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");
        juego.avanzarTurno();
        juego.avanzarTurno();
        String jugadorEsperado = "JugadorZerg";

        // Act
        Jugador jugador = juego.obtenerJugadorTurno();

        // Assert
        assertEquals(true, jugador.compararNombres(jugadorEsperado));
    }

    @Test
    public void test04SeIniciaAlgoStarYSeAvanzaElTurnoDiezVecesYElTurnoLoTieneElJugadorIndicado() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        juego.avanzarTurno();
        String jugadorEsperado = "JugadorZerg";

        // Act
        Jugador jugador = juego.obtenerJugadorTurno();

        // Assert
        assertEquals(true, jugador.compararNombres(jugadorEsperado));
    }

    @Test
    public void test05PruebaIntegradora() {
        // Arrange
        AlgoStar juego = new AlgoStar();
        juego.crearJugador("JugadorZerg", "Azul", "Zerg");
        juego.crearJugador("JugadorProtoss", "Rojo", "Protoss");

        // Turno de JugadorZerg
        Jugador jugador = juego.obtenerJugadorTurno();
    }
}