package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioError;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaEscudoError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Escudo {

	private int proteccionMax;
	private int proteccionRestante;
	
	public Escudo(int unaProteccion) {
		if(unaProteccion <= 0){
    		throw new ValorInvalidoParaEscudoError();
    	}
        this.proteccionMax = unaProteccion;
        this.proteccionRestante = unaProteccion;
    }
	
	public void recibirDanioPor(int unaCantidad, Edificio unEdificio, Jugador unJugador) {
    	if(unaCantidad < 0) {
    		throw new ValorInvalidoDeDanioError();
    	}
    	if(this.proteccionRestante >= unaCantidad) {
    		this.proteccionRestante -= unaCantidad;
    	}
    	else if(this.proteccionRestante < unaCantidad){
    		this.proteccionRestante = 0;
    		unJugador.eliminarEdificio(unEdificio);
    	}
    }
	
	public int restante() {
		return this.proteccionRestante;
	}
	
	public void recuperarse() {
    	if(this.proteccionRestante + this.recuperacion() <= this.proteccionMax) {
    		this.proteccionRestante+= this.recuperacion();
    	}
    	else if(this.proteccionRestante + this.recuperacion() > this.proteccionMax) {
    		this.proteccionRestante = this.proteccionMax;
    	}
    }
	
	 private int recuperacion(){
	    	return ((int)(this.proteccionMax * 0.05));
	    }
	
	
}
