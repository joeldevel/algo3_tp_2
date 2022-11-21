package edu.fiuba.algo3.entrega_1.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoutTest {

    @Test
    void test01UnScoutAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange
        Scout scout = new Scout(); // Ataque de tierra y aire
        Zerling zerling = new Zerling(); // Unidad de tierra

        // Act
        scout.atacarA(zerling);

        // Assert
        assertEquals(27, zerling.obtenerVida()); // Solo se considera el ataque de tierra del Scout
    }

    @Test
    void test02UnScoutAtacaAUnGuardianYLaVidaDelGuardianDisminuyeLoIndicado(){
        // Arrange
        Scout scout = new Scout(); // Ataque de tierra y aire
        Guardian guardian = new Guardian(); // Unidad de aire

        // Act
        scout.atacarA(guardian);

        // Assert
        assertEquals(86, guardian.obtenerVida()); // Solo se considera el ataque de aire del Scout
    }
}
