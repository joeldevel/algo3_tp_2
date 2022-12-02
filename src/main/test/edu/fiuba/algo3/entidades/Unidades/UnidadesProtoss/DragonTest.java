package edu.fiuba.algo3.entidades.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragonTest {

    @Test
    void test01UnDragonAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange

        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Dragon dragon = new Dragon(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra y aire
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Zerling zerling = new Zerling(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        dragon.atacar(zerling);

        // Assert
        assertEquals(15, zerling.vidaRestante()); // Solo se considera el ataque de tierra del Dragon
    }

    @Test
    void test02UnDragonAtacaAUnMutaliscoYLaVidaDelMutaliscoDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Dragon dragon = new Dragon(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra y aire
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Mutalisco mutalisco = new Mutalisco(new Ubicacion(0,0), jugadorZerg); // Unidad de aire

        // Act
        dragon.atacar(mutalisco);

        // Assert
        assertEquals(100, mutalisco.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}