package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.CantidadInsuficienteDeBasesException;
import edu.fiuba.algo3.modelo.Mapa;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MapaTest {

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

}
