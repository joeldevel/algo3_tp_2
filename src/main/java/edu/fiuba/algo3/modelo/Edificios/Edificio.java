package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Estado;
import edu.fiuba.algo3.modelo.Tiempo;

public interface Edificio {
	
	public boolean sePuedeUtilizar();
	
	/*
	private Tiempo tiempo;
	private Estado estado;
	
	public Edificio(Tiempo unTiempo,Estado unEstado) {
		this.tiempo = unTiempo;
		this.estado = unEstado;
	}
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		this.estado.actualizar(this.tiempo);
	}
    
    public void avanzarTurno(int cantidad) {
    	if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
    }
    
    public void recibirDanio(int unDanio) {
    	this.estado.recibirDanio(unDanio);
    }

    public int obtenerVida() {
    	return (this.estado.vidaRestante());
    }
	
    public int tiempoDeEspera() {
		return (this.tiempo.restante());
	}
*/
}
