package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Unidades.Larva;

public class ReservaDeProduccion extends EdificioZerg {

    private final int COSTO_MINERAL = 150;
    private final int COSTO_GAS = 0;
    	
    public ReservaDeProduccion() {
    	super(new Tiempo(-12),new Vida(1000));    	
    }
    
	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
		
}