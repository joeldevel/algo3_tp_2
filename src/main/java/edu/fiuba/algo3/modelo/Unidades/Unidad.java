package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Ubicacion;

public class Unidad extends Raza{

	private TipoDeUnidad estado;
	private TipoDeUnidad tipo;
    
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo) {
		super(unTiempo,unaUbicacion);
		this.estado = new UnidadEnConstruccion();
		this.tipo = unTipo;
	}
	
	public void setComportamientoEstado(TipoDeUnidad nuevoEstado) {
		this.estado = nuevoEstado;
	}

	@Override
	public void recibirAtaque(int unDanio) {
		this.estado.recibirAtaque(unDanio);
	}

	@Override
	public Superficie obtenerSuperficie() {
		return (this.estado.obtenerSuperficie());
	}

	@Override
	public void atacar(Atacable unAtacable) {
		this.estado.atacar(unAtacable);
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return false;
	}

	@Override
	public void avanzarTurno() {

		this.tiempo.pasarTiempo();

		// Cambiar
		if(this.tiempoDeEspera() == 0) {
			this.setComportamientoEstado(this.tipo);
			this.estado.recuperarse();
		}

	}
}