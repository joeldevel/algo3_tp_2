package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioProtoss extends Edificio {

    protected Escudo escudo;
       
    protected EdificioProtoss(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos, 
    						  ArrayList<CostoDeConstruccion> unosCostos, Escudo unEscudo) {
    	super(unaVida,unTiempo,unosRequisitos,unosCostos);
    	this.escudo = unEscudo;
    }
    
    @Override
    public abstract void avanzarTurno();

    @Override
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
    
    @Override
    public void recuperarse() {
    	this.vida.recuperarse();
    	this.escudo.recuperarse();
    }

    public int obtenerEscudo() {
        return (this.escudo.proteccion());
    }

    
    
}