package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmoSupremoTest {

    @Test
    void test01AmoSupremoRecibeDañoYSuVidaDisminuyeLoIndicado(){
        // Arrange
        Dragon dragon = new Dragon(); // Ataque de tierra y aire
        AmoSupremo amoSupremo = new AmoSupremo(); // Unidad de tierra

        // Act
        dragon.atacar(amoSupremo);

        // Assert
        assertEquals(180, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}
