package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Minero;
import edu.fiuba.algo3.modelo.NodoMineral;

public class Zangano implements Minero {

    public int cantidadRecolectableDeMineral;

    public Zangano(int unaCantidadRecolectable) {
        this.cantidadRecolectableDeMineral = unaCantidadRecolectable;
    }

	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		// TODO Auto-generated method stub
		return 0;
	}

}