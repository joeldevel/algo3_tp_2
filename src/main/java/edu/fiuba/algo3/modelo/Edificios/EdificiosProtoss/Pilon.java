package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public class Pilon extends EdificioProtoss {
    
	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int radio;

    public Pilon(Recursos recursosJugador) {
    	super(new Tiempo(-5),new Vida(300),new Escudo(300));
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
        this.radio = 3;
    }
    
    @Override
    public void ejecutaOperable() {
    	// TODO Auto-generated method stub
    	
    }
    
    public void energizar(EdificioProtoss unEdificio) {
    	//falta la implementacion de este método
    }



    
}