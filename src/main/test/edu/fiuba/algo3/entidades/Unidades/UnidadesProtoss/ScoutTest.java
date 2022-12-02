package edu.fiuba.algo3.entidades.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoutTest {

    @Test
    void test01UnScoutAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Scout scout = new Scout(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra y aire
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Zerling zerling = new Zerling(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        scout.atacar(zerling);

        // Assert
        assertEquals(27, zerling.vidaRestante()); // Solo se considera el ataque de tierra del Scout
    }

    @Test
    void test02UnScoutAtacaAUnGuardianYLaVidaDelGuardianDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Scout scout = new Scout(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra y aire
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Guardian guardian = new Guardian(new Ubicacion(0,0), jugadorZerg); // Unidad de aire

        // Act
        scout.atacar(guardian);

        // Assert
        assertEquals(86, guardian.vidaRestante()); // Solo se considera el ataque de aire del Scout
    }
}
