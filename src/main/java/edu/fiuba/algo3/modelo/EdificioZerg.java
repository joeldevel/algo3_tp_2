package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioZerg {

    /*public int vidaMaxima;
    public int vidaRestante;
	public int tiempoDeConstruccion;*/

	protected Vida vida;
	protected ArrayList<RequisitoDeConstruccion> requisitos;
	protected Tiempo tiempo;


	public int costoMineral;
    public int costoGas;

    
    protected EdificioZerg(Vida unaVida, ArrayList<RequisitoDeConstruccion> unosRequisitos, Tiempo unTiempo) {
    	this.vida = unaVida;
    	this.requisitos = unosRequisitos;
    	this.tiempo = unTiempo;
    }

    protected abstract void avanzarTurno();

    public void recibirDanio(int unDanio) {
        /*this.vidaRestante = this.vidaRestante - unDanio;*/
    	this.vida.recibirDanioPor(unDanio);
    }

    public int obtenerVida() {
        /*return this.vidaRestante;*/
    	return (this.vida.restante());
    }

    public void recuperarVida() {
        /*this.vidaRestante = this.vidaRestante + 10;*/
    	this.vida.recuperarse();
    }
}