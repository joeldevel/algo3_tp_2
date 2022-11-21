package edu.fiuba.algo3.entrega_1.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragonTest {

    @Test
    void test01UnDragonAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange
        Dragon dragon = new Dragon(); // Ataque de tierra y aire
        Zerling zerling = new Zerling(); // Unidad de tierra

        // Act
        dragon.atacar(zerling);

        // Assert
        assertEquals(15, zerling.vidaRestante()); // Solo se considera el ataque de tierra del Dragon
    }

    @Test
    void test02UnDragonAtacaAUnMutaliscoYLaVidaDelMutaliscoDisminuyeLoIndicado(){
        // Arrange
        Dragon dragon = new Dragon(); // Ataque de tierra y aire
        Mutalisco mutalisco = new Mutalisco(); // Unidad de aire

        // Act
        dragon.atacar(mutalisco);

        // Assert
        assertEquals(100, mutalisco.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}