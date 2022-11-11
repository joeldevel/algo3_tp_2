package edu.fiuba.algo3.modelo.Asimilador;

public class AsimiladorUtilizable implements EstadoOperativoAsimilador {

    private int cantidadExtraible;

    public AsimiladorUtilizable(int unaCantidadExtraible) {
        this.cantidadExtraible = unaCantidadExtraible;
    }

    @Override
    public int extraerGas(){
        return this.cantidadExtraible;
    }
}
