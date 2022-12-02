package edu.fiuba.algo3.entrega_1.Unidades.UnidadesProtoss;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Mutalisco;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZealotTest {

    @Test
    void test01UnZealotAtacaAUnZerlingYLaVidaDelZerlingDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Zerling zerling = new Zerling(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        zealot.atacar(zerling);

        // Assert
        assertEquals(27, zerling.vidaRestante());
    }

    @Test
    void test02UnZealotAtacaAUnMutaliscoYLaVidaDelMutaliscoNoDisminuyeYaQueNoSonCompatibles(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        Mutalisco mutalisco = new Mutalisco(new Ubicacion(0,0), jugadorZerg); // Unidad de aire

        // Act
        zealot.atacar(mutalisco);

        // Assert
        assertEquals(120, mutalisco.vidaRestante());
    }
}