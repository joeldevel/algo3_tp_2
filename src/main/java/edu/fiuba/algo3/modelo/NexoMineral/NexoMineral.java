package edu.fiuba.algo3.modelo.NexoMineral;

import edu.fiuba.algo3.modelo.*;

public class NexoMineral implements RecolectorDeMineral {

    private EstadoOperativoNexoMineral estadoOperativo;
    private int vidaMaxima;
    private int vidaRestante;
    private int escudoMaximo;
    private int escudoRestante;
    private int tiempoDeConstruccion;
    private int costoMineral;
    private int costoGas;
    private int cantidadRecolectable;

    public NexoMineral(int unaVida, int unEscudo, int unTiempoDeConstruccion, int unCostoMineral, int unCostoGas, int unaCantidadRecolectable) {
        this.vidaMaxima = unaVida;
        this.vidaRestante = unaVida;
        this.escudoMaximo = unEscudo;
        this.escudoRestante = unEscudo;
        this.tiempoDeConstruccion = unTiempoDeConstruccion;
        this.costoMineral = unCostoMineral;
        this.costoGas = unCostoGas;
        this.cantidadRecolectable = unaCantidadRecolectable;
        this.setComportamientoUtilizable(new NexoMineralNoUtilizable());
    }

    public void setComportamientoUtilizable(EstadoOperativoNexoMineral nuevoEstadoOperativo) {
        this.estadoOperativo = nuevoEstadoOperativo;
    }

    public void avanzarTurno() {

        if (tiempoDeConstruccion < 0) {
            this.tiempoDeConstruccion = this.tiempoDeConstruccion + 1;
        }

        if (tiempoDeConstruccion == 0) {
            this.setComportamientoUtilizable(new NexoMineralUtilizable(this.cantidadRecolectable));
        }

        if(this.vidaRestante < this.vidaMaxima) {
            this.recuperarVida();
        }
    }

    @Override
    public int recolectarMineralUsandoRecolectorDeMineral(NodoMineral unNodoMineral) {
        return unNodoMineral.recolectarMineral(this.estadoOperativo.recolectarMineral());
    }

    // Estos metodos van en la clase madre EdificioProtoss (avanzarTurno tambien pero se implementa aca, en la clase madre es abstracta)

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
