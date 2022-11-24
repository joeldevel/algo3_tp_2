package edu.fiuba.algo3.modelo;

public class Superficie {

    private String tipo;

    public Superficie(String unTipoDeSuperficie) {
        this.tipo = unTipoDeSuperficie;
    }
    
    public String obteneTipo() {
        return this.tipo;
    }

    public boolean atacableTieneLaMismaSuperficie(Atacable unAtacable) {
        return (unAtacable.compararSuperficie(this.tipo));
    }

    public boolean compararTipos(String unTipo) {
        return (this.tipo == unTipo);
    }

    // ¿Borrar?
    public boolean esIgualA(Superficie otraSuperficie) {
        return (this.tipo == otraSuperficie.obteneTipo());
    }
}