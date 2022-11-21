package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutaliscoTest {

    @Test
    void test01UnMutaliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco(); // Ataque de tierra y aire
        Zealot zealot = new Zealot(); // Unidad de tierra

        // Act
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, zealot.escudoRestante()); // Solo se considera el ataque de tierra del Mutalisco
    }

    @Test
    void test01UnMutaliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco(); // Ataque de tierra y aire
        Scout scout = new Scout(); // Unidad de tierra

        // Act
        mutalisco.atacar(scout);

        // Assert
        assertEquals(91, scout.escudoRestante()); // Solo se considera el ataque de aire del Mutalisco
    }
}