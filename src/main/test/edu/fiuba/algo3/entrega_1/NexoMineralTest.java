package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;
import edu.fiuba.algo3.modelo.NexoMineral.NexoMineral;
import edu.fiuba.algo3.modelo.Cristal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NexoMineralTest {

    @Test
    void test01SeConstruyeUnNexoMineralEnUnCristalYNoSeEncuentraOperativo() {
        // Arrange
        NexoMineral nexoMineral = new NexoMineral();
        Cristal cristal = new Cristal();
        cristal.construirRecolectorDeMineral(nexoMineral);

        // Act and Assert
        assertThrows(EdificioNoOperativoException.class, ()->{
            int mineralRecolectado = cristal.recolectarMineralUsandoRecolectorDeMineral();
        });
    }

    @Test
    void test02SeConstruyeunNexoMineralEnUnCristalYDespuesDeCuatroTurnosAlRecolectarMineralesDevuelveElResultadoIndicado() {
        // Arrange
        NexoMineral nexoMineral = new NexoMineral();
        Cristal cristal = new Cristal();
        cristal.construirRecolectorDeMineral(nexoMineral);

        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();
        nexoMineral.avanzarTurno();

        // Act
        int resultado = cristal.recolectarMineralUsandoRecolectorDeMineral();

        // Assert
        assertEquals(resultado, 10);

    }
}
