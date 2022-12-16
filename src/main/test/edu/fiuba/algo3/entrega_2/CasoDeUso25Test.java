package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CasoDeUso25Test {

    @Test
    public void test01UnNombreDebeTenerAlMenosSeisCaracteres(){
        // Arrange
        AlgoStar algoStar = new AlgoStar();
        String nombreCorto = "abcde";

        // Act & Assert
        assertFalse(algoStar.validarNombre(nombreCorto));
    }

    @Test
    public void test02NoEsPosibleCrearUnJugadorQueTengaElMismoNombreQueOtroJugador(){
        // Arrange
        AlgoStar algoStar = new AlgoStar();
        algoStar.crearJugador("Alan0208", "Azul", "Zerg");
        String nombreRepetido = "Alan0208";

        // Act & Assert
        assertFalse(algoStar.validarNombre(nombreRepetido));
    }

    @Test
    public void test03NoEsPosibleCrearUnJugadorQueTengaElMismoColorQueOtroJugador(){
        // Arrange
        AlgoStar algoStar = new AlgoStar();
        algoStar.crearJugador("Alan", "Azul", "Zerg");
        String colorRepetido = "Azul";

        // Act & Assert
        assertFalse(algoStar.validarColor(colorRepetido));
    }

    @Test
    public void test04NoEsPosibleCrearUnJugadorQueTengaLaMismaRazaQueOtroJugador(){
        // Arrange
        AlgoStar algoStar = new AlgoStar();
        algoStar.crearJugador("Alan", "Azul", "Zerg");
        String razaRepetido = "Zerg";

        // Act & Assert
        assertFalse(algoStar.validarRaza(razaRepetido));
    }

    @Test
    public void test05SeIngresaUnaRazaQueNoEsNiZergNiProtossYSeLanzaUnaExcepcion(){
        // Arrange
        AlgoStar algoStar = new AlgoStar();
        String razaIncorrecta = "abc";

        // Act & Assert
        assertFalse(algoStar.validarRaza(razaIncorrecta));
    }
}
