package edu.fiuba.algo3.modelo.Espiral;

import edu.fiuba.algo3.modelo.EdificioZerg;

public class Espiral extends EdificioZerg {

    private EstadoOperativoEspiral estadoOperativo;

    public Espiral(){
        this.vidaMaxima = 1300;
        this.vidaRestante = 1300;
        this.tiempoDeConstruccion = -10;
        this.costoMineral = 150;
        this.costoGas = 100;
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
