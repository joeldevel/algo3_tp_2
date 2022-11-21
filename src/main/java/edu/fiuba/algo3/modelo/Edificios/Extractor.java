package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.Zangano;
import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int cantidadExtraible;
	private int cantidadExtraida;
    private int cantidadMaximaDeZanganos;
    private Volcan volcan;
    private ArrayList<Unidad> zanganos;
    
    public Extractor(Volcan unVolcan, Recursos recursosJugador){
    	super(new Tiempo(-6),new Vida(750));
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 10;
    	this.cantidadExtraida = 0;
    	this.cantidadMaximaDeZanganos = 3;
    	this.volcan = unVolcan;
        this.zanganos = new ArrayList<Unidad>();
    }
    
    @Override
    public void ejecutaOperable() {
    	this.cantidadExtraida += this.extraerGasDe(this.volcan);
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    public void guardarZangano(Unidad unaUnidad) {
    	
    	if(this.contarZanganos() == this.cantidadMaximaDeZanganos) {
    		throw new CantidadMaximaDeZanganosEnExtractorException();
    	}
    	this.zanganos.add(unaUnidad);
    	
    }

    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.cantidadExtraible * this.contarZanganos()));
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