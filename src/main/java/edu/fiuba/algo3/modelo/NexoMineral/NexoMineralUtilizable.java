package edu.fiuba.algo3.modelo.NexoMineral;

public class NexoMineralUtilizable implements EstadoOperativoNexoMineral {

    private int vida;

    private int cantidadRecolectable;

    public NexoMineralUtilizable(int unaVida, int unaCantidadRecolecatble) {
        this.vida = unaVida;
        this.cantidadRecolectable = unaCantidadRecolecatble;
    }

    @Override
    public int recolectarMineral() {
        return this.cantidadRecolectable;
    }
}
