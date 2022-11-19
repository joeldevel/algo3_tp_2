package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Recuperable;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;
import edu.fiuba.algo3.modelo.Vida;

public abstract class Edificio implements Atacable,Recuperable{
	
	
	protected Tiempo tiempo;
	protected Vida vida;
	protected Ubicacion ubicacion;
	protected EstadoOperativo estado;
	
	public Edificio(Tiempo unTiempo,Vida unaVida) {
		this.tiempo = unTiempo;
		this.vida = unaVida;
		this.ubicacion = new Ubicacion(0,0);
		this.estado = new EnConstruccion(this);
	}
	
	public Edificio(Tiempo unTiempo,Vida unaVida, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.vida = unaVida;
		this.ubicacion = unaUbicacion;
		this.estado = new EnConstruccion(this);
	}
	
	public void ejecutaEnConstruccion() {
		if(this.tiempo.restante() == 0) {
			this.estado = new Operable(this);
		};
	}
	
	public abstract void ejecutaOperable();
	
	public void avanzarTurno() {
		this.tiempo.pasarTiempo();
		this.estado.ejecutar();
		this.recuperarse();
	}
    
    public void avanzarTurno(int cantidad) {
    	if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
    }
    
    @Override
    public abstract void recuperarse();
    
    public int obtenerVida() {
    	return (this.vida.restante());
    }
	
    public int tiempoDeEspera() {
		return (this.tiempo.restante());
	}
    
    @Override
    public abstract void recibirAtaque(int unAtaque);
    
    @Override
    public Ubicacion ubicacion() {
    	return (this.ubicacion);
    }

}
