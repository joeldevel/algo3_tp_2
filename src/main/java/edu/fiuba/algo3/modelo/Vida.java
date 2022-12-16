package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoDeDanioException;
import edu.fiuba.algo3.modelo.Excepciones.ValorInvalidoParaVidaException;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Vida {
	
	private static double MULTIPLICADOR = 0.05;

    private int vidaMax;
    private int vidaRestante;

    public Vida(int unaVida) {
    	if(unaVida <= 0) {
    		throw new ValorInvalidoParaVidaException();
    	}
        this.vidaMax = unaVida;
        this.vidaRestante = unaVida;
    }

	public void recibirDanioPor(int unaCantidad, Unidad unidadAtacante, Unidad unidadAtacada, Jugador unJugadorAtacado) {
		if(unaCantidad < 0) {
			throw new ValorInvalidoDeDanioException();
		}
		if(this.vidaRestante > unaCantidad) {
			this.vidaRestante -= unaCantidad;
		}
		else if(this.vidaRestante <= unaCantidad){
			this.vidaRestante = 0;
			unJugadorAtacado.destruirUnidad(unidadAtacada);
			unidadAtacante.contarBaja();
		}
	}
    
    public void recibirDanioPor(int unaCantidad, Unidad unidadAtacante, Edificio edificioAtacado, Jugador unJugadorAtacado) {
    	if(unaCantidad < 0) {
    		throw new ValorInvalidoDeDanioException();
    	}
    	if(this.vidaRestante > unaCantidad) {
    		this.vidaRestante -= unaCantidad;
    	}
    	else if(this.vidaRestante <= unaCantidad){
    		this.vidaRestante = 0;
			unJugadorAtacado.destruirEdificio(edificioAtacado);
    	}
    }
    
    public int restante() {
    	return this.vidaRestante;
    }
    
    public void recuperarse() {
    	if(this.vidaRestante + this.recuperacion() <= this.vidaMax) {
    		this.vidaRestante += this.recuperacion();
    	}
    	else if(this.vidaRestante + this.recuperacion() > this.vidaMax) {
    		this.vidaRestante = this.vidaMax;
    	}
    }
    
    private int recuperacion(){
    	return ((int)(this.vidaMax * MULTIPLICADOR));
    }
}