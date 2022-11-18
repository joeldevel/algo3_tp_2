package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
    private int maxExtraible;
    private int extraido;
    private Volcan volcan;
    
    public Asimilador(Volcan unVolcan) {
    	super(new Tiempo(-6),new Vida(450),new Escudo(450));
    	this.maxExtraible = 20;
    	this.extraido = 0;
    	this.volcan = unVolcan;
    }
    
    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.maxExtraible));
	}
	
	public void reestrablecerExtraible() {
		this.maxExtraible = 20;
	}

	@Override
    public void ejecutaOperable() {
        this.extraido += this.extraerGasDe(this.volcan);
    }
	
	@Override
    public int obtenerGas() {
		int cantidadExtraida = this.extraido;
		this.extraido = 0;
        return cantidadExtraida;
    }

	@Override
	public boolean tieneRefineria() {
		return true;
	}
}
