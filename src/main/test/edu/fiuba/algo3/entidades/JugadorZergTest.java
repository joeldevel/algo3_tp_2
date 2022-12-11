package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorZergTest {

    @Test
    public void test01JugadorZergCreaUnAmoSupremo() {
        // Arrange
        Mapa mapa = new Mapa();
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        // Act
        jugadorZerg.crearAmoSupremo(new Ubicacion(0,0));

        // Assert
        assertEquals(0, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test02JugadorZergConstruyeUnCriaderoYLuegoDeAvanzarCuatroTurnosElCriaderoEstaOperableYCreaUnZangano() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        for(int i = 0; i < 4; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.crearZangano(new Ubicacion(0,0));

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test03JugadorZergConstruyeUnaReservaDeReproduccionYLuegoDeAvanzarDoceTurnosLaReservaDeReproduccionEstaOperableYCreaUnZerling() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.crearZerling(new Ubicacion(1,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test04JugadorZergConstruyeUnaGuaridaYLuegoDeAvanzarDoceTurnosLaGuaridaEstaOperableYCreaUnHidralisco() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.crearHidralisco(new Ubicacion(1,2));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test05JugadorZergConstruyeUnaEspiralYLuegoDeAvanzarDiezTurnosLaEspiralEstaOperableYCreaUnMutalisco() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        // Act
        jugadorZerg.crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test06JugadorZergCreaUnMutaliscoYLoEvolucionaAGuardian() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        for(int i = 0; i < 7; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.evolucionarMutaliscoAGuardian(new Ubicacion(2,1));

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }

    @Test
    public void test07JugadorZergCreaUnMutaliscoYLoEvolucionaADevorador() {
        // Arrange
        Mapa mapa = new Mapa();

        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000), mapa);

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000), mapa);

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Guarida debido a que es condicion para una Espiral
        jugadorZerg.construir("Espiral", new Ubicacion(2,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.crearMutalisco(new Ubicacion(2,1));
        jugadorZerg.avanzarTurno();
        mapa.avanzarTurno();

        for(int i = 0; i < 7; i++) {
            jugadorZerg.avanzarTurno();
            mapa.avanzarTurno();
        }

        jugadorZerg.evolucionarMutaliscoADevorador(new Ubicacion(2,1));

        // Assert
        assertEquals(4, jugadorZerg.calcularSuministro());
    }
}