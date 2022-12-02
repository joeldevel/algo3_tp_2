package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.*;

public class Unidad extends Edificio implements Atacante {

	private TipoDeUnidad estado;
	private TipoDeUnidad tipo;
    
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo) {
		super(unTiempo, unaUbicacion);
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
	public int obtenerPoblacion() {
		return this.estado.obtenerPoblacion();
	}

	@Override
	public void avanzarTurno() {

		this.tiempo.pasarTiempo();

		if(this.tiempo.transcurrido() == 0) {
			this.setComportamientoEstado(this.tipo);
		}

		else if(this.tiempo.transcurrido() > 0) {
			this.estado.recuperarse();
		}
	}

	public void evolucionarAGuardian() {
		this.estado.evolucionarAGuardian(this);
	}

	public void evolucionarADevorador() {
		this.estado.evolucionarADevorador(this);
	}

	public int obtenerVida() {
		return this.estado.vidaRestante();
	}
}