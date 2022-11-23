package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28 {

    @Test
    void test01UnZerlingAtacaAUnZealotYElEscudoDelZealotNoDisminuyePorqueEstaInvisible(){
        // Arrange
        Zerling zerling = new Zerling();
        Zealot zealot = new Zealot();

        // Act
        zealot.hacerseInvisible(); //Falta implementar lo de matar a tres unidades o edificios.
        zerling.atacar(zealot);

        // Assert
        assertEquals(60, zealot.escudoRestante());
    }

    /*@Test
    void test02UnAmoSupremoRevelaAUnZealotYAlAtacarloUnZerlingElEscudoDelZealotDisminuye(){
        // Arrange
        Zerling zerling = new Zerling();
        Zealot zealot = new Zealot();

        // Act
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.escudoRestante());
    }*/
}
