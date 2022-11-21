package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public abstract class EdificioZerg extends Edificio {

    protected EdificioZerg(Tiempo unTiempo,Vida unaVida) {
    	super(unTiempo,unaVida);
    }
    
    @Override
    public void recuperarse() {
    	this.vida.recuperarse();
    }
    
    @Override
    public void recibirAtaque(int unAtaque) {
    	this.vida.recibirDanioPor(unAtaque);
    }
    
    
}