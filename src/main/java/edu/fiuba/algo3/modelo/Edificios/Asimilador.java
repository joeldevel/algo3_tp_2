package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
    protected int maxExtraible;
    
    public Asimilador() {
    	super(new Tiempo(-6),new Vida(450),new Escudo(450));
    	this.maxExtraible = 20;
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

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}
}
