package edu.fiuba.algo3.modelo.Acceso;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class AccesoNoUtilizable implements EstadoOperativoAcceso{
    public AccesoNoUtilizable() {
    }

    public boolean transportarTropas() {
        throw new EdificioNoOperativoException();
    }
}
