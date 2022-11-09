package edu.fiuba.algo3.modelo.NexoMineral;

import edu.fiuba.algo3.modelo.*;

public class NexoMineral implements RecolectorDeMineral {

    private EstadoOperativoNexoMineral estadoOperativo;

    private int vidaMaxima;

    private int vidaRestante;

    private int escudoMaximo;

    private int escudoRestante;

    private int tiempoDeConstruccion;

    public NexoMineral() {
        this.vidaMaxima = 250;
        this.vidaRestante = 250;
        this.escudoMaximo = 250;
        this.escudoRestante = 250;
        this.tiempoDeConstruccion = -4;
        this.estadoOperativo = new NexoMineralNoUtilizable();
    }

    public void setComportamientoUtilizable(NexoMineralUtilizable nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {
        if (tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        /* No específica cuanto mineral se puede llevar un NexoMineral. */
        if (tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new NexoMineralUtilizable(this.vidaMaxima, 10));
        }

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }
    }

    @Override
    public int recolectarMineralUsandoRecolectorDeMineral(Cristal unCristal) {
        return unCristal.recolectarMineral(estadoOperativo.recolectarMineral());
    }

    public void recibirDanio(int unDanio) {
        this.vidaRestante = this.vidaRestante - unDanio;
    }

    public int obtenerVida() {
        return this.vidaRestante;
    }

    public void recuperarVida() {
        this.vidaRestante = this.vidaRestante + 10;
    }
}
