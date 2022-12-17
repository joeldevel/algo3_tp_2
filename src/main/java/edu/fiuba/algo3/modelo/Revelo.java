package edu.fiuba.algo3.modelo;

public class Revelo {

    private Superficie superficie;
    private int rango;

    public Revelo(Superficie unaSuperficie, int unRango) {
        this.superficie = unaSuperficie;
        this.rango = unRango;
    }

    public int rango() {
        return (this.rango);
    }
    
    public void revelarA(Atacable unRevelable) {
        if(this.superficie.revelableTieneLaMismaSuperficie(unRevelable)){
            unRevelable.serRevelado();
        }
    }
}
