package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Recursos.Minerales.NodoMineral;
import edu.fiuba.algo3.modelo.Revelable;
import edu.fiuba.algo3.modelo.Superficie;
import edu.fiuba.algo3.modelo.Unidades.UnidadesProtoss.EstadosZealot.ZealotNoInvisible;

public interface TipoDeUnidad {

	void conNodo(NodoMineral nodo);

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

	void revelar(Revelable unRevelable);

	void serRevelado();

	void contarBaja();
}