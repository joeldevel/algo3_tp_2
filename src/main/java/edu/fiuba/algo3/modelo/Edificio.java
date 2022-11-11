package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Edificio {
	
	protected Vida vida;
	protected Tiempo tiempo;
	protected ArrayList<RequisitoDeConstruccion> requisitos;
	protected ArrayList<CostoDeConstruccion> costos;
    
	protected Edificio(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
			   ArrayList<CostoDeConstruccion> unosCostos) {
		this.vida = unaVida;
		this.tiempo = unTiempo;
		this.requisitos = unosRequisitos;
		this.costos = unosCostos;
	}
	
	protected abstract void avanzarTurno();
    
    public void avanzarTurno(int cantidad) {
    	if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
    }
    
    public abstract void recibirDanio(int unDanio);

    public int obtenerVida() {
    	return (this.vida.restante());
    }

    public abstract void recuperarse();
    
    public ArrayList<RequisitoDeConstruccion> requisitos(){
    	return this.requisitos;
    }
    
    public ArrayList<CostoDeConstruccion> costos(){
    	return this.costos;
    }

    public abstract Moho moho();

	
}
