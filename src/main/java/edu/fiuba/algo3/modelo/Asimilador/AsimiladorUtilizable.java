package edu.fiuba.algo3.modelo.Asimilador;

public class AsimiladorUtilizable implements EstadoOperativoAsimilador {

    private int vida;
    private int escudo;
    private int cantidadExtraible;

    public AsimiladorUtilizable(int unaVida, int unEscudo, int unaCantidadExtraible) {
        this.vida = unaVida;
        this.escudo = unEscudo;
        this.cantidadExtraible = unaCantidadExtraible;
    }

    @Override
    public int extraerGas(){
        return this.cantidadExtraible;
    }
}
