package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.NodoMineral;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NexoMineralTest {

    @Test
    void test01SeConstruyeUnNexoMineralEnUnNodoMineralYNoSeEncuentraOperativo() {
        // Arrange
        NexoMineral nexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        NodoMineral nodoMineral = new NodoMineral(2000);
        nodoMineral.construirRecolectorDeMineral(nexoMineral);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class, ()->{
            int mineralRecolectado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();
        });
    }

    @Test
    void test02SeConstruyeUnNexoMineralEnUnNodoMineralYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        NexoMineral nexoMineral = new NexoMineral(250, 250, -4, 50, 0, 10);
        NodoMineral nodoMineral = new NodoMineral(2000);
        nodoMineral.construirRecolectorDeMineral(nexoMineral);

        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();

        // Act
        int resultado = nodoMineral.recolectarMineralUsandoRecolectorDeMineral();

        // Assert
        assertEquals(resultado, 10);
    }
}