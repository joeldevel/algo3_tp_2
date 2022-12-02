package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MutaliscoTest {

    @Test
    void test01UnMutaliscoAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Mutalisco mutalisco = new Mutalisco(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra y aire
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Unidad de tierra

        // Act
        mutalisco.atacar(zealot);

        // Assert
        assertEquals(51, zealot.escudoRestante()); // Solo se considera el ataque de tierra del Mutalisco
    }

    @Test
    void test02UnMutaliscoAtacaAUnScoutYElEscudoDelScoutDisminuyeLoIndicado(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Mutalisco mutalisco = new Mutalisco(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra y aire
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Scout scout = new Scout(new Ubicacion(0,0), jugadorProtoss); // Unidad de tierra

        // Act
        mutalisco.atacar(scout);

        // Assert
        assertEquals(91, scout.escudoRestante()); // Solo se considera el ataque de aire del Mutalisco
    }
}