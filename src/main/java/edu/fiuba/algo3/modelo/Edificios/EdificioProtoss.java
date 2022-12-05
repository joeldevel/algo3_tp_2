package edu.fiuba.algo3.modelo.Edificios;


import edu.fiuba.algo3.modelo.Energia;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Vida;

public abstract class EdificioProtoss extends Edificio {

    protected Escudo escudo;
    protected Energia energia;
       
    protected EdificioProtoss(Tiempo unTiempo,Vida unaVida,Escudo unEscudo,Ubicacion unaUbicacion, Jugador unJugador, String unIdentificador) {
    	super(unTiempo, unaVida, unaUbicacion, unJugador, unIdentificador);
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
    public void recibirAtaque(int unAtaque, Unidad unidadAtacante) {
    	if(unAtaque > this.escudo.restante()) {
    		int danioRestante = unAtaque - this.escudo.restante();
    		this.vida.recibirDanioPor(danioRestante, unidadAtacante, this, this.jugador);
    	}
    	this.escudo.recibirDanioPor(unAtaque);
    }

    public void energizar() {
    	this.energia.prenderEnergia();
    }
    
    public boolean estaEnergizado() {
    	return (this.energia.tieneEnergia());
    }
    
    
}