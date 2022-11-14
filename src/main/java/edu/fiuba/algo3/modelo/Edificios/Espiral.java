package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public class Espiral extends EdificioZerg {
  
	public Espiral(){
        super(new Vida(1300,10));
    }

	@Override
	public Edificio construir() {
		return (new Espiral());
	}
	
}
