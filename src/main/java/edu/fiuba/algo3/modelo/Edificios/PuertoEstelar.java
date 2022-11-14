package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Vida;
import edu.fiuba.algo3.modelo.Escudo;

public class PuertoEstelar extends EdificioProtoss {

    public PuertoEstelar(){
        super(new Vida(600,10),new Escudo(600,10));
    }
    
    @Override
    public Edificio construir() {
    	return (new PuertoEstelar());
    }

    public void transportarUnidades() {
        //falta implementación de este método
    }

	
}
