package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;

public interface TipoDeUnidad {

	void trabajarEn(NodoMineral nodo);

	void setComportamientoUnidad(Unidad unaUnidad);

	int obtenerPoblacion();

	int obtenerSuministro();

	void recibirAtaque(int unDanio, Unidad unidadAtacante);

	void atacar(Atacable unAtacable, Unidad unidadAtacante);

	void recuperarse();

    void evolucionarAGuardian(Unidad unaUnidad);

	void evolucionarADevorador(Unidad unaUnidad);

	int vidaRestante();

	int escudoRestante();

	boolean compararSuperficie(String otraSuperficie);

    void avanzarTurno();

	void hacerseInvisible();
	
	void revelar(Atacable unRevelable);

	void serRevelado();

	void contarBaja();
}