package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Larva;

public class Guarida extends EdificioZerg {

	private final int COSTO_MINERAL = 200;
	private final int COSTO_GAS = 100;
	
    public Guarida(){
        super(new Tiempo(-12),new Vida(1250));
    }
    
    public void evolucionarLarva(Larva unaLarva) {
        // falta informacion de la evolucion
    }

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
    	
}