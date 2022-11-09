package edu.fiuba.algo3.modelo.Guarida;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class GuaridaUtilizable implements EstadoOperativoGuarida {

    private int vida;

    public GuaridaUtilizable(int unaVida) {
        this.vida = unaVida;
    }

    public boolean evolucionarLarva() {
        /* TBD. Por ahora devuelve True. */

        return true;
    }
}
