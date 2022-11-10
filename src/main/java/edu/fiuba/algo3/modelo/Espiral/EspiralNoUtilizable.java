package edu.fiuba.algo3.modelo.Espiral;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoOperativoException;

public class EspiralNoUtilizable implements EstadoOperativoEspiral{

    public EspiralNoUtilizable() {

    }

    public boolean crear() {
        throw new EdificioNoOperativoException();
    }
}
