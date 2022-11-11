package edu.fiuba.algo3.modelo.Pilon;

public class PilonUtilizable implements EstadoOperativoPilon{
    private int vida;

    private int escudo;

    public PilonUtilizable(int unaVida, int unEscudo) {
        this.vida = unaVida;
        this.escudo = unEscudo;
    }

    public boolean energizar() {
        /* Por ahora devuelve True. */

        return true;
    }
}
