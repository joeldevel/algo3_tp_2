package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public abstract class Raza implements Atacable, Revelable{
	
	protected Tiempo tiempo;
	protected Ubicacion ubicacion;
	protected Jugador jugador;
	
	public Raza(Tiempo unTiempo, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.ubicacion = unaUbicacion;
	}

	public abstract int obtenerPoblacion();
	
	public abstract void avanzarTurno();
    
    public void avanzarTurno(int cantidad) {
    	if(cantidad > 0) {
    		for(int i=0; i< cantidad; i++) {
    			this.avanzarTurno();
    		}
    	}
    }

    @Override
   	public Ubicacion ubicacion() {
    	return (this.ubicacion);
    }
   	
    
}
