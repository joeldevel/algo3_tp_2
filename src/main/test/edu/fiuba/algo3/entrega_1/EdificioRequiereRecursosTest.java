package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EdificioRequiereRecursosTest {

    @Test
    @DisplayName("No se puede crear un pilon con menos de 100M")
    public void creacionPilonSinRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearPilon());
    }

    @Test
    @DisplayName("Se puede crear un pilon con al menos de 100M")
    public void creacionPilonConRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearPilon);
    }

    @Test
    @DisplayName("Crear un pilon reduce los recursos según lo esperado")
    public void creacionPilonConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearPilon);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearPilon());
    }

    @Test
    @DisplayName("No se puede crear un nexo mineral con menos de 50M")
    public void creacionNexoMineralSinRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(49);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearNexo());

    }

    @Test
    @DisplayName("Se puede crear un nexo mineral con al menos de 50M")
    public void creacionNexoMineralConRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearNexo);
    }

    @Test
    @DisplayName("Crear un nexo mineral reduce los recursos según lo esperado")
    public void creacionNexoMineralConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearNexo);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearNexo());
    }

    @Test
    @DisplayName("No se puede crear un asimilador con menos de 100M")
    public void creacionAsimiladorSinRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearAsimilador());
    }

    @Test
    @DisplayName("Se puede crear un asimilador con al menos de 100M")
    public void creacionAsimiladorConRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearAsimilador);
    }

    @Test
    @DisplayName("Crear un asimilador reduce los recursos según lo esperado")
    public void creacionAsimiladorConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearAsimilador);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearAsimilador());
    }

    @Test
    @DisplayName("No se puede crear un acceso con menos de 150M")
    public void creacionAccesoSinRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearAcceso());
    }

    @Test
    @DisplayName("Se puede crear un acceso con al menos de 150M")
    public void creacionAccesoConRecursosSuficientesTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearAcceso);
    }

    @Test
    @DisplayName("Crear un acceso reduce los recursos según lo esperado")
    public void creacionAccesoConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearAcceso);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearAcceso());
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150M ")
    public void creacionPuertoEstelarSinMineralSuficienteTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearPuertoEstelar());
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150G ")
    public void creacionPuertoEstelarSinGasSuficienteTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarGas(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearPuertoEstelar());
    }

    @Test
    @DisplayName("Se puede crear un puerto estelar con al menos de 150M y 150G")
    public void creacionPuertoEstelarConMineralYGasSuficienteTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(150);
        jugadorProtoss.incrementarGas(150);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearPuertoEstelar);

    }

    @Test
    @DisplayName("Crear un puerto estelar reduce los recursos según lo esperado")
    public void creacionPuertoEstelarReduceRecursosTest() {
        JugadorProtoss jugadorProtoss = new JugadorProtoss();
        jugadorProtoss.incrementarMineral(150);
        jugadorProtoss.incrementarGas(150);
        Assertions.assertDoesNotThrow(jugadorProtoss::crearPuertoEstelar);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorProtoss.crearPuertoEstelar());
    }

    /******************** EDIFICIOS ZERG ****************/

    @Test
    @DisplayName("No se puede crear un criadero con menos de 50M")
    public void creacionCriaderoSinRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(49);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearCriadero());
    }

    @Test
    @DisplayName("Se puede crear un criadero con al menos 50M")
    public void creacionCriaderoConRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugadorZerg::crearCriadero);
    }

    @Test
    @DisplayName("Crear un criadero reduce los recursos según lo esperado")
    public void creacionCriaderoConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(50);
        Assertions.assertDoesNotThrow(jugadorZerg::crearCriadero);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearCriadero());
    }

    @Test
    @DisplayName("No se puede crear un extractor con menos de 100M")
    public void creacionExtractorSinRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearExtractor());
    }

    @Test
    @DisplayName("Se puede crear un extractor con al menos 100M")
    public void creacionExtractorConRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearExtractor);
    }

    @Test
    @DisplayName("Crear un extractor reduce los recursos según lo esperado")
    public void creacionExtractorConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearExtractor);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearExtractor());
    }

    @Test
    @DisplayName("No se puede crear una reserva con menos de 150M")
    public void creacionReservaSinRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearReservaDeProduccion());
    }

    @Test
    @DisplayName("Se puede crear una reserva con al menos 150M")
    public void creacionReservaConRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugadorZerg::crearReservaDeProduccion);
    }

    @Test
    @DisplayName("Crear una reserva reduce los recursos según lo esperado")
    public void creacionReservaConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(150);
        Assertions.assertDoesNotThrow(jugadorZerg::crearReservaDeProduccion);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearReservaDeProduccion());
    }


    @Test
    @DisplayName("No se puede crear una guarida con menos de 200M")
    public void creacionGuaridaSinMineralSuficienteTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(199);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearGuarida());
    }

    @Test
    @DisplayName("No se puede crear una guarida con menos de 100G")
    public void creacionGuaridaSinGasSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarGas(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearGuarida());
    }

    @Test
    @DisplayName("Se puede crear una guarida con al menos 200M y 100G")
    public void creacionGuaridaConRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.incrementarGas(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearGuarida);
    }

    @Test
    @DisplayName("Crear una guarida reduce los recursos según lo esperado")
    public void creacionGuaridaConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.incrementarGas(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearGuarida);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearGuarida());
    }

    @Test
    @DisplayName("No se puede crear un espiral con menos de 150M")
    public void creacionEspiralSinMineralSuficienteTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(149);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearEspiral());
    }

    @Test
    @DisplayName("No se puede crear un espiral con menos de 100G")
    public void creacionEspiralSinGasSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarGas(99);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearEspiral());
    }

    @Test
    @DisplayName("Se puede crear un espiral con al menos 150M y 100G")
    public void creacionEspiralConRecursosSuficientesTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(150);
        jugadorZerg.incrementarGas(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearEspiral);
    }

    @Test
    @DisplayName("Crear un espiral reduce los recursos según lo esperado")
    public void creacionEspiralConRecursosSuficientesYLuegoSinRecursosTest() {
        JugadorZerg jugadorZerg = new JugadorZerg();
        jugadorZerg.incrementarMineral(200);
        jugadorZerg.incrementarGas(100);
        Assertions.assertDoesNotThrow(jugadorZerg::crearEspiral);
        Assertions.assertThrows(CantidadInsuficienteDeRecursosException.class, () -> jugadorZerg.crearEspiral());
    }

}

