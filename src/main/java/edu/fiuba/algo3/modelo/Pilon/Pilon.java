package edu.fiuba.algo3.modelo.Pilon;

public class Pilon {
    private EstadoOperativoPilon estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Pilon(){
        this.tiempoDeConstruccion = -5;
        this.costoMineral = 100;
        this.costoGas = 0;
        this.estadoOperativo = new PilonNoUtilizable();
    }

    public void setComportamientoUtilizable(PilonUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new PilonUtilizable(300, 300));
        }
    }

    public boolean energizar() {
        return this.estadoOperativo.energizar();
    }
}
