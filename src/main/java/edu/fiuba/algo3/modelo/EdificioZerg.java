package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioZerg {

    /*public int vidaMaxima;
    public int vidaRestante;
	public int tiempoDeConstruccion;*/

	protected Vida vida;
	protected Tiempo tiempo;
	protected ArrayList<RequisitoDeConstruccion> requisitos;
	protected ArrayList<CostoDeConstruccion> costos;
	/*protected int costoMineral;
    protected int costoGas;*/

    
    protected EdificioZerg(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
    					   ArrayList<CostoDeConstruccion> unosCostos) {
    	this.vida = unaVida;
    	this.tiempo = unTiempo;
    	this.requisitos = unosRequisitos;
    	this.costos = unosCostos;
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