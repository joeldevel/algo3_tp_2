package edu.fiuba.algo3.modelo.Guarida;

import edu.fiuba.algo3.modelo.EdificioZerg;

public class Guarida extends EdificioZerg {

    private EstadoOperativoGuarida estadoOperativo;

    public Guarida(){
        this.vidaMaxima = 1250;
        this.vidaRestante = 1250;
        this.tiempoDeConstruccion = -12;
        this.costoMineral = 200;
        this.costoGas = 100;
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