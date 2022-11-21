package edu.fiuba.algo3.entrega_1.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.Recursos.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.Zealot;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZanganoTest {

    @Test
    void test01SeConstruyeUnZanganoEnUnNodoMineralYSeAvanzanTresTurnosDevuelveElResultadoIndicado() {
        // Arrange
        NodoMineral nodoMineral = new NodoMineral(2000);
        Zangano zangano = new Zangano(10);
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
        Zangano zangano = new Zangano(10);

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
        Zangano zangano = new Zangano(10); // Unidad de tierra

        // Act
        zealot.atacarA(zangano);

        // Assert
        assertEquals(17, zangano.obtenerVida());
    }
}