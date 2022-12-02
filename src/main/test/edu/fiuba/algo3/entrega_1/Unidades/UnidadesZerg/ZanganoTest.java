package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorProtoss;
import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZanganoTest {

    @Test
    void test01SeConstruyeUnZanganoEnUnNodoMineralYSeAvanzanTresTurnosDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(new Ubicacion(0,0), jugadorZerg);
        zangano.conNodo(nodoMineral);

        // Act
        zangano.avanzarTurno();
        zangano.avanzarTurno();
        zangano.avanzarTurno();

        // Assert
        assertEquals(30, zangano.obtenerMineral());
    }

    @Test
    void test02UnZanganoQueNoEstaTrabajandoEnUnNodoMineralNoDeberiaRecolecarMineral() {
        // Arrange
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(new Ubicacion(0,0), jugadorZerg);

        // Act
        zangano.avanzarTurno();
        zangano.avanzarTurno();
        zangano.avanzarTurno();

        // Assert
        assertEquals(0, zangano.obtenerMineral());
    }

    @Test
    void test03UnZanganoEsAtacadoPorUnZealotYLaVidaDelZanganotDisminuyeLoIndicado(){
        // Arrange
        JugadorProtoss jugadorProtoss = new JugadorProtoss("Protoss", "Azul", new Recursos(1000,1000));
        Zealot zealot = new Zealot(new Ubicacion(0,0), jugadorProtoss); // Ataque de tierra
        Recursos recursos = new Recursos(0, 25);
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(new Ubicacion(0,0), jugadorZerg); // Unidad de tierra

        // Act
        zealot.atacar(zangano);

        // Assert
        assertEquals(17, zangano.vidaRestante());
    }
}