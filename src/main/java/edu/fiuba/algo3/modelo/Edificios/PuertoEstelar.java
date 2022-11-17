package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;

public class PuertoEstelar extends EdificioProtoss {

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 150;
	
    public PuertoEstelar(){
        super(new Tiempo(-10),new Vida(600),new Escudo(600));
    }
   
    public void transportarUnidades() {
        //falta implementación de este método
    }

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}

    
	
}
