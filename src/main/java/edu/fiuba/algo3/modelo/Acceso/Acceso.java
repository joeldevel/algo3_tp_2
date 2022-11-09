package edu.fiuba.algo3.modelo.Acceso;

public class Acceso {

    private EstadoOperativoAcceso estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Acceso(){
        this.tiempoDeConstruccion = -8;
        this.costoMineral = 150;
        this.costoGas = 0;
        this.estadoOperativo = new AccesoNoUtilizable();
    }

    public void setComportamientoUtilizable(AccesoUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new AccesoUtilizable(500, 500));
        }
    }

    public boolean transportarTropas() {
        return this.estadoOperativo.transportarTropas();
    }
}
