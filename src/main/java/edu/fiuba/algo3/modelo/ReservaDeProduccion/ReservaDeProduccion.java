package edu.fiuba.algo3.modelo.ReservaDeProduccion;

import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.Espiral.EspiralNoUtilizable;

public class ReservaDeProduccion extends EdificioZerg {

    private EstadoOperativoReservaDeProduccion estadoOperativo;

    public ReservaDeProduccion(){
        this.vidaMaxima = 1000;
        this.vidaRestante = 1000;
        this.tiempoDeConstruccion = -12;
        this.costoMineral = 150;
        this.costoGas = 0;
        this.setComportamientoUtilizable(new ReservaDeProduccionNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoReservaDeProduccion nuevoEstadoOperativo) {
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
            this.setComportamientoUtilizable(new ReservaDeProduccionUtilizable());
        }
    }
}