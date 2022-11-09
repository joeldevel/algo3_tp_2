package edu.fiuba.algo3.modelo.Espiral;

import edu.fiuba.algo3.modelo.EdificioZerg;

public class Espiral extends EdificioZerg {

    private EstadoOperativoEspiral estadoOperativo;

    public Espiral(int unaVida, int unTiempoDeConstruccion, int unCostoMineral, int unCostoGas){
        this.vidaMaxima = unaVida;
        this.vidaRestante = unaVida;
        this.tiempoDeConstruccion = unTiempoDeConstruccion;
        this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
        this.setComportamientoUtilizable(new EspiralNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoEspiral nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    @Override
    public void avanzarTurno() {

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }

        if(tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if(tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new EspiralUtilizable());
        }
    }
}
