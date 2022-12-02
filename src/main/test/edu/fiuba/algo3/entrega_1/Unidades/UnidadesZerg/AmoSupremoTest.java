package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Dragon;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmoSupremoTest {

    @Test
    void test01UnaUnidadAtacaAAmoSupremoYSuVidaDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Dragon dragon = new Dragon(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra y aire
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        AmoSupremo amoSupremo = new AmoSupremo(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        dragon.atacar(amoSupremo);

        // Assert
        assertEquals(180, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }

    @Test
    void test02UnaUnidadAtacaAAmoSupremoYSuVidaNoDisminuyeLoIndicadoYaQueNoSonCompatibles(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Rojo", new Recursos(1000,1000));
        AmoSupremo amoSupremo = new AmoSupremo(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        zealot.atacar(amoSupremo);

        // Assert
        assertEquals(200, amoSupremo.vidaRestante()); // Solo se considera el ataque de aire del Dragon
    }
}
