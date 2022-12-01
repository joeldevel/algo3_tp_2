package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Superficie;

public interface TipoDeUnidad {

	int obtenerPoblacion();

	void recibirAtaque(int unDanio);

	Superficie obtenerSuperficie();

	void atacar(Atacable unAtacable);

	void recuperarse();

    void evolucionarAGuardian(Unidad unaUnidad);

	void evolucionarADevorador(Unidad unaUnidad);

	int vidaRestante();

	boolean compararSuperficie(String otraSuperficie);
}