package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public abstract class Raza implements Atacable, Revelable{

	public static final int ALTO_RADIO = 20;
	public static final int ANCHO_RADIO = 20;
	
	protected Tiempo tiempo;
	protected Ubicacion ubicacion;
	protected Jugador jugador;
	
	public Raza(Tiempo unTiempo, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.ubicacion = unaUbicacion;
		this.ubicacion.setPerimetro(ALTO_RADIO, ANCHO_RADIO);
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
