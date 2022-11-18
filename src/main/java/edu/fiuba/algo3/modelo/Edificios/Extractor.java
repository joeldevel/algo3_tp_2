package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Excepciones.CantidadMaximaDeZanganosEnExtractorException;
import edu.fiuba.algo3.modelo.Unidades.Zangano;
import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int maxExtraible;
	private int extraido;
    private int maxZanganos;
    private Volcan volcan;
    private ArrayList<Zangano> zanganos;
    
    public Extractor(Volcan unVolcan){
    	super(new Tiempo(-6),new Vida(750));
    	this.maxExtraible = 10;
    	this.extraido = 0;
    	this.maxZanganos = 3;
    	this.volcan = unVolcan;
        this.zanganos = new ArrayList<Zangano>();
    }

    public void guardarZangano(Zangano zangano) {
    	if(this.contarZanganos() == this.maxZanganos) {
    		throw new CantidadMaximaDeZanganosEnExtractorException();
    	}
    	if(this.contarZanganos()<this.maxZanganos) {
    		this.zanganos.add(zangano);
    	}
    	
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    @Override
	public int extraerGasDe(Volcan unVolcan) {
		return (unVolcan.extraerGas(this.maxExtraible * this.contarZanganos()));
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