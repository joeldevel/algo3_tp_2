package edu.fiuba.algo3.entrega_1.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZealotTest {

    @Test
    void test01UnZealotAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange
        Zealot zealot = new Zealot(); // Ataque de tierra
        Zerling zerling = new Zerling(); // Unidad de tierra

        // Act
        zealot.atacar(zerling);

        // Assert
        assertEquals(27, zerling.vidaRestante());
    }

    @Test
    void test02UnZealotAtacaAUnMutaliscoYLaVidaDelMutaliscoNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        Zealot zealot = new Zealot(); // Ataque de tierra
        Mutalisco mutalisco = new Mutalisco(); // Unidad de aire

        // Act
        zealot.atacar(mutalisco);

        // Assert
        assertEquals(120, mutalisco.vidaRestante());
    }
}