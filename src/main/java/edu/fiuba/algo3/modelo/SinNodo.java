package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;

public class SinNodo implements Mineral {

	@Override
	public int mineralRestante() {
		throw new NodoMineralSinMineralParaRecolectarException();
	}

	@Override
	public int recolectarMineral(int unaCantidad) {
		throw new NodoMineralSinMineralParaRecolectarException();
	}

}
