package edu.fiuba.algo3.modelo;

public class Zangano implements RecolectorDeMineral {

    public int cantidadRecolectableDeMineral;

    public Zangano(int unaCantidadRecolectable) {
        this.cantidadRecolectableDeMineral = unaCantidadRecolectable;
    }

    @Override
    public int recolectarMineralUsandoRecolectorDeMineral(NodoMineral unNodoMineral) {
        return unNodoMineral.recolectarMineral(this.cantidadRecolectableDeMineral);
    }
}
