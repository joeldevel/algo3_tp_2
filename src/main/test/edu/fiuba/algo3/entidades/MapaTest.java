package edu.fiuba.algo3.entidades;

import edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss.Acceso;
import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Mapa;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import org.junit.jupiter.api.Test;

public class MapaTest {

    JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Rojo", new Recursos(1000, 1000));

    @Test
    void test01IntentoCrearUnMapaNuevoConCeroBasesYLanzaError() {
        // Arrange, Act and Assert
        assertThrows(CantidadInsuficienteDeBasesException.class,()->{
            Mapa mapa = new Mapa( 0);
        });
    }

    @Test
    void test02IntentoCrearUnMapaNuevoConUnaBaseYLanzaError() {
        // Arrange, Act and Assert
        assertThrows(CantidadInsuficienteDeBasesException.class,()->{
            Mapa mapa = new Mapa( 1);
        });
    }

    @Test
    void test03IntentoCrearUnMapaNuevoConUnaBaseNegativaYLanzaError() {
        // Arrange, Act and Assert
        assertThrows(CantidadInsuficienteDeBasesException.class,()->{
            Mapa mapa = new Mapa( -1);
        });
    }

    @Test
    void test04CreoUnaMapaNuevoConDosBasesYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 2);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test05CreoUnaMapaNuevoConTresBasesYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 3);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test06CreoUnaMapaNuevoConCuatroBasesYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 4);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test07CreoUnaMapaNuevoConCincoBasesYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 5);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test08CreoUnaMapaNuevoConSeisBasesYLaBaseDelPrimerJugadorEstaAlExtremoOpuestoDeLaDelSegundo() {
        // Arrange
        Mapa mapa = new Mapa( 6);

        // Act
        boolean resultado = mapa.basesEstanEnExtremosOpuestos();

        // Assert
        assertTrue(resultado);
    }

    /* ---------------------- Tests del movimiento de las unidades ---------------------- */

    /* Vista del mapa de 3 bases:

          T B
        T B E
        B E
    T = Terrestre
    E = Espacial
    B = Base

    Las bases de las esquinas son las de los jugadores

    En ubicaciones:

              (1,2) (2,2)
        (0,1) (1,1) (2,1)
        (0,0) (1,0)

     */

    @Test
    void test09AUnMapaDeTresBasesLePreguntoSiExisteLaUbicacionDeseadaYLaRespuestaEsVerdadera() {
        // Arrange
        Mapa mapa = new Mapa( 3);

        // Act
        boolean resultado = mapa.existeUbicacionEn(2, 2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test10AUnMapaDeTresBasesLePreguntoSiExisteLaUbicacionDeseadaYLaRespuestaEsFalsa() {
        // Arrange
        Mapa mapa = new Mapa( 3);

        // Act
        boolean resultado = mapa.existeUbicacionEn(3, 3);

        // Assert
        assertFalse(resultado);
    }

    @Test
    void test11AUnMapaDeTresBasesConUnaUnidadEnUnaPosicionLePreguntoSiEstaOcupadaYLaRespuestaEsVerdadera() {
        // Arrange
        Mapa mapa = new Mapa( 3);
        Ubicacion ubicacion = new Ubicacion(1, 1);
        Acceso acceso = new Acceso(ubicacion, jugadorProtoss);

        // Act
        mapa.ocuparUbicacion(ubicacion);
        boolean resultado = mapa.ubicacionOcupadaEn(1, 1);

        // Assert
        assertTrue(resultado);
    }

    @Test
    void test12AUnMapaDeTresBasesConUnaUnidadEnUnaPosicionLePreguntoSiOtraEstaOcupadaYLaRespuestaEsFalsa() {
        // Arrange
        Mapa mapa = new Mapa( 3);
        Ubicacion ubicacion = new Ubicacion(1, 1);
        Acceso acceso = new Acceso(ubicacion, jugadorProtoss);

        // Act
        mapa.ocuparUbicacion(ubicacion);
        boolean resultado = mapa.ubicacionOcupadaEn(2, 2);

        // Assert
        assertFalse(resultado);
    }
}
