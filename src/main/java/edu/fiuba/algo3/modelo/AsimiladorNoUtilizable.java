package edu.fiuba.algo3.modelo;

public class AsimiladorNoUtilizable implements EstadoOperativoAsimilador {

    public AsimiladorNoUtilizable() {}

    @Override
    public int extraerGas() {
        throw new EdificioNoOperativoException();
    }
}
