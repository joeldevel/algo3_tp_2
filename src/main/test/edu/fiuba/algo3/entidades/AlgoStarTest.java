package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Ubicacion;
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

        // Turno de JugadorZerg: Construye un criadero en la posicion (1,1) y avanza el turno
        System.out.println("Primer turno");
        Jugador jugador1 = juego.obtenerJugadorTurno();
        System.out.println("Jugador turno: " + jugador1.obtenerRaza());
        Mapa mapa1 = juego.obtenerMapa();
        Ubicacion ubicacion1 = new Ubicacion(1,1);
        Jugador jugadorContario1 = juego.obtenerJugadorContrario(jugador1);
        System.out.println("Jugador contrario: " + jugadorContario1.obtenerRaza());
        System.out.println("Antes de la construccion la ubicacion esta libre: " + mapa1.verificarUbicacionLibre(ubicacion1));
        jugador1.construir("Criadero", ubicacion1, jugadorContario1, mapa1);
        System.out.println("Despues de la construccion la ubicacion esta libre: " + mapa1.verificarUbicacionLibre(ubicacion1));
        juego.avanzarTurno();

        // Turno de JugadorProtoss: Construye un pilon en la posicion (20,20) y avanza el turno
        System.out.println("\nSegundo turno");
        Jugador jugador2 = juego.obtenerJugadorTurno();
        System.out.println("Jugador turno: " + jugador2.obtenerRaza());
        Mapa mapa2 = juego.obtenerMapa();
        Ubicacion ubicacion2 = new Ubicacion(20,20);
        Jugador jugadorContario2 = juego.obtenerJugadorContrario(jugador2);
        System.out.println("Jugador contrario: " + jugadorContario2.obtenerRaza());
        System.out.println("Antes de la construccion la ubicacion esta libre: " + mapa2.verificarUbicacionLibre(ubicacion2));
        jugador2.construir("Pilon", ubicacion2, jugadorContario2, mapa2);
        System.out.println("Despues de la construccion la ubicacion esta libre: " + mapa2.verificarUbicacionLibre(ubicacion2));
        juego.avanzarTurno();
    }
}