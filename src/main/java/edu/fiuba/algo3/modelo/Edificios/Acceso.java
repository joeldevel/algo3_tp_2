package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Tiempo;
import edu.fiuba.algo3.modelo.Vida;

public class Acceso extends EdificioProtoss{

	private final int COSTO_MINERAL = 150;
	private final int COSTO_GAS = 0;
	
    protected Acceso() {
		super(new Tiempo(-8),new Vida(500), new Escudo(500));
	}

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}

		
}
