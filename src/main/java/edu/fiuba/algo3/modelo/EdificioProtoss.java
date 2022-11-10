package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioProtoss {

    public int vidaMaxima;
    public int vidaRestante;

    public int escudoMaximo;

    public int escudoRestante;

    public int tiempoDeConstruccion;

    public int costoMineral;

    public int costoGas;

    public ArrayList<RequisitoDeConstruccion> requisitos;

    public abstract void avanzarTurno();

    public void recibirDanio(int unDanio) {
        this.escudoRestante = this.escudoRestante - unDanio;
    }

    public int obtenerEscudo() {
        return this.escudoRestante;
    }

    public void recuperarEscudo() {
        this.escudoRestante = this.escudoRestante + 10;
    }
}