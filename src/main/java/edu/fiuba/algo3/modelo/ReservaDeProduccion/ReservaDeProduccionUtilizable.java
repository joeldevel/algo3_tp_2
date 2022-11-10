package edu.fiuba.algo3.modelo.ReservaDeProduccion;

public class ReservaDeProduccionUtilizable implements EstadoOperativoReservaDeProduccion {

    private int vida;

    public ReservaDeProduccionUtilizable(int unaVida) {
        this.vida = unaVida;
    }

    public boolean evolucionarLarva() {
        /* TBD. Por ahora devuelve True. */

        return true;
    }
}