package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Larva;

public class ReservaDeProduccion extends EdificioZerg {
	
    public ReservaDeProduccion(){
        super(new Vida(1000,10));
    }
    
    @Override
    public Edificio construir() {
    	return (new ReservaDeProduccion());
    }

	public void evolucionarLarva(Larva unaLarva) {
		//
	}
		
}