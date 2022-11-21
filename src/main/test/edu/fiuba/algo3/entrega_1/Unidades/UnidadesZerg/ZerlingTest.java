package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZerlingTest {

    @Test
    void test01UnZerlingAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Zerling zerling = new Zerling(); // Ataque de tierra
        Zealot zealot = new Zealot(); // Unidad de tierra

        // Act
        zerling.atacar(zealot);

        // Assert
        assertEquals(56, zealot.escudoRestante());
    }

    @Test
    void test02UnZerlingAtacaAUnScoutYElEscudoDelScoutNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        Zerling zerling = new Zerling(); // Ataque de tierra
        Scout scout = new Scout(); // Unidad de aire

        // Act
        zerling.atacar(scout);

        // Assert
        assertEquals(100, scout.escudoRestante());
    }
}