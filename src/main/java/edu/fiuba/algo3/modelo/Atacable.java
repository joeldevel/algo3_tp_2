package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Unidades.Unidad;

public interface Atacable {

	void recibirAtaque(int unDanio, Unidad unidadAtacante);

	public Ubicacion ubicacion();

	public Superficie obtenerSuperficie();

	boolean compararSuperficie(String otraSuperficie);
}
