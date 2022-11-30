package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoDeUso28Test {

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

    @Test
    void test02UnAmoSupremoRevelaAUnZealotYAlAtacarloUnZerlingElEscudoDelZealotDisminuye(){
        // Arrange
        AmoSupremo amoSupremo = new AmoSupremo();
        Zerling zerling = new Zerling();
        Zealot zealot = new Zealot();

        // Act
        amoSupremo.revelar(zealot);
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.escudoRestante());
    }

    @Test
    void test03UnAmoSupremoRevelaAUnZealotYAlAtacarloUnMutaliscoElEscudoDelZealotDisminuye(){
        // Arrange
        AmoSupremo amoSupremo = new AmoSupremo();
        Mutalisco mutalisco = new Mutalisco();
        Zealot zealot = new Zealot();

        // Act
        amoSupremo.revelar(zealot);
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, zealot.escudoRestante());
    }
}
