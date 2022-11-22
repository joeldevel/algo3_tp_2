package edu.fiuba.algo3.modelo.Edificios.EdificiosZerg;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioZerg;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Recursos.Gas.Volcan;
import edu.fiuba.algo3.modelo.Recursos.Recursos;
import edu.fiuba.algo3.modelo.Recursos.Gas.RefineriaDeGas;
import edu.fiuba.algo3.modelo.Unidades.Unidad;
import edu.fiuba.algo3.modelo.Unidades.UnidadesZerg.Zangano;

import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int cantidadExtraible;
	private int cantidadExtraida;
    private int cantidadMaximaDeZanganos;
    private Volcan volcan;
    private ArrayList<Zangano> zanganos;
    
    public Extractor(Volcan unVolcan, Recursos recursosJugador){
    	super(new Tiempo(-6),new Vida(750), new Ubicacion());
    	
    	recursosJugador.utilizar(COSTO_GAS, COSTO_MINERAL);
    	
    	this.cantidadExtraible = 10;
    	this.cantidadExtraida = 0;
    	this.cantidadMaximaDeZanganos = 3;
    	this.volcan = unVolcan;
        this.zanganos = new ArrayList<Zangano>();

		unVolcan.construirRefineriaDeGas(this);
    }
    
    @Override
    public void ejecutaOperable() {
    	this.cantidadExtraida += this.extraerGasDe(this.volcan);
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    public void guardarZangano(Zangano unZangano) {
    	
    	if(this.contarZanganos() == this.cantidadMaximaDeZanganos) {
    		throw new CantidadMaximaDeZanganosEnExtractorException();
    	}
    	this.zanganos.add(unZangano);
    	
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

	@Override
	public void atacar(Atacable unAtacable) {
		// No hace nada.
	}
}