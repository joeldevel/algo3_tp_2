package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Atacable;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Vida;

public class Pilon extends EdificioProtoss implements Atacable {
    private int radio;

    public Pilon() {
    	super(new Vida(300,10),new Escudo(300,10));
        this.radio = 3;
    }
    
    @Override
    public Edificio construir() {
    	return (new Pilon());
    }
    
    public void energizar(EdificioProtoss unEdificio) {
    	//falta la implementacion de este método
    }

	@Override
	public void recibirAtaque(int cantidad) {
		// TODO Auto-generated method stub
		
	}

    
}