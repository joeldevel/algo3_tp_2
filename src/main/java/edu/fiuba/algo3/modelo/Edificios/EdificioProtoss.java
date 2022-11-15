package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Recuperable;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public abstract class EdificioProtoss extends Edificio implements Atacable,Recuperable {

    protected Escudo escudo;
       
    protected EdificioProtoss(Tiempo unTiempo,Vida unaVida,Escudo unEscudo) {
    	super(unTiempo,unaVida);
    	this.escudo = unEscudo;
    }
        
    @Override
    public void recuperarse() {
    	this.escudo.recuperarse();
    }

    public int obtenerEscudo() {
        return (this.escudo.restante());
    }
    
    @Override
    public void recibirAtaque(int unAtaque) {
    	if(unAtaque > this.escudo.restante()) {
    		int danioRestante = unAtaque - this.escudo.restante();
    		this.vida.recibirDanioPor(danioRestante);
    	}
    	this.escudo.recibirDanioPor(unAtaque);
    }

    
    
}