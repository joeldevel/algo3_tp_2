package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorProtossTest {

    @Test
    public void test01JugadorProtossonstruyeUnAccesoYLuegoDeAvanzarOchoTurnosElAccesoEstaOperableYCreaUnZealot() {
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
        }

        // Act
        jugadorProtoss.crearZealot(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();

        // Assert
        assertEquals(10, jugadorProtoss.calcularSuministroo());
    }

    @Test
    public void test02JugadorProtossonstruyeUnAccesoYLuegoDeAvanzarOchoTurnosElAccesoEstaOperableYCreaUnDragon() {
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
        }

        // Act
        jugadorProtoss.crearDragon(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();

        // Assert
        assertEquals(15, jugadorProtoss.calcularSuministroo());
    }

    @Test
    public void test03JugadorProtossonstruyeUnPuertoEstelarYLuegoDeAvanzarDiezTurnosElPuertoEstelarEstaOperableYCreaUnScout() {
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
        }

        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(2,2), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Puerto Estelar este operable y transporte unidades
        }

        // Act
        jugadorProtoss.crearScout(new Ubicacion(2,2), mapa);
        jugadorProtoss.avanzarTurno();

        // Assert
        assertEquals(20, jugadorProtoss.calcularSuministroo());
    }
}
