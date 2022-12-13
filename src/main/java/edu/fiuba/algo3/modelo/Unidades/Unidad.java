package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotNoInvisible;

import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.AMO_ALTO_RADIO;
import static edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.AmoSupremo.AMO_ANCHO_RADIO;

public class Unidad extends Raza {

	private TipoDeUnidad estado;
	private TipoDeUnidad tipo;
	private Direccion direccion;
    
	public Unidad(Tiempo unTiempo, Ubicacion unaUbicacion, TipoDeUnidad unTipo) {
		super(unTiempo, unaUbicacion);
		this.ubicacion.setPerimetro(AMO_ALTO_RADIO, AMO_ANCHO_RADIO);
		this.estado = new UnidadEnConstruccion();
		this.tipo = unTipo;
		unTipo.setComportamientoUnidad(this);
		this.direccion = new Direccion();
	}

	public TipoDeUnidad obtenerTipo() {
		return this.tipo;
	}

	// Se delega al tipo y no al estado, porque aunque este en construccion ya tiene un cupo reservado.
	public int obtenerSuministro() {
		return this.tipo.obtenerSuministro();
	}

	// Este metodo se utiliza cuando cambiamos el tipo de unidad. Ej: Cuando una larva evoluciona a Zangano.
	// Es necesario para poder setear el tiempo de construccion.
	public void setComportamientoTipo(Tiempo unTiempo, TipoDeUnidad nuevoTipo, Ubicacion unaUbicacion) {
		this.tiempo = unTiempo;
		this.ubicacion = unaUbicacion;
		this.estado = new UnidadEnConstruccion();
		this.tipo = nuevoTipo;
		nuevoTipo.setComportamientoUnidad(this);
	}

	// Este metodo se utiliza cuando el tiempo de construccion se cumplio.
	public void setComportamientoEstado(TipoDeUnidad nuevoEstado) {
		this.estado = nuevoEstado;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		this.estado.recibirAtaque(unDanio, unidadAtacante);
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

	public void revelar(Revelable unRevelable) {
		this.estado.revelar(unRevelable);
	}

	public void serRevelado() {
		this.estado.serRevelado();
	}

	public void contarBaja() {
		this.estado.contarBaja();
	}

	public void moverse(Mapa unMapa) {
		Ubicacion siguiente = this.direccion.obtenerSiguienteUbicacion(this.ubicacion);
		if(unMapa.verificarQueUnidadPuedeMoverseAUbicacion(this,siguiente)) {
			this.ubicacion = siguiente;
		}
	}
	
	public void cambiarDireccion() {
		this.direccion.cambiarDireccion();
	}
}