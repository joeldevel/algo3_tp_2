package edu.fiuba.algo3.modelo.Acceso;

public class AccesoUtilizable implements EstadoOperativoAcceso {
    private int vida;

    private int escudo;

    public AccesoUtilizable(int unaVida, int unEscudo) {
        this.vida = unaVida;
        this.escudo = unEscudo;
    }

    public boolean transportarTropas() {
        /* TBD. Por ahora devuelve True. */

        return true;
    }
}
