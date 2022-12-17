package edu.fiuba.algo3.modelo;

public abstract class Raza implements Atacable {
	
	protected Tiempo tiempo;
	protected Ubicacion ubicacion;
	
	public Raza(Tiempo unTiempo, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.ubicacion = unaUbicacion;
	}

	public int tiempoRestante() {
		return (this.tiempo.restante());
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

	public boolean estaEn(Ubicacion unaUbicacion) {
		return (this.ubicacion().esIgualA(unaUbicacion));
	}
}
