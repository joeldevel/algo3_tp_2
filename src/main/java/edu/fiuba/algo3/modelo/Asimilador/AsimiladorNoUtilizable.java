package edu.fiuba.algo3.modelo.Asimilador;

import edu.fiuba.algo3.modelo.EdificioNoOperativoException;

public class AsimiladorNoUtilizable implements EstadoOperativoAsimilador {

    public AsimiladorNoUtilizable() {}

    @Override
    public int extraerGas() {
        throw new EdificioNoOperativoException();
    }
}
