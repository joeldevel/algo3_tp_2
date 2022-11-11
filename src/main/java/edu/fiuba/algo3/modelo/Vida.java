package edu.fiuba.algo3.modelo;

public class Vida {

    private int vidaMax;
    private int vidaRestante;
    private int recuperacion;

    public Vida(int unaVida, int unaRecuperacion) {
    	if((unaVida <= 0) || (unaRecuperacion < 0)) { /* Modifico la recuperación de <= 0 a < 0 para que los Protoss no regeren vida. */
    		throw new ValorInvalidoParaVidaError();
    	}
        this.vidaMax = unaVida;
        this.vidaRestante = unaVida;
        this.recuperacion = unaRecuperacion;
    }
    
    public void recibirDanioPor(int unaCantidad) {
    	if(unaCantidad < 0) {
    		throw new ValorInvalidoDeDanioError();
    	}
    	if(this.vidaRestante >= unaCantidad) {
    		this.vidaRestante -= unaCantidad;
    	}
    	else if(this.vidaRestante < unaCantidad){
    		this.vidaRestante = 0;
    	}
    }
    
    public int restante() {
    	return this.vidaRestante;
    }
    
    public void recuperarse() {
    	if(this.vidaRestante + this.recuperacion <= this.vidaMax) {
    		this.vidaRestante += this.recuperacion;
    	}
    	else if(this.vidaRestante + this.recuperacion > this.vidaMax) {
    		this.vidaRestante = this.vidaMax;
    	}
    }
    
    

}