package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Atacante;
import edu.fiuba.algo3.modelo.Superficie;

public interface TipoDeUnidad {

	void recibirAtaque(int unDanio);

	Superficie obtenerSuperficie();

	void atacar(Atacable unAtacable);

	void recuperarse();
}