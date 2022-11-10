package edu.fiuba.algo3.modelo.Pilon;

import edu.fiuba.algo3.modelo.Atacable;

public class PilonUtilizable implements EstadoOperativoPilon {
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

    @Override
    public int recibirAtaque(int cantidad) {
        if(cantidad > escudo) {
            cantidad -= escudo;
            escudo = 0;
            vida -= cantidad;
        } else {
            escudo -= cantidad;
        }
        return vida;
    }

}