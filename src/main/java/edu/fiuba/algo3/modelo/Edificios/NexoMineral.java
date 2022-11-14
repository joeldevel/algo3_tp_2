package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class NexoMineral extends EdificioProtoss implements Minero {

    
    public NexoMineral() {
        super(new Vida(250,10), new Escudo(250,10));
    }
    
    @Override
    public Edificio construir() {
    	return (new NexoMineral());
    }

	@Override
	public int extraerMineralDe(NodoMineral unNodoMineral) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void recibirDanio(int unDanio) {
		// TODO Auto-generated method stub
		
	}

    
}