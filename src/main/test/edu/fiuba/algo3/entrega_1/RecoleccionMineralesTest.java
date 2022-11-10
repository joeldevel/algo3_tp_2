package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RecoleccionMineralesTest {

    @Test
    @DisplayName("Un zángano extrae 10 unidades de mineral en 1 turno ")
    public void extraccionDeMineralConUnZanganoTest() {

        NodoMineral nodoMineral = new NodoMineral(new Mineral(10));
        Zangano zangano = new Zangano();
        zangano.setCantidadMineralExtraidoPorTurno(10);
        zangano.recibirMineral(nodoMineral.getMineral());
        zangano.avanzarTurno();
        Assertions.assertEquals(10, zangano.devolverMineralExtraido());
    }

    @Test
    @DisplayName("Un zángano extrae 0 al extraer un nodo mineral agotado")
    public void extraccionDeMineralConUnZanganoNodoAgotadoTest() {

        NodoMineral nodoMineral = new NodoMineral(new Mineral(0));
        Zangano zangano = new Zangano();
        zangano.setCantidadMineralExtraidoPorTurno(10);
        zangano.recibirMineral(nodoMineral.getMineral());
        zangano.avanzarTurno();
        Assertions.assertEquals(0, zangano.devolverMineralExtraido());
        zangano.avanzarTurno();
        Assertions.assertEquals(0, zangano.devolverMineralExtraido());

    }

    @Test
    @DisplayName("Un nexo mineral extrae 10 unidades de mineral en 1 turno")
    public void extraccionDeMineralConUnNexoMineralTest() {

        NodoMineral nodoMineral = new NodoMineral(new Mineral(10));
        NexoMineral nexoMineral = new NexoMineral();
        nexoMineral.recibirMineral(nodoMineral.getMineral());
        nexoMineral.setCantidadMineralExtraidoPorTurno(10);
        nexoMineral.avanzarTurno();
        Assertions.assertEquals(10, nexoMineral.devolverMineralExtraido());

    }

    @Test
    @DisplayName("Un nexo mineral extrae 0 al extraer un nodo mineral agotado")
    public void extraccionDeMineralConUnNexoMineralConNodoAgotadoTest() {

        NodoMineral nodoMineral = new NodoMineral(new Mineral(0));
        NexoMineral nexoMineral = new NexoMineral();
        nexoMineral.recibirMineral(nodoMineral.getMineral());
        nexoMineral.setCantidadMineralExtraidoPorTurno(10);
        nexoMineral.avanzarTurno();
        Assertions.assertEquals(0, nexoMineral.devolverMineralExtraido());
        nexoMineral.avanzarTurno();
        Assertions.assertEquals(0, nexoMineral.devolverMineralExtraido());

    }

}
