package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.AlgoStar.AlgoStar;
import edu.fiuba.algo3.modelo.JUGADOR_COLOR;
import edu.fiuba.algo3.modelo.JUGADOR_RAZA;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CasoDeUso25Test {

    @Test
    @DisplayName("Un nombre debe tener longitud mínima")
    public void nombreInvalidoTest(){
        String nombreCorto = "abcde";
        AlgoStar algoStar = new AlgoStar();
        Assertions.assertFalse(algoStar.validarNombre(nombreCorto));
    }

    @Test
    @DisplayName("Dos jugadores no pueden tener el mismo nombre")
    public void nombreRepetidoTest(){
        String nombreJugador1 = "abcdef";
        String nombreJugador2 = "abcdef";
        String nombreJugador2Diferente = "abbcde";
        AlgoStar algoStar = new AlgoStar();
        Assertions.assertTrue(algoStar.validarNombre(nombreJugador1));
        Assertions.assertFalse(algoStar.validarNombre(nombreJugador2));
        Assertions.assertTrue(algoStar.validarNombre(nombreJugador2Diferente));

    }

    @Test
    @DisplayName("Dos jugadores no pueden tener el mismo color")
    public void colorRepetidoTest(){
        JUGADOR_COLOR colorJugador1 = JUGADOR_COLOR.AZUL;
        JUGADOR_COLOR colorJugador2 = JUGADOR_COLOR.AZUL;
        JUGADOR_COLOR colorJugador2Diferente = JUGADOR_COLOR.VERDE;
        AlgoStar algoStar = new AlgoStar();
        Assertions.assertTrue(algoStar.validarColor(colorJugador1));
        Assertions.assertFalse(algoStar.validarColor(colorJugador2));
        Assertions.assertTrue(algoStar.validarColor(colorJugador2Diferente));

    }

    @Test
    @DisplayName("Dos jugadores no pueden tener la misma raza")
    public void razasRepetidoTest(){
        JUGADOR_RAZA razaJugador1 = JUGADOR_RAZA.PROTOSS;
        JUGADOR_RAZA razaJugador2 = JUGADOR_RAZA.PROTOSS;
        JUGADOR_RAZA razaJugador2Diferente = JUGADOR_RAZA.ZERG;
        AlgoStar algoStar = new AlgoStar();
        Assertions.assertTrue(algoStar.validarRaza(razaJugador1));
        Assertions.assertFalse(algoStar.validarRaza(razaJugador2));
        Assertions.assertTrue(algoStar.validarRaza(razaJugador2Diferente));
    }
}
