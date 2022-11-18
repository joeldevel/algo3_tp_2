package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinRecolectorDeMineralConstruidoException;

public class SinMinero implements Minero {

	private NodoMineral nodo;
	
	public SinMinero(NodoMineral unNodo) {
		this.nodo = unNodo;
	}
	
	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		throw new NodoMineralSinRecolectorDeMineralConstruidoException();
	}

	@Override
	public int obtenerMineral() {
		throw new NodoMineralSinRecolectorDeMineralConstruidoException();
	}

	@Override
	public boolean tieneMinero() {
		// TODO Auto-generated method stub
		return false;
	}

}
