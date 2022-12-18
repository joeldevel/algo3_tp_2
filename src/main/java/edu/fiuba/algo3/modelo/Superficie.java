package edu.fiuba.algo3.modelo;

public class Superficie {

    private String tipo;

    public Superficie(String unTipoDeSuperficie) {
        this.tipo = unTipoDeSuperficie;
    }

    public boolean atacableTieneLaMismaSuperficie(Atacable unAtacable) {
        return (unAtacable.compararSuperficie(this.tipo));
    }

    public boolean revelableTieneLaMismaSuperficie(Atacable unRevelable) {
        return (unRevelable.compararSuperficie(this.tipo));
    }

    public boolean compararTipos(String unTipo) {
        return (this.tipo.equals(unTipo));
    }
}