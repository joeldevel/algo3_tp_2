package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Jugador.JugadorZerg;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZanganoTest {

    @Test
    void test01SeConstruyeUnZanganoEnUnNodoMineralYSeAvanzanTresTurnosDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral();
        Recursos recursos = new Recursos();
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(jugadorZerg);
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
        Recursos recursos = new Recursos();
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(jugadorZerg);

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
        Zealot zealot = new Zealot(); // Ataque de tierra
        Recursos recursos = new Recursos();
        JugadorZerg jugadorZerg = new JugadorZerg("Zerg", "Azul", recursos);
        Zangano zangano = new Zangano(jugadorZerg); // Unidad de tierra

        // Act
        zealot.atacar(zangano);

        // Assert
        assertEquals(17, zangano.vidaRestante());
    }
}