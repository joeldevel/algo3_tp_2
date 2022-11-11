package edu.fiuba.algo3.modelo;

public class Zangano implements Minero {

    public Zangano() {

    }

    public Zangano(int cantidadMineralExtraidoPorTurno) {
        this.cantidadMineralExtraidoPorTurno = cantidadMineralExtraidoPorTurno;
    }

    public void setCantidadMineralExtraidoPorTurno(int cantidad) {
        this.cantidadMineralExtraidoPorTurno = cantidad;
    }

    @Override
    public void recibirMineral(Mineral mineral) {
        this.mineral = mineral;
    }


    @Override
    public void recolectarMineral(Mineral mineral, int cantidad) {
        this.mineralAcumulado = mineral.extraer(cantidad);
    }

    public void avanzarTurno() {
        this.recolectarMineral(this.mineral, this.cantidadMineralExtraidoPorTurno);
    }

    public int devolverMineralExtraido() {
        int mineralADevolver = this.mineralAcumulado;
        this.mineralAcumulado = 0;
        return mineralADevolver;
    }

    private int cantidadMineralExtraidoPorTurno = 0;
    private Mineral mineral;
    private int mineralAcumulado;

    public int cantidadRecolectableDeMineral;

    public Zangano(int unaCantidadRecolectable) {
        this.cantidadRecolectableDeMineral = unaCantidadRecolectable;
    }

    @Override
    public int recolectarMineralUsandoRecolectorDeMineral(NodoMineral unNodoMineral) {
        return unNodoMineral.recolectarMineral(this.cantidadRecolectableDeMineral);
    }
}
