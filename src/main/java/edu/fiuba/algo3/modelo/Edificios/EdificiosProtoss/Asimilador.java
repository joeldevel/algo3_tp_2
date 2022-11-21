package edu.fiuba.algo3.modelo.Edificios.EdificiosProtoss;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;

public class Asimilador extends EdificioProtoss implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
    private int cantidadExtraible;
    private int cantidadExtraida;
    private Volcan volcan;
    
    public Asimilador(Volcan unVolcan, Recursos recursosJugador) {
    	super(new Tiempo(-6),new Vida(450),new Escudo(450));
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 20;
    	this.cantidadExtraida = 0;
    	this.volcan = unVolcan;
    	
    	unVolcan.construirRefineriaDeGas(this);
    }
    
    @Override
    public void ejecutaOperable() {
    	this.cantidadExtraida += this.extraerGasDe(this.volcan);
    }
    
    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible));
	}
	
	@Override
    public int obtenerGas() {
		int extraido = this.cantidadExtraida;
		this.cantidadExtraida = 0;
        return extraido;
    }

	@Override
	public boolean tieneRefineria() {
		return true;
	}
}
