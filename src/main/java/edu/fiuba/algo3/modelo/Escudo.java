package edu.fiuba.algo3.modelo;

public class Escudo {

	private int proteccionMax;
	private int proteccionRestante;
	private int recuperacion;
	
	public Escudo(int unaProteccion, int unaRecuperacion) {
		if((unaProteccion <= 0) || (unaRecuperacion <= 0)) {
    		throw new ValorInvalidoParaEscudoError();
    	}
        this.proteccionMax = unaProteccion;
        this.proteccionRestante = unaProteccion;
        this.recuperacion = unaRecuperacion;
    }
	
	public void recibirDanioPor(int unaCantidad) {
    	if(unaCantidad < 0) {
    		throw new ValorInvalidoDeDanioError();
    	}
    	if(this.proteccionRestante >= unaCantidad) {
    		this.proteccionRestante -= unaCantidad;
    	}
    	else if(this.proteccionRestante < unaCantidad){
    		this.proteccionRestante = 0;
    	}
    }
	
	public int restante() {
		return this.proteccionRestante;
	}
	
	public void recuperarse() {
    	if(this.proteccionRestante + this.recuperacion <= this.proteccionMax) {
    		this.proteccionRestante+= this.recuperacion;
    	}
    	else if(this.proteccionRestante + this.recuperacion > this.proteccionMax) {
    		this.proteccionRestante = this.proteccionMax;
    	}
    }
	
	
	
}
