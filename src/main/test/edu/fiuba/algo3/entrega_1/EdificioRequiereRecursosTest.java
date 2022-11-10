package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EdificioRequiereRecursosTest {

    @Test
    @DisplayName("No se puede crear un pilon con menos de 100M")
    public void creacionPilonSinRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearPilon());
    }

    @Test
    @DisplayName("Se puede crear un pilon con al menos de 100M")
    public void creacionPilonConRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugador::crearPilon);
    }

    @Test
    @DisplayName("Crear un pilon reduce los recursos según lo esperado")
    public void creacionPilonConRecursosSuficientesYLuegoSinRecursosTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugador::crearPilon);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearPilon());
    }

    @Test
    @DisplayName("No se puede crear un nexo mineral con menos de 50M")
    public void creacionNexoMineralSinRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(49);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearNexo());

    }

    @Test
    @DisplayName("Se puede crear un nexo mineral con al menos de 50M")
    public void creacionNexoMineralConRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugador::crearNexo);
    }

    @Test
    @DisplayName("Crear un nexo mineral reduce los recursos según lo esperado")
    public void creacionNexoMineralConRecursosSuficientesYLuegoSinRecursosTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugador::crearNexo);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearNexo());
    }

    @Test
    @DisplayName("No se puede crear un asimilador con menos de 100M")
    public void creacionAsimiladorSinRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearAsimilador());
    }

    @Test
    @DisplayName("Se puede crear un asimilador con al menos de 100M")
    public void creacionAsimiladorConRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugador::crearAsimilador);
    }

    @Test
    @DisplayName("Crear un asimilador reduce los recursos según lo esperado")
    public void creacionAsimiladorConRecursosSuficientesYLuegoSinRecursosTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugador::crearAsimilador);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearAsimilador());
    }

    @Test
    @DisplayName("No se puede crear un acceso con menos de 150M")
    public void creacionAccesoSinRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearAcceso());
    }

    @Test
    @DisplayName("Se puede crear un acceso con al menos de 150M")
    public void creacionAccesoConRecursosSuficientesTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugador::crearAcceso);
    }

    @Test
    @DisplayName("Crear un acceso reduce los recursos según lo esperado")
    public void creacionAccesoConRecursosSuficientesYLuegoSinRecursosTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugador::crearAcceso);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearAcceso());
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150M ")
    public void creacionPuertoEstelarSinMineralSuficienteTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearPuertoEstelar());
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150G ")
    public void creacionPuertoEstelarSinGasSuficienteTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarGas(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearPuertoEstelar());
    }

    @Test
    @DisplayName("Se puede crear un puerto estelar con al menos de 150M y 150G")
    public void creacionPuertoEstelarConMineralYGasSuficienteTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(150);
        jugador.incrementarGas(150);
        Assertions.assertDoesNotThrow(jugador::crearPuertoEstelar);

    }

    @Test
    @DisplayName("Crear un puerto estelar reduce los recursos según lo esperado")
    public void creacionPuertoEstelarReduceRecursosTest() {
        Jugador jugador = new Jugador();
        jugador.incrementarMineral(150);
        jugador.incrementarGas(150);
        Assertions.assertDoesNotThrow(jugador::crearPuertoEstelar);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugador.crearPuertoEstelar());
    }

}

