package edu.fiuba.algo3.modelo.Unidades.UnidadesZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Unidades.TipoDeUnidad;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public class Larva implements TipoDeUnidad {
	
	public Larva() {
	}

	@Override
	public void trabajarEn(NodoMineral nodo) {
		// Larva no entiende este mensaje.
	}

	public void setComportamientoUnidad(Unidad unaUnidad) {
		// No entiende este mensaje.
	}

	@Override
	public int obtenerPoblacion() {
		return 0;
	}

	@Override
	public int obtenerSuministro() {
		return 0;
	}

	@Override
	public void recibirAtaque(int unDanio, Unidad unidadAtacante) {
		// No entiende este mensaje.
	}

	@Override
	public void atacar(Atacable unAtacable, Unidad unidadAtacante) {
		// No entiende este mensaje.
	}

	@Override
	public void recuperarse() {
		// No entiende este mensaje.
		
	}

	@Override
	public void evolucionarAGuardian(Unidad unaUnidad) {
		// No entiende este mensaje.
	}

	@Override
	public void evolucionarADevorador(Unidad unaUnidad) {
		// No entiende este mensaje.
	}

	@Override
	public int vidaRestante() {
		return 0;
	}

	public int escudoRestante() {
		return 0;
	}

	public void hacerseInvisible() {
		// No entiende este mensaje.
	}

	@Override
	public boolean compararSuperficie(String otraSuperficie) {
		return false;
	}

	@Override
	public void avanzarTurno() {
		// ...
	}
	
	@Override
	public void revelar(Atacable unRevelable) {
		// No entiende este mensaje.
	}

	@Override
	public void serRevelado() {
		// No entiende este mensaje.
	}

	@Override
	public void contarBaja() {
		// No entiende este mensaje.
	}
}