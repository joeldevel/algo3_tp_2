package edu.fiuba.algo3.modelo.Espiral;

public class Espiral {

    private EstadoOperativoEspiral estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Espiral(){
        this.tiempoDeConstruccion = -10;
        this.costoMineral = 150;
        this.costoGas = 100;
        this.estadoOperativo = new EspiralNoUtilizable();
    }

    public void setComportamientoUtilizable(EspiralUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new EspiralUtilizable(1300));
        }
    }
}
