package edu.fiuba.algo3.modelo.Recursos.Minerales;

import edu.fiuba.algo3.modelo.Excepciones.NodoMineralSinMineralParaRecolectarException;
import edu.fiuba.algo3.modelo.Recursos.Minerales.Mineral;

public class SinNodoMineral implements Mineral {

	@Override
	public int mineralRestante() {
		throw new NodoMineralSinMineralParaRecolectarException();
	}

	@Override
	public int recolectarMineral(int unaCantidad) {
		throw new NodoMineralSinMineralParaRecolectarException();
	}
	
	@Override
    public boolean tieneMineral() {
        return false;
    }

}
