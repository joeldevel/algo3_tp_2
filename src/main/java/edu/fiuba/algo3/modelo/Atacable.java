package edu.fiuba.algo3.modelo;

public interface Atacable {

    void recibirAtaque(int unAtaque);

	public Ubicacion ubicacion();

	public Superficie obtenerSuperficie();

	void atacar(Atacable unAtacable);

	boolean compararSuperficie(String otraSuperficie);
}
