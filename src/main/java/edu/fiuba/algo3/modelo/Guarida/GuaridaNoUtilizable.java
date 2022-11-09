package edu.fiuba.algo3.modelo.Guarida;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class GuaridaNoUtilizable implements EstadoOperativoGuarida {

    public GuaridaNoUtilizable() {
    }

    public boolean evolucionarLarva() {
        throw new EdificioNoOperativoException();
    }
}
