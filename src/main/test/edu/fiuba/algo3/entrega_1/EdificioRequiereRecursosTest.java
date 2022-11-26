package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeRecursosException;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientesException;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Cambios en el nombre de la excepcion.
// Creacion de la clase recursos.
// Cambio en los parametros de los jugadores.
// Cambio en el nombre de las clases ya que no inician de la forma "test..."

// Deberiamos cambiar el nombre de la clase ya que en verdad se prueban las clases JugadorProtoss y JugadorZerg. Los recursos de cada edificio se prueban ya en cada edificio.

public class EdificioRequiereRecursosTest {

    /******************** EDIFICIOS PROTOSS ****************/

    @Test
    @DisplayName("No se puede crear un pilon con menos de 100M")
    public void test01creacionPilonSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearPilon(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear un pilon con al menos de 100M")
    public void test02creacionPilonConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearPilon(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear un pilon reduce los recursos según lo esperado")
    public void test03creacionPilonConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearPilon(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearPilon(new Ubicacion(1,1)));
    }

    @Test
    @DisplayName("No se puede crear un nexo mineral con menos de 50M")
    public void test04creacionNexoMineralSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,49);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearNexoMineral(new Ubicacion(0,0), new NodoMineral()));
    }

    @Test
    @DisplayName("Se puede crear un nexo mineral con al menos de 50M")
    public void test05creacionNexoMineralConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearNexoMineral(new Ubicacion(0,0), new NodoMineral()));
    }

    @Test
    @DisplayName("Crear un nexo mineral reduce los recursos según lo esperado")
    public void test06creacionNexoMineralConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,50);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearNexoMineral(new Ubicacion(0,0), new NodoMineral()));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearNexoMineral(new Ubicacion(0,0), new NodoMineral()));
    }

    @Test
    @DisplayName("No se puede crear un asimilador con menos de 100M")
    public void test07creacionAsimiladorSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,99);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearAsimilador(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("Se puede crear un asimilador con al menos de 100M")
    public void test08creacionAsimiladorConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearAsimilador(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("Crear un asimilador reduce los recursos según lo esperado")
    public void test09creacionAsimiladorConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearAsimilador(new Ubicacion(0,0), new Volcan()));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearAsimilador(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("No se puede crear un acceso con menos de 150M")
    public void test10creacionAccesoSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,149);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearAcceso(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear un acceso con al menos de 150M")
    public void test11creacionAccesoConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearAcceso(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear un acceso reduce los recursos según lo esperado")
    public void test12creacionAccesoConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearAcceso(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearAcceso(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150M ")
    public void test12creacionPuertoEstelarSinMineralSuficienteTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(150,149);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearPuertoEstelar(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear un puerto estelar con menos de 150G ")
    public void test13creacionPuertoEstelarSinGasSuficienteTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(149,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearPuertoEstelar(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear un puerto estelar con al menos de 150M y 150G")
    public void test14creacionPuertoEstelarConMineralYGasSuficienteTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(150,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearPuertoEstelar(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear un puerto estelar reduce los recursos según lo esperado")
    public void test15creacionPuertoEstelarReduceRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(150,150);
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", recursos);
        assertDoesNotThrow(() -> jugadorProtoss.crearPuertoEstelar(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorProtoss.crearPuertoEstelar(new Ubicacion(0,0)));
    }

    /******************** EDIFICIOS ZERG ****************/

    @Test
    @DisplayName("No se puede crear un criadero con menos de 200M")
    public void test16creacionCriaderoSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,199);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearCriadero(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear un criadero con al menos 200M")
    public void test17creacionCriaderoConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearCriadero(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear un criadero reduce los recursos según lo esperado")
    public void test18creacionCriaderoConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearCriadero(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearCriadero(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear un extractor con menos de 100M")
    public void test19creacionExtractorSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,99);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearExtractor(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("Se puede crear un extractor con al menos 100M")
    public void test20creacionExtractorConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearExtractor(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("Crear un extractor reduce los recursos según lo esperado")
    public void test21creacionExtractorConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,100);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearExtractor(new Ubicacion(0,0), new Volcan()));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearExtractor(new Ubicacion(0,0), new Volcan()));
    }

    @Test
    @DisplayName("No se puede crear una reserva con menos de 150M")
    public void test22creacionReservaSinRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearReservaDeProduccion(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear una reserva con al menos 150M")
    public void test23creacionReservaConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearReservaDeProduccion(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear una reserva reduce los recursos según lo esperado")
    public void test24creacionReservaConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(0,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearReservaDeProduccion(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearReservaDeProduccion(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear una guarida con menos de 200M")
    public void test25creacionGuaridaSinMineralSuficienteTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,199);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearGuarida(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear una guarida con menos de 100G")
    public void test26creacionGuaridaSinGasSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(99,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearGuarida(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear una guarida con al menos 200M y 100G")
    public void test27creacionGuaridaConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearGuarida(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear una guarida reduce los recursos según lo esperado")
    public void test28creacionGuaridaConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,200);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearGuarida(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearGuarida(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear un espiral con menos de 150M")
    public void test29creacionEspiralSinMineralSuficienteTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,149);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearEspiral(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("No se puede crear un espiral con menos de 100G")
    public void test30creacionEspiralSinGasSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(99,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearEspiral(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Se puede crear un espiral con al menos 150M y 100G")
    public void test31creacionEspiralConRecursosSuficientesTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearEspiral(new Ubicacion(0,0)));
    }

    @Test
    @DisplayName("Crear un espiral reduce los recursos según lo esperado")
    public void test32creacionEspiralConRecursosSuficientesYLuegoSinRecursosTest() {
        Recursos recursos = new Recursos();
        recursos.guardar(100,150);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        assertDoesNotThrow(() -> jugadorZerg.crearEspiral(new Ubicacion(0,0)));
        assertThrows(SinRecursosSuficientesException.class, () -> jugadorZerg.crearEspiral(new Ubicacion(0,0)));
    }
}