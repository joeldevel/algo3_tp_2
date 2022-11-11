package edu.fiuba.algo3.modelo;

public class Cristal {

    private RecolectorDeMineral recolectorDeMineral;

    private int cantidadDeMineralesDisponible;

    public Cristal() {
        this.recolectorDeMineral = null;
        this.cantidadDeMineralesDisponible = 2000;
    }

    public void construirRecolectorDeMineral(RecolectorDeMineral unRecolectorDeMineral) {
        /* Chequear que el tipo de parametro sea RecolectorDeMineral. En caso contrario, lanzar excepcion. */
        this.recolectorDeMineral = unRecolectorDeMineral;
    }

    public int recolectarMineralUsandoRecolectorDeMineral() {
        return this.recolectorDeMineral.recolectarMineralUsandoRecolectorDeMineral(this);
    }

    public int recolectarMineral(int unaCantidadDeMineralParaExtraer) {
        /* Falta tener en cuenta el caso borde donde por ejemplo tenemos 20 de gas y nos piden 30. Deberiamos devolver esos 20. */
        return unaCantidadDeMineralParaExtraer;
    }
}
