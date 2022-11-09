package edu.fiuba.algo3.modelo.Guarida;

public class Guarida {

    private EstadoOperativoGuarida estadoOperativo;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;

    public Guarida(){
        this.tiempoDeConstruccion = -12;
        this.costoMineral = 200;
        this.costoGas = 100;
        this.estadoOperativo = new GuaridaNoUtilizable();
    }

    public void setComportamientoUtilizable(GuaridaUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new GuaridaUtilizable(1250));
        }
    }

    public boolean evolucionarLarva() {
        return this.estadoOperativo.evolucionarLarva();
    }
}
