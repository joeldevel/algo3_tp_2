package edu.fiuba.algo3.modelo.ReservaDeProduccion;

import edu.fiuba.algo3.modelo.EdificioZerg;
import edu.fiuba.algo3.modelo.Espiral.EspiralNoUtilizable;

public class ReservaDeProduccion extends EdificioZerg {

    private EstadoOperativoReservaDeProduccion estadoOperativo;

    public ReservaDeProduccion(int unaVida, int unTiempoDeConstruccion, int unCostoMineral, int unCostoGas){
        this.vidaMaxima = unaVida;
        this.vidaRestante = unaVida;
        this.tiempoDeConstruccion = unTiempoDeConstruccion;
        this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
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