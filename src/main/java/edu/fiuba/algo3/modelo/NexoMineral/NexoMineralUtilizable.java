package edu.fiuba.algo3.modelo.NexoMineral;

public class NexoMineralUtilizable implements EstadoOperativoNexoMineral {

    private int vida;

    private int escudo;

    private int cantidadRecolectable;

    public NexoMineralUtilizable(int unaVida, int unEscudo, int unaCantidadRecolecatble) {
        this.vida = unaVida;
        this.escudo = unEscudo;
        this.cantidadRecolectable = unaCantidadRecolecatble;
    }

    @Override
    public int recolectarMineral() {
        return this.cantidadRecolectable;
    }
}
