package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

public class Unidad extends Raza {

	private TipoDeUnidad estado;
	private TipoDeUnidad tipo;
    
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo) {
		super(unTiempo, unaUbicacion);
		this.estado = new UnidadEnConstruccion();
		this.tipo = unTipo;
		unTipo.setComportamientoUnidad(this);
	}

	// Se delega al tipo y no al estado, porque aunque este en construccion ya tiene un cupo reservado.
	public int obtenerSuministro() {
		return this.tipo.obtenerSuministro();
	}

	// Este metodo se utiliza cuando cambiamos el tipo de unidad. Ej: Cuando una larva evoluciona a Zangano.
	// Es necesario para poder setear el tiempo de construccion.
	public void setComportamientoTipo(Tiempo unTiempo, TipoDeUnidad nuevoTipo) {
		this.tiempo = unTiempo;
		this.estado = new UnidadEnConstruccion();
		this.tipo = nuevoTipo;
	}

	// Este metodo se utiliza cuando el tiempo de construccion se cumplio.
	public void setComportamientoEstado(TipoDeUnidad nuevoEstado) {
		this.estado = nuevoEstado;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		this.estado.recibirAtaque(unDanio, unidadAtacante);
	}

	@Override
	public Superficie obtenerSuperficie() {
		return (this.estado.obtenerSuperficie());
	}

	public void atacar(Atacable unAtacable) {
		this.estado.atacar(unAtacable, this);
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return this.estado.compararSuperficie(otraSuperficie);
	}

	// Se delega al tipo y no al estado, porque aunque este en construccion ya aumenta la poblacion.
	@Override
	public int obtenerPoblacion() {
		return this.tipo.obtenerPoblacion();
	}

	@Override
	public void avanzarTurno() {

		this.tiempo.pasarTiempo();

		if(this.tiempo.transcurrido() == 0) {
			this.setComportamientoEstado(this.tipo);
		}

		else if(this.tiempo.transcurrido() > 0) {
			this.estado.recuperarse();
			this.estado.avanzarTurno();
		}
	}

	public void evolucionarAGuardian() {
		this.estado.evolucionarAGuardian(this);
	}

	public void evolucionarADevorador() {
		this.estado.evolucionarADevorador(this);
	}

	public int vidaRestante() {
		return this.estado.vidaRestante();
	}

	public void conNodo(NodoMineral nodo) {
		this.estado.conNodo(nodo);
	}

	public int escudoRestante() {
		return (this.estado.escudoRestante());
	}

	public void hacerseInvisible() {
		this.estado.hacerseInvisible();
	}
}