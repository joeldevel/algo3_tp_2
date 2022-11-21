package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardianTest {

    @Test
    void test01UnGuardianAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Guardian guardian = new Guardian(); // Ataque de tierra
        Zealot zealot = new Zealot(); // Unidad de tierra

        // Act
        guardian.atacarA(zealot);

        // Assert
        assertEquals(35, zealot.obtenerEscudo());
    }

    @Test
    void test02UnGuardianAtacaAUnScoutYElEscudoDelScoutNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        Guardian guardian = new Guardian(); // Ataque de tierra
        Scout scout = new Scout(); // Unidad de aire

        // Act
        guardian.atacarA(scout);

        // Assert
        assertEquals(100, scout.obtenerEscudo());
    }
}