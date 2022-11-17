package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public class Espiral extends EdificioZerg {
  
	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 100;
	
	public Espiral(){
        super(new Tiempo(-10),new Vida(1300));
    }

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}

	
}
