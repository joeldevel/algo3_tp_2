package edu.fiuba.algo3.modelo;

public abstract class Raza implements Atacable{
	
	protected Tiempo tiempo;
	protected Ubicacion ubicacion;
	
	public Raza(Tiempo unTiempo, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.ubicacion = unaUbicacion;
	}
	
	public abstract void avanzarTurno();
    
    public void avanzarTurno(int cantidad) {
    	if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
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
