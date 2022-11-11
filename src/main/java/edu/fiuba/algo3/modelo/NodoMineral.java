package edu.fiuba.algo3.modelo;

public class NodoMineral {

    private RecolectorDeMineral recolectorDeMineral;
    private int cantidadDeMineralDisponible;

    public NodoMineral(int unaCantidadDeMineral) {
        this.recolectorDeMineral = null;
        this.cantidadDeMineralDisponible = unaCantidadDeMineral;
    }

    public void construirRecolectorDeMineral(RecolectorDeMineral unRecolectorDeMineral) {
        /* Chequear que el tipo de parametro sea RecolectorDeMineral. En caso contrario, lanzar excepcion. */
        if(this.recolectorDeMineral != null) {
            throw new NodoMineralYaTieneUnRecolectorDeMineralException();
        }

        this.recolectorDeMineral = unRecolectorDeMineral;
    }

    public int recolectarMineralUsandoRecolectorDeMineral() {

        if(this.cantidadDeMineralDisponible == 0) {
            throw new NodoMineralSinMineralParaRecolectarException();
        }

        if(this.recolectorDeMineral == null) {
            throw new NodoMineralSinRecolectorDeMineralConstruidoException();
        }

        return this.recolectorDeMineral.recolectarMineralUsandoRecolectorDeMineral(this);
    }

    public int recolectarMineral(int unaCantidadDeMineralParaExtraer) {

        /* Caso borde donde por ejemplo tenemos 10 de mineral y nos piden 30. Deberiamos devolver esos 10 y dejar al Nodo Mineral en 0. */
        if(this.cantidadDeMineralDisponible < unaCantidadDeMineralParaExtraer) {
            unaCantidadDeMineralParaExtraer = this.cantidadDeMineralDisponible;
            this.cantidadDeMineralDisponible = 0;
            return unaCantidadDeMineralParaExtraer;
        }

        this.cantidadDeMineralDisponible = this.cantidadDeMineralDisponible - unaCantidadDeMineralParaExtraer;
        return unaCantidadDeMineralParaExtraer;
    }

    public NodoMineral(Mineral mineral) {
        this.mineral = mineral;
    }

    public Mineral getMineral() {
        return mineral;
    }

    private Mineral mineral;

}
