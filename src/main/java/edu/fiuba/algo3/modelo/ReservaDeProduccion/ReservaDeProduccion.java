package edu.fiuba.algo3.modelo.ReservaDeProduccion;

public class ReservaDeProduccion {

    private EstadoOperativoReservaDeProduccion estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public ReservaDeProduccion(){
        this.tiempoDeConstruccion = -12;
        this.costoMineral = 150;
        this.costoGas = 0;
        this.estadoOperativo = new ReservaDeProduccionNoUtilizable();
    }

    public void setComportamientoUtilizable(ReservaDeProduccionUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new ReservaDeProduccionUtilizable(1000));
        }
    }
}