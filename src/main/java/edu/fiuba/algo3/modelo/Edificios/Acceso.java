package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Escudo;
import edu.fiuba.algo3.modelo.Vida;

public class Acceso extends EdificioProtoss{

    protected Acceso() {
		super(new Vida(500,10), new Escudo(500,10));
	}

	@Override
	public Edificio construir() {
		return (new Acceso());
	}

	
}
