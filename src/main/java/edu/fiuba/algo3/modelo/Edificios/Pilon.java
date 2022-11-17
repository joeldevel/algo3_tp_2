package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public class Pilon extends EdificioProtoss {
    
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int radio;

    public Pilon() {
    	super(new Tiempo(-5),new Vida(300),new Escudo(300));
        this.radio = 3;
    }
    
    public void energizar(EdificioProtoss unEdificio) {
    	//falta la implementacion de este método
    }

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}


    
}