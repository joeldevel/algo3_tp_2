package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Estado;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public abstract class Edificio {
	
	
	protected Tiempo tiempo;
	protected Vida vida;
	protected Estado estado;
	
	public Edificio(Tiempo unTiempo,Vida unaVida) {
		this.tiempo = unTiempo;
		this.vida = unaVida;
		this.estado = new EnConstruccion(this);
	}
	
	public void ejecutaEnConstruccion() {
		
	}
	
	public abstract void ejecutaOperable();
	
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
