package edu.fiuba.algo3.modelo.Edificios;


import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;

public abstract class EdificioProtoss extends Edificio {

    protected Escudo escudo;
    protected Energia energia;
       
    protected EdificioProtoss(Tiempo unTiempo,Vida unaVida,Escudo unEscudo,Ubicacion unaUbicacion) {
    	super(unTiempo,unaVida,unaUbicacion);
    	this.escudo = unEscudo;
    	this.energia = new Energia();
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

    public void energizar() {
    	this.energia.prenderEnergia();
    }
    
    
}