package edu.fiuba.algo3.modelo.NexoMineral;

public class NexoMineralUtilizable implements EstadoOperativoNexoMineral {

    private int cantidadRecolectable;

    public NexoMineralUtilizable( int unaCantidadRecolecatble) {
        this.cantidadRecolectable = unaCantidadRecolecatble;
    }

    @Override
    public int recolectarMineral() {
        return this.cantidadRecolectable;
    }
}