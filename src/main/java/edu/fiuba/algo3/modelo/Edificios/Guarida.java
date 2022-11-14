package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Larva;

public class Guarida extends EdificioZerg {

    public Guarida(){
        super(new Vida(1250,10));
    }
    
    @Override
    public Edificio construir() {
    	return (new Guarida());
    }

    public void evolucionarLarva(Larva unaLarva) {
        // falta informacion de la evolucion
    }
    	
}