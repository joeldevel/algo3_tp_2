package edu.fiuba.algo3.entidades.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Hidralisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HidraliscoTest {

    @Test
    void test01UnHidraliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Hidralisco hidralisco = new Hidralisco(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra y aire
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Unidad de tierra

        // Act
        hidralisco.atacar(zealot);

        // Assert
        assertEquals(50, zealot.escudoRestante()); // Solo se considera el ataque de tierra del Hidralisco
    }

    @Test
    void test02UnHidraliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Hidralisco hidralisco = new Hidralisco(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra y aire
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Scout scout = new Scout(new Ubicacion(0,0), jugadorProtoss); // Unidad de aire

        // Act
        hidralisco.atacar(scout);

        // Assert
        assertEquals(90, scout.escudoRestante()); // Solo se considera el ataque de aire del Hidralisco
    }
}
