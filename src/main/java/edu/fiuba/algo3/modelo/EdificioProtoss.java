package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioProtoss {

    protected Vida vida;
    protected Tiempo tiempo;
    protected ArrayList<RequisitoDeConstruccion> requisitos;
    protected ArrayList<CostoDeConstruccion> costos;
    protected Escudo escudo;
   /* protected int costoMineral;
    protected int costoGas;*/

    protected EdificioProtoss(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, 
    						  ArrayList<CostoDeConstruccion> unosCostos, Escudo unEscudo) {
    	this.vida = unaVida;
    	this.tiempo = unTiempo;
    	this.requisitos = unosRequisitos;
    	this.costos = unosCostos;
    	this.escudo = unEscudo;
    }
    
    public abstract void avanzarTurno();

    public void recibirDanio(int unDanio) {
    	if(unDanio > this.escudo.proteccion()) {
    		int danioRestante = unDanio - this.escudo.proteccion();
    		this.escudo.recibirDanioPor(unDanio);
    		this.vida.recibirDanioPor(danioRestante);
    	}
    	else {
    		this.escudo.recibirDanioPor(unDanio);
    	}
    }

    public int obtenerEscudo() {
        return (this.escudo.proteccion());
    }

    public void recuperarEscudo() {
        this.escudo.recuperarse();
    }
    
    public int obtenerVida() {
    	return (this.vida.restante());
    }
}