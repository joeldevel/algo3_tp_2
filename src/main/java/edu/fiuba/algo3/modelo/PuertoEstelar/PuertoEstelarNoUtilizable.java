package edu.fiuba.algo3.modelo.PuertoEstelar;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class PuertoEstelarNoUtilizable implements EstadoOperativoPuertoEstelar {

    public PuertoEstelarNoUtilizable() {
    }

    public boolean transportarUnidades() {
        throw new EdificioNoOperativoException();
    }
}
