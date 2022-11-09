package edu.fiuba.algo3.modelo.Pilon;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class PilonNoUtilizable implements EstadoOperativoPilon {
    public PilonNoUtilizable() {

    }

    public boolean energizar() {
        throw new EdificioNoOperativoException();
    }
}
