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
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.crearZealot(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(10, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test02JugadorProtossonstruyeUnAccesoYLuegoDeAvanzarOchoTurnosElAccesoEstaOperableYCreaUnDragon() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.crearDragon(new Ubicacion(1,1), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(15, jugadorProtoss.calcularSuministro());
    }

    @Test
    public void test03JugadorProtossonstruyeUnPuertoEstelarYLuegoDeAvanzarDiezTurnosElPuertoEstelarEstaOperableYCreaUnScout() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        jugadorProtoss.construir("Pilon", new Ubicacion(0,0), jugadorZerg, mapa); // Debemos construir un Pilon debido a la energia

        for(int i = 0; i < 6; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Pilon este operable y energice
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("Acceso", new Ubicacion(1,1), jugadorZerg, mapa);

        for(int i = 0; i < 9; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Acceso este operable y transporte unidades
            mapa.avanzarTurno();
        }

        jugadorProtoss.construir("PuertoEstelar", new Ubicacion(2,2), jugadorZerg, mapa);

        for(int i = 0; i < 10; i++) {
            jugadorProtoss.avanzarTurno(); // Avanzamos los turnos para que el Puerto Estelar este operable y transporte unidades
            mapa.avanzarTurno();
        }

        // Act
        jugadorProtoss.crearScout(new Ubicacion(2,2), mapa);
        jugadorProtoss.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(20, jugadorProtoss.calcularSuministro());
    }
}
