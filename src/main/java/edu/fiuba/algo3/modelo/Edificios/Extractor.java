package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Unidades.Zangano;

import java.util.ArrayList;

public class Extractor extends EdificioZerg implements RefineriaDeGas {

	private final int COSTO_MINERAL = 100;
	private final int COSTO_GAS = 0;
	
	private int maxExtraible;
    private int maxZanganos;
    private ArrayList<Zangano> zanganos;
    
    public Extractor(){
    	super(new Tiempo(-6),new Vida(750));
    	this.maxExtraible = 10;
    	this.maxZanganos = 3;
        this.zanganos = new ArrayList<Zangano>();
    }

    public void guardarZangano(Zangano zangano) {
    	if(this.contarZanganos()<this.maxZanganos) {
    		this.zanganos.add(zangano);
    	}
    	
    }
    
    public int contarZanganos() {
    	return (this.zanganos.size());
    }

    @Override
	public int extraerGasDe(Volcan unVolcan) {
		int cantidadAExtraer = this.maxExtraible * this.contarZanganos();
		this.maxExtraible = 0;
		return (unVolcan.extraerGas(cantidadAExtraer));
	}
	
	public void reestablecerExtraible() {
		this.maxExtraible = 10;
	}

	@Override
	public void ejecutaOperable() {
		// TODO Auto-generated method stub
		
	}

}