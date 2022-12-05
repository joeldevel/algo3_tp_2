package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public interface Atacable {

	void recibirAtaque(int unDanio, Unidad unidadAtacante);
	Ubicacion ubicacion();
	boolean compararSuperficie(String otraSuperficie);
}
