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
        mutalisco.atacarA(zealot);

        // Assert
        assertEquals(51, zealot.obtenerEscudo()); // Solo se considera el ataque de tierra del Mutalisco
    }

    @Test
    void test01UnMutaliscoAtacaAUnScoutYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Mutalisco mutalisco = new Mutalisco(); // Ataque de tierra y aire
        Scout scout = new Scout(); // Unidad de tierra

        // Act
        mutalisco.atacarA(scout);

        // Assert
        assertEquals(91, scout.obtenerEscudo()); // Solo se considera el ataque de aire del Mutalisco
    }
}