package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HidraliscoTest {

    @Test
    void test01UnHidraliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco(); // Ataque de tierra y aire
        Zealot zealot = new Zealot(); // Unidad de tierra

        // Act
        hidralisco.atacarA(zealot);

        // Assert
        assertEquals(50, zealot.obtenerEscudo()); // Solo se considera el ataque de tierra del Hidralisco
    }

    @Test
    void test02UnHidraliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado(){
        // Arrange
        Hidralisco hidralisco = new Hidralisco(); // Ataque de tierra y aire
        Scout scout = new Scout(); // Unidad de aire

        // Act
        hidralisco.atacarA(scout);

        // Assert
        assertEquals(90, scout.obtenerEscudo()); // Solo se considera el ataque de aire del Hidralisco
    }
}
