package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class EdificioZerg extends Edificio{

	
    protected EdificioZerg(Vida unaVida, Tiempo unTiempo, ArrayList<RequisitoDeConstruccion> unosRequisitos,
    					   ArrayList<CostoDeConstruccion> unosCostos) {
    	super(unaVida,unTiempo,unosRequisitos,unosCostos);
    }
    
    @Override
    protected abstract void avanzarTurno();
    
    @Override
    public void recibirDanio(int unDanio) {
    	this.vida.recibirDanioPor(unDanio);
    }

    @Override
    public void recuperarse() {
        this.vida.recuperarse();
    }
    
}