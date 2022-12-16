package edu.fiuba.algo3.modelo.Recursos.Minerales;

import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinRecolectorDeMineralConstruidoException;

public class SinMinero implements Minero {

	public SinMinero() {
		
	}
	
	@Override
	public int recolectarMineralDe(Mineral unNodoMineral) {
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
