package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmoSupremoTest {

    @Test
    void test01UnaUnidadAtacaAAmoSupremoYSuVidaDisminuyeLoIndicado(){
        // Arrange
        Dragon dragon = new Dragon(); // Ataque de tierra y aire
        AmoSupremo amoSupremo = new AmoSupremo(); // Unidad de tierra

        // Act
        dragon.atacar(amoSupremo);

        // Assert
        assertEquals(180, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }

    @Test
    void test02UnaUnidadAtacaAAmoSupremoYSuVidaNoDisminuyeLoIndicadoYaQueNoSonCompatibles(){
        // Arrange
        Zealot zealot = new Zealot(); // Ataque de tierra
        AmoSupremo amoSupremo = new AmoSupremo(); // Unidad de tierra

        // Act
        zealot.atacar(amoSupremo);

        // Assert
        assertEquals(200, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}
