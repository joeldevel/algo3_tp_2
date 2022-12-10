package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.SuministroSuperaElNumeroDePoblacionException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorZergTest {

    @Test
    public void test01JugadorZergConstruyeUnCriaderoYLuegoDeAvanzarCuatroTurnosElCriaderoEstaOperableYCreaUnZangano() {
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa);

        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();
        jugadorZerg.avanzarTurno();

        // Act
        jugadorZerg.crearZangano(new Ubicacion(0,0), mapa);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministroo());
    }

    @Test
    public void test02JugadorZergConstruyeUnaReservaDeReproduccionYLuegoDeAvanzarDoceTurnosLaReservaDeReproduccionEstaOperableYCreaUnZerling() {
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa);

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
        }

        // Act
        jugadorZerg.crearZerling(new Ubicacion(1,1), mapa);

        // Assert
        assertEquals(1, jugadorZerg.calcularSuministroo());
    }

    @Test
    public void test03JugadorZergConstruyeUnaGuaridaYLuegoDeAvanzarDoceTurnosLaGuaridaEstaOperableYCreaUnHidralisco() {
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", new Recursos(50000, 50000));

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(50000, 50000));

        Mapa mapa = new Mapa();

        jugadorZerg.construir("Criadero", new Ubicacion(0,0), jugadorProtoss, mapa); // Debemos construir un Criadero debido al moho
        jugadorZerg.construir("ReservaDeReproduccion", new Ubicacion(1,1), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida
        jugadorZerg.construir("Guarida", new Ubicacion(1,2), jugadorProtoss, mapa); // Debemos construir una Reserva debido a que es condicion para una Guarida

        for(int i = 0; i < 13; i++) {
            jugadorZerg.avanzarTurno();
        }

        // Act
        jugadorZerg.crearHidralisco(new Ubicacion(1,2), mapa);

        // Assert
        assertEquals(2, jugadorZerg.calcularSuministroo());
    }
}
