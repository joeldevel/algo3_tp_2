package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class NexoMineral extends EdificioProtoss implements Minero {

	private final int COSTO_MINERAL = 50;
	private final int COSTO_GAS = 0;
	
    public NexoMineral() {
        super(new Tiempo(-4),new Vida(250), new Escudo(250));
    }
    
	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
    
}