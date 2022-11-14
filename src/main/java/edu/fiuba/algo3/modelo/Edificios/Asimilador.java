package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

    protected int maxExtraible;
    
    public Asimilador() {
    	super(new Vida(450,10),new Escudo(450,10));
    	this.maxExtraible = 20;
    }
    
    @Override
    public Edificio construir() {
    	return (new Asimilador());
    }

	@Override
	public int extraerGasDe(Volcan unVolcan) {
		int cantidadAExtraer = this.maxExtraible;
		this.maxExtraible = 0;
		return (unVolcan.extraerGas(cantidadAExtraer));
	}
	
	public void reestrablecerExtraible() {
		this.maxExtraible = 20;
	}
}
