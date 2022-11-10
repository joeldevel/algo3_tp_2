package edu.fiuba.algo3.modelo.Guarida;

import edu.fiuba.algo3.modelo.EdificioZerg;

public class Guarida extends EdificioZerg {

    private EstadoOperativoGuarida estadoOperativo;

    public Guarida(int unaVida, int unTiempoDeConstruccion, int unCostoMineral, int unCostoGas){
        this.vidaMaxima = unaVida;
        this.vidaRestante = unaVida;
        this.tiempoDeConstruccion = unTiempoDeConstruccion;
        this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
        this.setComportamientoUtilizable(new GuaridaNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoGuarida nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new GuaridaUtilizable());
        }
    }
}