package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Scout;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Guardian;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuardianTest {

    @Test
    void test01UnGuardianAtacaAUnZealotYElEscudoDelZealotDisminuyeLoIndicado(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Guardian guardian = new Guardian(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Unidad de tierra

        // Act
        guardian.atacar(zealot);

        // Assert
        assertEquals(35, zealot.escudoRestante());
    }

    @Test
    void test02UnGuardianAtacaAUnScoutYElEscudoDelScoutNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Guardian guardian = new Guardian(new Ubicacion(0,0), jugadorZerg); // Ataque de tierra
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Scout scout = new Scout(new Ubicacion(0,0), jugadorProtoss); // Unidad de aire

        // Act
        guardian.atacar(scout);

        // Assert
        assertEquals(100, scout.escudoRestante());
    }
}