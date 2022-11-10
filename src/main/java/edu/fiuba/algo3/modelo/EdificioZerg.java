package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioZerg {

    public int vidaMaxima;
    public int vidaRestante;

    public int tiempoDeConstruccion;

    public int costoMineral;

    public int costoGas;

    public ArrayList<RequisitoDeConstruccion> requisitos;

    public abstract void avanzarTurno();

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