package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Superficie;

public interface TipoDeUnidad {

	void conNodo(NodoMineral nodo);

	void setComportamientoUnidad(Unidad unaUnidad);

	int obtenerPoblacion();

	int obtenerSuministro();

	void recibirAtaque(int unDanio);

	Superficie obtenerSuperficie();

	void atacar(Atacable unAtacable);

	void recuperarse();

    void evolucionarAGuardian(Unidad unaUnidad);

	void evolucionarADevorador(Unidad unaUnidad);

	int vidaRestante();

	boolean compararSuperficie(String otraSuperficie);

    void avanzarTurno();
}